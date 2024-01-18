package nl.hu.inno.humc.student.application;

import nl.hu.inno.humc.student.presentation.dto.NaamDto;
import nl.hu.inno.humc.student.presentation.dto.StudentFromJjanDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentRestClient implements StudentClient{

    private final RestTemplate restTemplate;

    public StudentRestClient() {
        this.restTemplate = new RestTemplate();
    }

    public String registreerStudent(String voornaam, String achternaam) {
        StudentFromJjanDto studentDto = restTemplate.postForEntity("http://localhost:8090/student", new StudentFromJjanDto(-1L, voornaam, achternaam), StudentFromJjanDto.class).getBody();
        if (studentDto == null) {
            throw new RuntimeException("Student kan niet in Canvas worden aangemaakt");
        }
        System.out.println(studentDto.getStudentNummer());
        return studentDto.getStudentNummer().toString();
    }

    public void voegStudentToeAanKlas(String studentNummer, String klasCode) {
        restTemplate.postForEntity("http://localhost:8090/klas/" + klasCode + "/student/" + studentNummer, null, Void.class);
    }
}
