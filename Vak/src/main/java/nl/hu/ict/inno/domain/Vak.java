package nl.hu.ict.inno.domain;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
public class Vak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    private int periode;
    @Embedded
    private IngangEisen ingangEisen;
    @Embedded
    private LoopTijd loopTijd;
    @Embedded
    private ToetsGegevens toetsGegevens;
    @Embedded
    private HerkansingGegevens herkansingGegevens;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "opleidingId")
//    @JsonIgnore
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id",column = @Column(name="opleidingId")),
            @AttributeOverride(name="naam",column = @Column(name="opleidingNaam")),
    })
    private Opleiding opleiding;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id",column = @Column(name="studentId")),
            @AttributeOverride(name="naam",column = @Column(name="studentNaam")),
    })
    private Student student;


    public Vak() {
    }

    public Vak(String naam, int periode,
               IngangEisen ingangEisen, LoopTijd loopTijd,
               ToetsGegevens toetsGegevens, HerkansingGegevens herkansingGegevens,
               Opleiding opleiding, Student student) {
        this.naam = naam;
        this.periode = periode;
        this.ingangEisen = ingangEisen;
        this.loopTijd = loopTijd;
        this.toetsGegevens = toetsGegevens;
        this.herkansingGegevens = herkansingGegevens;
        this.opleiding = opleiding;
        this.student = student;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student studentList) {
        this.student = studentList;
    }

    public boolean ValidateVakGekoppledAanOpleiding(Opleiding opleiding){
        return opleiding.getId() != null;
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
