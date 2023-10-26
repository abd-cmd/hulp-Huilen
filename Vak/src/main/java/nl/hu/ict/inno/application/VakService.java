package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;

import nl.hu.ict.inno.Producer;
import nl.hu.ict.inno.application.RestTemplateServices.OpleidingRestTemplate;
import nl.hu.ict.inno.application.RestTemplateServices.StudentRestTemplate;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.domain.*;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VakService {
    private VakRepository vakRepository;

    private StudentRestTemplate studentRestTemplate;
    private OpleidingRestTemplate opleidingRestTemplate;


    public VakService(VakRepository vakRepository,
                      StudentRestTemplate studentRestTemplate,
                      OpleidingRestTemplate opleidingRestTemplate) {
        this.vakRepository = vakRepository;
        this.studentRestTemplate = studentRestTemplate;
        this.opleidingRestTemplate = opleidingRestTemplate;

    }

    public Vak saveVak(String naam, int periode, IngangEisen ingangEisen, LoopTijd loopTijd,
                       ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,
                       Long opleindingID ,Long studentID) {

        Opleiding opleiding = this.opleidingRestTemplate.findById(opleindingID);
        Student student = this.studentRestTemplate.findById(studentID);
        Vak vak = new Vak(naam,periode,ingangEisen,loopTijd,
                toetsGegevens, herkansingGegevens,opleiding,student);



        return vakRepository.save(vak);
    }

    public Vak updateVak(Long id, String naam,int periode,IngangEisen ingangEisen,LoopTijd loopTijd,
                         ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,
                         Long opleinfID,Long studentID) {
        Vak vak = findById(id);
        Opleiding opleiding = this.opleidingRestTemplate.findById(opleinfID);
        Student student = this.studentRestTemplate.findById(studentID);
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

    public Vak deleteVak(Long id) {
        Vak vak = findById(id);
        if (vakRepository.findById(id).isEmpty()) {
            return null;
        }
        this.vakRepository.delete(vak);
        return vak;
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
    public Vak findById(Long id) {
        Vak vak = this.vakRepository.findById(id)
                .orElseThrow(() -> new VakNotFoundException());
        return vak;
    }

    public Opleiding findOpleidingById(Long id) {
        return this.opleidingRestTemplate.findById(id);
    }
    public Student findStudentById(Long id) {
        return this.studentRestTemplate.findById(id);
    }
    public List<Vak> findVakByOpleidingId(Long id) {
//        List<Vak> vakken = vakRepository.findVakByOpleiding_OpleidingId(id);
//        if (vakken.isEmpty()){
//            return null;
//        }
//        return vakken;
        return null;
    }

    public List<Vak> getVakken() {
        List<Vak> vakken = new ArrayList<>();
        this.vakRepository.findAll().forEach(vak -> vakken.add(vak));
        return vakken;
    }
}
