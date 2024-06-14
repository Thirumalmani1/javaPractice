package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoy extends JpaRepository<Student,Long> {

}
