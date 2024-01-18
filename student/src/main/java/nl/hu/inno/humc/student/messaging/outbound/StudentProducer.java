package nl.hu.inno.humc.student.messaging.outbound;

import nl.hu.inno.humc.student.presentation.dto.StudentDto;

public interface StudentProducer {
    void sendNewStudentToQueue(StudentDto student);
    void sendUpdatedStudentToQueue(StudentDto student);
    void sendDeletedStudentToQueue(StudentDto student);
}
