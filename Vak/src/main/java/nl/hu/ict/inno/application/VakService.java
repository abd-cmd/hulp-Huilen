package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;

import nl.hu.ict.inno.application.RestTemplateServices.OpdrachtRestInterface;
import nl.hu.ict.inno.application.RestTemplateServices.OpleidingRestTemplate;
import nl.hu.ict.inno.data.OpdrachtRepository;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.domain.*;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;

import nl.hu.ict.inno.presentation.vakMessaging.VakProducer;
import nl.hu.ict.inno.presentation.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VakService implements VakInterface {
    private VakRepository vakRepository;
    private OpleidingRestTemplate opleidingRestTemplate;
    private VakProducer vakProducer;
    private OpdrachtRestInterface opdrachtRestInterface;
    private StudentInterface studentInterface;
    private OpdrachtRepository opdrachtRepository;

    public VakService(VakRepository vakRepository, OpleidingRestTemplate opleidingRestTemplate,
                      VakProducer vakProducer, OpdrachtRestInterface opdrachtRestInterface,
                      StudentInterface studentInterface, OpdrachtRepository opdrachtRepository) {
        this.vakRepository = vakRepository;
        this.opleidingRestTemplate = opleidingRestTemplate;
        this.vakProducer = vakProducer;
        this.opdrachtRestInterface = opdrachtRestInterface;
        this.studentInterface = studentInterface;
        this.opdrachtRepository = opdrachtRepository;
    }

    public Vak AddVak(VakDto vakDto) {

        Vak vak = new Vak(vakDto.naam, vakDto.periode, vakDto.beschikbaarPleken ,vakDto.ingangEisen, vakDto.loopTijd,
                vakDto.toetsGegevens, vakDto.herkansingGegevens, null, List.of());

        Vak savedVak = vakRepository.save(vak);

        this.vakProducer.sendVakToOpdracht(savedVak);
        this.vakProducer.sendNieuweVak(savedVak);
        this.vakProducer.sendVakToOpdracht(savedVak);

        return savedVak;
    }

    public Vak findById(String id) {
        Vak vak = this.vakRepository.findById(id)
                .orElseThrow(() -> new VakNotFoundException());

        return vak;
    }

    public Opleiding addVakToOpeliding(String vakId,String opleidingId) {
        Vak vak = this.vakRepository.findById(vakId).orElseThrow(() -> new VakNotFoundException());
        Opleiding opleiding = this.opleidingRestTemplate.findById(opleidingId);
        vak.setOpleiding(opleiding);

        this.opleidingRestTemplate.AddVakToOpleiding(vak,opleidingId);
        this.vakRepository.save(vak);
        return opleiding;
    }

    public List<Opleiding> getOpleidingen() {
        List<Opleiding> OpleidingList = new ArrayList<>();
        this.opleidingRestTemplate.findAll().forEach(opleiding -> OpleidingList.add(opleiding));
        return OpleidingList;
    }


    public void addStudent(VakInschrijvingDto vakInschrijvingDto) {
        Vak vak = this.vakRepository.findById(vakInschrijvingDto.getVakId()).orElseThrow(() -> new VakNotFoundException());

        Student student = new Student(vakInschrijvingDto.getStudentId(),vakInschrijvingDto.getVoornaam(),vakInschrijvingDto.getAchternaam());

        if (vak != null) {
            vak.AddStudent(student);
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

    public void studentHeeftGeenPuntenBehaald(String vakid, String studentId)
    {
        Vak vak = this.vakRepository.findById(vakid).orElseThrow(() -> new VakNotFoundException());
        Student student = this.studentInterface.FindStudent(studentId);
        List<Opdracht> opdrachts = this.opdrachtRepository.findAllByVakId(vakid);

        List<Opdracht> sendOpdrachten = new ArrayList<>();

        for(Opdracht opdracht: opdrachts){
            sendOpdrachten.add(opdracht);
        }

        SendOpdrachtenToStudentDto sendOpdrachtenToStudentDto =
                new SendOpdrachtenToStudentDto(vak.getId(),student.getId(),sendOpdrachten);

        vakProducer.sendOpdrachtenVanVak(sendOpdrachtenToStudentDto);
    }
}
