package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.data.FakeRepositories.StudentFakeRepository;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Component
public class StudentRestTemplate implements StudentFakeRepository {
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Vak> AddStudentToVak(Student student) {
        return null;
    }

    @Override
    public Student findById(Long id) {
        ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:8080/students/" + id,Student.class);


        return response.getBody();
    }

    @Override
    public List<Student> findAll() {

        ResponseEntity<Student[]> response = restTemplate.getForEntity("http://localhost:8080/students",Student[].class);

        return List.of(response.getBody());
    }
}
