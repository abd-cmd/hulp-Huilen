package nl.hu.inno.humc.student.application;

public interface StudentClient {

    String registreerStudent(String voornaam, String achternaam);
    void voegStudentToeAanKlas(String studentNummer, String klasCode);
}
