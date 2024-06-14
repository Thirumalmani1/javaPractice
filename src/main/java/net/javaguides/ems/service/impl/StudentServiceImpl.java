package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.entity.Student;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.exception.StudentNotFoundException;
import net.javaguides.ems.repository.StudentRepositoy;
import net.javaguides.ems.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepositoy studentRepositoy;

    @Override
    public Student CreateStudent(Student student) {
        return studentRepositoy.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepositoy.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Students is not exists with given ids : " + studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepositoy.findAll();
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student updatedStudent =  studentRepositoy.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student is not exists with given id : " + studentId));
        updatedStudent.setName(student.getName());
        updatedStudent.setPassportNumber(student.getPassportNumber());
        return studentRepositoy.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepositoy.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student is not exists with given id : " + studentId));
        studentRepositoy.deleteById(studentId);
    }
}
