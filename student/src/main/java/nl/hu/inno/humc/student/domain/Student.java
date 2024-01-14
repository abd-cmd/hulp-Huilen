package nl.hu.inno.humc.student.domain;

import nl.hu.inno.humc.student.domain.persoonsgegevens.PersoonsGegevens;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Document(collection="student")
public class Student {
    @MongoId
    private String studentId;
    private String studentNummer;
    private PersoonsGegevens persoonsGegevens;
    private Vooropleiding vooropleiding;
    private List<BSA> bsaList;
    private List<Opleiding> opleidingen;
    private List<Vak> ingeschrevenVakken;
    private List<Vak> behaaldeVakken;
    private List<String> klassen;

    protected Student(){}

    public Student(PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding){
        if(persoonsGegevens == null || vooropleiding == null){
            throw new IllegalArgumentException("Persoonsgegevens en vooropleiding mogen niet leeg zijn");
        }
        this.persoonsGegevens = persoonsGegevens;
        this.vooropleiding = vooropleiding;
        this.ingeschrevenVakken = new ArrayList<>();
        this.behaaldeVakken = new ArrayList<>();
        this.bsaList = new ArrayList<>();
        this.opleidingen = new ArrayList<>();
    }

    public void schrijfInVoorOpleiding(Opleiding opleiding){
        if(opleiding == null) throw new IllegalArgumentException("Opleiding mag niet leeg zijn");
        if(this.opleidingen.contains(opleiding)) throw new IllegalArgumentException("Student is al ingeschreven voor deze opleiding");
        if(!isStudentToegestaanOpOpleiding(opleiding)) throw new IllegalStateException("Student is niet toegestaan op deze opleiding");
        if(opleiding.getBeschikbarePlekken() <= 0) throw new IllegalStateException("Er zijn geen plekken meer beschikbaar op deze opleiding");

        this.opleidingen.add(opleiding);
    }

    public void schrijfInVoorVak(Vak vak){
        if(vak == null) throw new IllegalArgumentException("vak mag niet leeg zijn");
        // TODO dit fixen wanneer opleiding module beschikbaar is
        // if(!this.opleidingen.contains(vak.getOpleiding())) throw new IllegalArgumentException("Vak behoort niet tot een opleiding waar de student voor is ingeschreven");
        if(this.ingeschrevenVakken.contains(vak)) throw new IllegalArgumentException("Student is al ingeschreven voor dit vak");
        if(this.behaaldeVakken.contains(vak)) throw new IllegalArgumentException("Student heeft dit vak al behaald");

        this.ingeschrevenVakken.add(vak);
    }

    private boolean isStudentToegestaanOpOpleiding(Opleiding opleiding) {
        if(this.vooropleiding == Vooropleiding.ANDERE) return false;
        if(this.vooropleiding == Vooropleiding.HAVO || vooropleiding == Vooropleiding.VWO || vooropleiding == Vooropleiding.MBO){

            // Zoek de bsa van de opleiding waar de student zich voor wil inschrijven
            BSA bsaVanOpleiding = this.bsaList.stream().filter(bsa -> bsa.getOpleiding().equals(opleiding)).findFirst().orElse(null);

            // Als de student nog geen bsa heeft voor deze opleiding, dan is de student toegestaan
            if(bsaVanOpleiding == null) {

                // BSA bestond nog niet, dus maak een nieuwe aan
                this.bsaList.add(new BSA(30, opleiding));
                return true;
            }

            return bsaVanOpleiding.isBSABehaald();

        }
        throw new RuntimeException();
    }

    public void studentHeeftVakBehaald(Vak vak){
        if(vak == null) throw new IllegalArgumentException("Vak mag niet leeg zijn");
        if(!this.opleidingen.contains(vak.getOpleiding())) throw new IllegalStateException("Student is nog niet ingeschreven voor deze opleiding");
        if(this.behaaldeVakken.contains(vak)) throw new IllegalArgumentException("Student heeft dit vak al behaald");


        this.behaaldeVakken.add(vak);
        this.ingeschrevenVakken.remove(vak);

        // Voeg de studiepunten van het vak toe aan het bsa van de opleiding
        Optional<BSA> bsaVanOpleiding = this.bsaList.stream().filter(bsa -> bsa.getOpleiding().equals(vak.getOpleiding())).findFirst();
        bsaVanOpleiding.ifPresent(bsa -> bsa.voegStudiePuntenToe(vak.getStudiePunten()));
    }

    public void schrijfInVoorKlas(String klasCode){
        if(klasCode == null || klasCode.isEmpty()) throw new IllegalArgumentException("Klascode mag niet leeg zijn");
        if(this.klassen.contains(klasCode)) throw new IllegalArgumentException("Student is al ingeschreven voor deze klas");

        this.klassen.add(klasCode);
    }

    public void geefStudentNummer(String studentNummer){
        if(studentNummer == null || studentNummer.isEmpty()) throw new IllegalArgumentException("Studentnummer mag niet leeg zijn");
        if(this.studentNummer != null) throw new IllegalArgumentException("Studentnummer is al toegekend aan deze student");

        this.studentNummer = studentNummer;
    }



    public String getStudentId() {
        return studentId;
    }

    public PersoonsGegevens getPersoonsGegevens() {
        return persoonsGegevens;
    }

    public Vooropleiding getVooropleiding() {
        return vooropleiding;
    }

    public List<BSA> getStudieAdviezen() {
        return bsaList;
    }

    public List<Opleiding> getOpleidingen() {
        return opleidingen;
    }

    public List<Vak> getVrijstellingen() {
        return behaaldeVakken;
    }

    public List<Vak> getIngeschrevenVakken() {
        return ingeschrevenVakken;
    }

    public List<Vak> getBehaaldeVakken() {
        return behaaldeVakken;
    }

    public List<String> getKlassen() {
        return klassen;
    }

    public String getStudentNummer() {
        return studentNummer;
    }
}
