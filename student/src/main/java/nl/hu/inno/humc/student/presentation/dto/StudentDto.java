package nl.hu.inno.humc.student.presentation.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.domain.Vooropleiding;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class StudentDto {

    private String studentId;
    private String voornaam;
    private String achternaam;
    private String roepnaam;
    private LocalDate geboortedatum;
    private String email;
    private String telefoonNummer;
    private String straat;
    private String huisnummer;
    private String postcode;
    private String plaats;
    private Vooropleiding vooropleiding;
    private List<String> opleidingen;
    private List<String> ingeschrevenVakken;
    private List<String> behaaldeVakken;
    private List<BsaDto> studieAdviezen;


    public static StudentDto Of(Student student) {
        StudentDto dto = new StudentDto();
        dto.studentId = student.getStudentId();
        dto.voornaam = student.getPersoonsGegevens().getNaam().getVoornaam();
        dto.achternaam = student.getPersoonsGegevens().getNaam().getAchternaam();
        dto.roepnaam = student.getPersoonsGegevens().getNaam().getRoepnaam();
        dto.geboortedatum = student.getPersoonsGegevens().getGeboortedatum();
        dto.email = student.getPersoonsGegevens().getEmail().getEmail();
        dto.telefoonNummer = student.getPersoonsGegevens().getTelefoonNummer().getTelefoonNummer();
        dto.straat = student.getPersoonsGegevens().getAdres().getStraat();
        dto.huisnummer = student.getPersoonsGegevens().getAdres().getHuisnummer();
        dto.postcode = student.getPersoonsGegevens().getAdres().getPostcode();
        dto.plaats = student.getPersoonsGegevens().getAdres().getPlaats();
        dto.vooropleiding = student.getVooropleiding();
        dto.opleidingen = student.getOpleidingen().stream().map(Opleiding::getOpleidingId).collect(toList());
        dto.ingeschrevenVakken = student.getIngeschrevenVakken().stream().map(Vak::getId).collect(toList());
        dto.behaaldeVakken = student.getBehaaldeVakken().stream().map(Vak::getId).collect(toList());
        dto.studieAdviezen = student.getStudieAdviezen().stream().map(BsaDto::Of).collect(toList());
        return dto;
    }

    public static List<StudentDto> Of(List<Student> students) {
        return students.stream().map(StudentDto::Of).toList();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getRoepnaam() {
        return roepnaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public Vooropleiding getVooropleiding() {
        return vooropleiding;
    }
}
