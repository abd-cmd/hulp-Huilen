package nl.hu.ict.inno.domain;

import jakarta.persistence.*;
import lombok.Data;
import nl.hu.ict.inno.domain.vakGegevens.HerkansingGegevens;
import nl.hu.ict.inno.domain.vakGegevens.IngangEisen;
import nl.hu.ict.inno.domain.vakGegevens.LoopTijd;
import nl.hu.ict.inno.domain.vakGegevens.ToetsGegevens;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Document(collection  = "Vak")
public class Vak {
    @Id
    private String id;

    private String naam;
    private int periode;
    private int beschikbaarPleken;
    private IngangEisen ingangEisen;
    private LoopTijd loopTijd;
    private ToetsGegevens toetsGegevens;
    private HerkansingGegevens herkansingGegevens;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "opleidingId")
//    @JsonIgnore
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="id",column = @Column(name="opleidingId")),
//            @AttributeOverride(name="naam",column = @Column(name="opleidingNaam")),
//    })
    private Opleiding opleiding;

//    @Embedded
//    @CollectionTable(name = "students", joinColumns = @JoinColumn(name = "vak_id"))
//    @AttributeOverrides({
//            @AttributeOverride(name="id",column = @Column(name="studentId")),
//            @AttributeOverride(name="naam",column = @Column(name="studentNaam")),
//    })
    private List<Student> students = new ArrayList<>();


    public Vak() {
    }

    public Vak(String naam, int periode, int beschikbaarPleken,
               IngangEisen ingangEisen, LoopTijd loopTijd,
               ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,
               Opleiding opleiding, List<Student> students) {
        this.naam = naam;
        this.periode = periode;
        this.ingangEisen = ingangEisen;
        this.loopTijd = loopTijd;
        this.toetsGegevens = toetsGegevens;
        this.herkansingGegevens = herkansingGegevens;
        this.opleiding = opleiding;
        this.students = students;
        this.beschikbaarPleken = beschikbaarPleken;
    }

    public Vak(String id, String naam, int periode,int beschikbaarPleken,
               IngangEisen ingangEisen,
               LoopTijd loopTijd, ToetsGegevens toetsGegevens,
               HerkansingGegevens herkansingGegevens,
               Opleiding opleiding, List<Student> students) {
        this.id = id;
        this.naam = naam;
        this.periode = periode;
        this.ingangEisen = ingangEisen;
        this.loopTijd = loopTijd;
        this.toetsGegevens = toetsGegevens;
        this.herkansingGegevens = herkansingGegevens;
        this.opleiding = opleiding;
        this.students = students;
        this.beschikbaarPleken = beschikbaarPleken;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public IngangEisen getIngangEisen() {
        return ingangEisen;
    }

    public void setIngangEisen(IngangEisen ingangEisen) {
        this.ingangEisen = ingangEisen;
    }

    public LoopTijd getLoopTijd() {
        return loopTijd;
    }

    public void setLoopTijd(LoopTijd loopTijd) {
        this.loopTijd = loopTijd;
    }

    public ToetsGegevens getToetsGegevens() {
        return toetsGegevens;
    }
    public void setToetsGegevens(ToetsGegevens toetsGegevens) {
        this.toetsGegevens = toetsGegevens;
    }
    public HerkansingGegevens getHerkansingGegevens() {
        return herkansingGegevens;
    }

    public void setHerkansingGegevens(HerkansingGegevens herkansingGegevens) {
        this.herkansingGegevens = herkansingGegevens;
    }

    public int getBeschikbaarPleken() {
        return beschikbaarPleken;
    }

    public void setBeschikbaarPleken(int beschikbaarPleken) {
        this.beschikbaarPleken = beschikbaarPleken;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void AddStudent(Student student) {
        if(students.size() < beschikbaarPleken) {
            beschikbaarPleken = beschikbaarPleken - 1;
            this.students.add(student);
        }
    }

    public boolean ValidateVakGekoppledAanOpleiding(Opleiding opleiding){
        return opleiding.getOpleidingId() != null;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vak vak = (Vak) o;
        return periode == vak.periode &&
                Objects.equals(id, vak.id)
                && Objects.equals(naam, vak.naam)
                && Objects.equals(ingangEisen, vak.ingangEisen)
                && Objects.equals(loopTijd, vak.loopTijd)
                && Objects.equals(toetsGegevens, vak.toetsGegevens)
                && Objects.equals(herkansingGegevens, vak.herkansingGegevens)
                && Objects.equals(opleiding, vak.opleiding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, periode, ingangEisen, loopTijd, toetsGegevens, herkansingGegevens, opleiding);
    }
}
