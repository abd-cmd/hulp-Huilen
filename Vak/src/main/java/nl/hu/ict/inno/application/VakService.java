package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;

import nl.hu.ict.inno.application.RestTemplateServices.OpleidingRestTemplate;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.domain.*;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;

import nl.hu.ict.inno.domain.vakGegevens.HerkansingGegevens;
import nl.hu.ict.inno.domain.vakGegevens.IngangEisen;
import nl.hu.ict.inno.domain.vakGegevens.LoopTijd;
import nl.hu.ict.inno.domain.vakGegevens.ToetsGegevens;
import nl.hu.ict.inno.presentation.controller.messaging.VakProducer;
import nl.hu.ict.inno.presentation.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VakService {
    private VakRepository vakRepository;
    private OpleidingRestTemplate opleidingRestTemplate;
    private VakProducer vakProducer;

    public VakService(VakRepository vakRepository, OpleidingRestTemplate opleidingRestTemplate, VakProducer vakProducer) {
        this.vakRepository = vakRepository;
        this.opleidingRestTemplate = opleidingRestTemplate;
        this.vakProducer = vakProducer;
    }

    public Vak saveVak(String naam, int periode, int beschikbaarPleken , IngangEisen ingangEisen, LoopTijd loopTijd,
                       ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens) {

        Vak vak = new Vak(naam, periode, beschikbaarPleken ,ingangEisen, loopTijd,
                toetsGegevens, herkansingGegevens, null, List.of());

        Vak savedVak = vakRepository.save(vak);

        this.vakProducer.sendNieuweVak(savedVak);

        return savedVak;
    }

    public Vak updateVak(String id, String naam,int beschikbaarPleken ,int periode, IngangEisen ingangEisen, LoopTijd loopTijd,
                         ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,
                         String opleidingId) {
        Vak vak = findById(id);
        Opleiding opleiding = this.opleidingRestTemplate.findById(opleidingId);
        if (vak != null) {
            vak.setNaam(naam);
            vak.setPeriode(periode);
            vak.setIngangEisen(ingangEisen);
            vak.setLoopTijd(loopTijd);
            vak.setToetsGegevens(toetsGegevens);
            vak.setHerkansingGegevens(herkansingGegevens);
            vak.setOpleiding(opleiding);
            vak.setBeschikbaarPleken(beschikbaarPleken);

            Vak updatedVak = vakRepository.save(vak);

            VakUpdatedDto vakUpdatedDto = new VakUpdatedDto(updatedVak.getId(),updatedVak.getNaam(),
                    updatedVak.getLoopTijd().getBeginDatum(),
                    updatedVak.getLoopTijd().getEindDatum(),updatedVak.getIngangEisen().getEC(),
                    updatedVak.getOpleiding(),updatedVak.getBeschikbaarPleken());

//            this.opleidingRestTemplate.sendUpdatedVakToOpleiding(updatedVak);

            this.vakProducer.sendUpdatedVak(vakUpdatedDto);

            return updatedVak;
        }
        return null;
    }

    public void deleteVak(String id) {
        Vak vak = findById(id);
        this.vakProducer.sendDeletedVakId(vak.getId());
//        this.opleidingRestTemplate.sendRemovedVakIdToOpleiding(vak);
        this.vakRepository.delete(vak);
    }

    public void deleteAll() {
        List<Vak> vakken = new ArrayList<>();
        this.vakRepository.findAll().forEach(vak -> vakken.add(vak));

        for (Vak vak:vakken){
//            this.vakProducer.sendDeletedVakId(vak.getId());
//            this.opleidingRestTemplate.sendRemovedVakIdToOpleiding(vak);
        }

        this.vakRepository.deleteAll();
    }

    public Vak findByNaam(String naam) {
        Vak vak = this.vakRepository.findByNaam(naam);

        if (vakRepository.findByNaam(naam) == null) {
            return null;
        }
        return vak;
    }

    public List<Vak> findByPeriode(int periode) {
        List<Vak> vakken = this.vakRepository.findByPeriode(periode);

        if (vakken.isEmpty()) {
            return null;
        }
        return vakken;
    }

    public List<Vak> findVakByToetsGegevens(ToetsGegevens toetsGegevens) {
        List<Vak> vakken = vakRepository.findVakByToetsGegevens(toetsGegevens);
        if (vakken.isEmpty()) {
            return null;
        }
        return vakken;
    }

    public List<Vak> findVakByToetsGegevensVorm(String vorm) {
        List<Vak> vakken = vakRepository.findVakByToetsGegevens_Vorm(vorm);
        if (vakken.isEmpty()) {
            return null;
        }
        return vakken;
    }

    public Vak findById(String id) {
        Vak vak = this.vakRepository.findById(id)
                .orElseThrow(() -> new VakNotFoundException());

        return vak;
    }

    public List<Vak> getVakken() {
        List<Vak> vakken = new ArrayList<>();
        this.vakRepository.findAll().forEach(vak -> vakken.add(vak));
        return vakken;
    }


    public void addVakToOpeliding(String vakId,String opleidingId){
        Vak vak = this.vakRepository.findById(vakId).orElseThrow(() -> new VakNotFoundException());
        Opleiding opleiding = this.opleidingRestTemplate.findById(opleidingId);

        this.opleidingRestTemplate.AddVakToOpleiding(vak,opleidingId);
        vak.setOpleiding(opleiding);
        this.vakRepository.save(vak);
    }


    public Opleiding findOpleidingByNaam(String naam){
        return this.opleidingRestTemplate.findByNaam(naam);
    }

    public void addStudent(VakInschrijvingDto vakInschrijvingDto) {
        Vak vak = this.vakRepository.findById(vakInschrijvingDto.getVakId()).orElseThrow(() -> new VakNotFoundException());

        VakInschrijvingDto vakInschrijvingDto1 = new VakInschrijvingDto(
                vakInschrijvingDto.getStudentId(), vakInschrijvingDto.getVakId(),vakInschrijvingDto.getVoornaam());

        Student student = new Student(vakInschrijvingDto1.getStudentId(),vakInschrijvingDto1.getVoornaam());

        if (vak != null) {
            vak.AddStudent(student);
            vakRepository.save(vak);
        }
    }

    public void updateStudent(StudentUpdateDto studentUpdateDto) {
        Vak vak = this.vakRepository.findById(studentUpdateDto.getVakId()).orElseThrow(() -> new VakNotFoundException());

        if (vak != null) {
            for (Student student : vak.getStudents()) {
                if (student.getId().equals(studentUpdateDto.getStudentId())) {
                    student.setNaam(studentUpdateDto.getVoornaam());
                }
            }
            vakRepository.save(vak);
        }
    }

    public void removeStudent(StudentRemoveDto studentRemoveDto) {
        Vak vak = this.vakRepository.findById(studentRemoveDto.getVakId()).orElseThrow(() -> new VakNotFoundException());

        if (vak != null) {
            vak.getStudents().removeIf(student -> student.getId().equals(studentRemoveDto.getStudentId()));
            vakRepository.save(vak);
        }
    }

    public void studentHeeftPuntenBehaald(String vakid, String studentId)
    {
        Vak vak = this.vakRepository.findById(vakid).orElseThrow(() -> new VakNotFoundException());

        StudentPuntenDto studentPuntenDto = new StudentPuntenDto(vakid,studentId);

        for (Student student : vak.getStudents()) {
            if (student.getId().equals(studentId)) {
                this.vakProducer.sendPuntenVanVak(studentPuntenDto);
            }
        }
    }
}
