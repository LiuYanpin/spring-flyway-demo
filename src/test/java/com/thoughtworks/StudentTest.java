package com.thoughtworks;

import com.thoughtworks.domain.Classroom;
import com.thoughtworks.domain.Student;
import com.thoughtworks.repository.ClassroomRepository;
import com.thoughtworks.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class StudentTest {

    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void should_get_true() {
        assertTrue(true);
    }

    @Test
    @Transactional
    void should_create_class_successfully() {
        Classroom classroom = new Classroom();
        classroom.setName("class one");
        classroomRepository.save(classroom);
        assertThat(classroomRepository.findAll()).hasSize(1);

    }

    @Test
    @Transactional
    void should_create_class_second_successfully() {
        Classroom classroom = new Classroom();
        classroom.setName("class two");
        classroomRepository.save(classroom);
        assertThat(classroomRepository.findAll()).hasSize(1);
    }

    @Test
    void should_get_student() {
        Classroom classroom = new Classroom();
        classroom.setName("1");
        classroomRepository.save(classroom);

        Student student1 = new Student();
        student1.setName("sun ming");
        student1.setAge(18);
        student1.setHeight(180);
        student1.setClassroom(classroom);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("xu ya");
        student2.setAge(16);
        student2.setHeight(170);
        student1.setClassroom(classroom);
        studentRepository.save(student2);


        Student student3 = new Student();
        student3.setName("liu ping");
        student3.setAge(18);
        student3.setHeight(1750);
        student1.setClassroom(classroom);
        studentRepository.save(student3);

        Iterable<Student> students = studentRepository.findAll();
        assertThat(students).hasSize(3);
    }

}
