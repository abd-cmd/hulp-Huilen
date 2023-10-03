package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.VakRepository;
import nl.hu.inno.humc.monoliet.domain.opleiding.Opleiding;
import nl.hu.inno.humc.monoliet.domain.vak.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.ToetsGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.Vak;
import nl.hu.inno.humc.monoliet.domain.vak.VakGegevensValideren;
import nl.hu.inno.humc.monoliet.domain.exceptions.VakNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class VakService {
    private VakRepository vakRepository;

    private OpleidingService opleidingService;

    public VakService(VakRepository vakRepository, OpleidingService opleidingService) {
        this.vakRepository = vakRepository;
        this.opleidingService = opleidingService;
    }

    public Vak saveVak(String naam, LocalDate beginDatum, LocalDate eindDatum, int periode,
                       ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,Long opleinfID) {

        Opleiding opleiding = this.opleidingService.findOpleidingById(opleinfID);

        Vak vak = new Vak(naam,beginDatum,eindDatum,periode,
                toetsGegevens, herkansingGegevens,opleiding);

        if(!VakGegevensValideren.checkVakDatums(vak.getBeginDatum(),vak.getEindDatum())){
            return null;
        }

        if(!VakGegevensValideren.checkVakDatums(vak.getToetsGegevens().gettoetsDatum(),
                vak.getHerkansingGegevens().getherkansingDatum())){
            return null;
        }

        if (!VakGegevensValideren.checkVakHasNaamAndPeriode(vak.getNaam(), vak.getPeriode())){
            return null;
        }

        return vakRepository.save(vak);
    }

    public Vak updateVak(Long id, String naam, LocalDate begindatum, LocalDate eindDatum, int periode,
                         ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,Long opleinfID) {
        Vak vak = findById(id);
        Opleiding opleiding = this.opleidingService.findOpleidingById(opleinfID);

        if(!VakGegevensValideren.checkVakDatums(vak.getBeginDatum(),vak.getEindDatum())){
            return null;
        }

        if(!VakGegevensValideren.checkVakDatums(vak.getToetsGegevens().gettoetsDatum(),vak.getHerkansingGegevens().getherkansingDatum())){
            return null;
        }

        if (!VakGegevensValideren.checkVakHasNaamAndPeriode(vak.getNaam(), vak.getPeriode())){
            return null;
        }

        if (vak != null) {
            vak.setNaam(naam);
            vak.setBeginDatum(begindatum);
            vak.setEindDatum(eindDatum);
            vak.setPeriode(periode);
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

    public List<Vak> findVakByOpleidingId(Long id) {
        List<Vak> vakken = vakRepository.findVakByOpleiding_OpleidingId(id);
        if (vakken.isEmpty()){
            return null;
        }
        return vakken;
    }

    public List<Vak> getVakken() {
        List<Vak> vakken = new ArrayList<>();
        this.vakRepository.findAll().forEach(vak -> vakken.add(vak));
        return vakken;
    }
}
