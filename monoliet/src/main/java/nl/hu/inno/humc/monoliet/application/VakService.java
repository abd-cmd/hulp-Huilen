package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.VakRepository;
import nl.hu.inno.humc.monoliet.domain.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.ToetsGegevens;
import nl.hu.inno.humc.monoliet.domain.Vak;
import nl.hu.inno.humc.monoliet.domain.exceptions.VakNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class VakService {
    private VakRepository vakRepository;

    public VakService(VakRepository vakRepository) {
        this.vakRepository = vakRepository;
    }

    public Vak saveVak(String naam, LocalDateTime beginDatum, LocalDateTime eindDatum, int periode,
                       ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens) {

        Vak vak = new Vak(naam,beginDatum,eindDatum,periode, toetsGegevens, herkansingGegevens);

        return vakRepository.save(vak);
    }

    public Vak updateVak(Long id, String naam, LocalDateTime begindatum, LocalDateTime eindDatum, int periode,
                         ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens) {
        Vak vak = findById(id);
        if (vak != null) {
            vak.setNaam(naam);
            vak.setBeginDatum(begindatum);
            vak.setEindDatum(eindDatum);
            vak.setPeriode(periode);
            vak.setToetsGegevens(toetsGegevens);
            vak.setHerkansingGegevens(herkansingGegevens);
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
    public Vak findById(Long id) {
        Vak vak = this.vakRepository.findById(id)
                .orElseThrow(() -> new VakNotFoundException());
        return vak;
    }

    public List<Vak> getVakken() {
        List<Vak> vakken = new ArrayList<>();
        this.vakRepository.findAll().forEach(vak -> vakken.add(vak));
        return vakken;
    }
}
