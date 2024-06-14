package net.javaguides.ems.service;

import net.javaguides.ems.entity.Student;

import java.util.List;

public interface StudentService {

    Student CreateStudent(Student student);
    Student getStudentById(Long studentId);
    List<Student> getAllStudents();
    Student updateStudent(Long studentId, Student student);
    void deleteStudent(Long studentId);
}
