package nl.hu.ict.inno.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Opleiding {

    @Id
    private String opleidingId;

    private List<Vak> vakken;
    private String naam;

    @Embedded
    private Periode periode;

    @Embedded
    private InschrijfDatum inschrijfDatum;

    @Embedded
    private OpleidingDetails opleidingDetails;


    public OpleidingDetails getOpleidingDetails() {
        return opleidingDetails;
    }

    public void setOpleidingDetails(OpleidingDetails opleidingDetails) {
        this.opleidingDetails = opleidingDetails;
    }

    public String getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(String opleidingId) {
        this.opleidingId = opleidingId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Periode getPeriode() {
        return periode;
    }

    public InschrijfDatum getInschrijfDatum() {
        return inschrijfDatum;
    }

    public void setInschrijfDatum(InschrijfDatum inschrijfDatum) {
        this.inschrijfDatum = inschrijfDatum;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public List<Vak> getVakken() {
        return vakken;
    }

    public void setVakken(List<Vak> vakken) {
        this.vakken = vakken;
    }

    public void addVak(Vak vak) {
        vakken.add(vak);
        vak.setOpleiding(this);
    }

    public void removeVak(Vak vak) {
        vakken.remove(vak);
        vak.setOpleiding(null);
    }

    public Vak getVak(String vakId) {
        Vak vak = vakken.get(Integer.parseInt(vakId));
        return vak;
    }
}
