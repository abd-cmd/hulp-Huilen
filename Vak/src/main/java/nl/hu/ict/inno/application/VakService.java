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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VakService {
    private VakRepository vakRepository;

    private OpleidingRestTemplate opleidingRestTemplate;


    public VakService(VakRepository vakRepository,
                      OpleidingRestTemplate opleidingRestTemplate) {
        this.vakRepository = vakRepository;
        this.opleidingRestTemplate = opleidingRestTemplate;
    }

    public Vak saveVak(String id, String naam, int periode, IngangEisen ingangEisen, LoopTijd loopTijd,
                       ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens) {

        Vak vak = new Vak(id,naam,periode,ingangEisen,loopTijd,
                toetsGegevens, herkansingGegevens,null,List.of());

        return vakRepository.save(vak);
    }
    public Vak saveStudent(String id,String naam,Long StudentId) {

        Vak vak = this.vakRepository.findById(id)
                .orElseThrow(() -> new VakNotFoundException());

        Student student = new Student (StudentId,naam);
        if (vak != null) {

            vak.AddStudent(student);

            return vakRepository.save(vak);
        }

        return null;
    }
    public Vak updateVak(String id, String naam,int periode,IngangEisen ingangEisen,LoopTijd loopTijd,
                         ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,
                         Long opleidingId) {
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
            return this.vakRepository.save(vak);
        }

        return null;
    }

    public Vak addVakToOpleiding(Long id,String Id){
        Opleiding opleiding = this.opleidingRestTemplate.findById(id);
        Vak vak = findById(Id);

        if (vak != null){
            vak.setOpleiding(opleiding);
            opleidingRestTemplate.AddVakToOpleiding(opleiding.getOpleidingId(),vak);
            return this.vakRepository.save(vak);
        }
        return null;
    }

    public void deleteVak(String id) {
        Vak vak = findById(id);
        this.vakRepository.delete(vak);
    }
    public void deleteAll() {
        this.vakRepository.deleteAll();
    }
    public Vak findByNaam(String naam) {
        Vak vak = this.vakRepository.findByNaam(naam);

        if(vakRepository.findByNaam(naam) == null){
            return null;
        }
        return vak;
    }
    public List<Vak> findByPeriode(int periode) {
        List<Vak> vakken = this.vakRepository.findByPeriode(periode);

        if(vakken.isEmpty()){
            return null;
        }
        return vakken;
    }

    public List<Vak> findVakByToetsGegevens(ToetsGegevens toetsGegevens){
        List<Vak> vakken = vakRepository.findVakByToetsGegevens(toetsGegevens);
        if(vakken.isEmpty()){
            return null;
        }
        return vakken;
    }
    public List<Vak> findVakByToetsGegevensVorm(String vorm){
        List<Vak> vakken = vakRepository.findVakByToetsGegevens_Vorm(vorm);
        if(vakken.isEmpty()){
            return null;
        }
        return vakken;
    }
    public Vak findById(String id) {
        Vak vak = this.vakRepository.findById(id)
                .orElseThrow(() -> new VakNotFoundException());
        return vak;
    }

    public Opleiding findOpleidingById(Long id) {
        return this.opleidingRestTemplate.findById(id);
    }
    public List<Vak> findVakByOpleidingId(Long id) {
        Opleiding opleiding = opleidingRestTemplate.findById(id);
        List<Vak> vakken = vakRepository.findVakByOpleiding_OpleidingId(opleiding.getOpleidingId());
        if (vakken.isEmpty()){
            return null;
        }
        return vakken;
    }

    public List<Opleiding> getOpleidingVakken() {
        List<Opleiding> OpleidingVakken = new ArrayList<>();
        this.opleidingRestTemplate.findAll();
        return OpleidingVakken;
    }
    public List<Vak> getVakken() {
        List<Vak> vakken = new ArrayList<>();
        this.vakRepository.findAll().forEach(vak -> vakken.add(vak));
        return vakken;
    }
}
