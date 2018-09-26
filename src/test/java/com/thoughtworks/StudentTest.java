package com.thoughtworks;

import com.thoughtworks.domain.Classroom;
import com.thoughtworks.domain.Student;
import com.thoughtworks.repository.ClassroomRepository;
import com.thoughtworks.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentTest {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        classroomRepository.deleteAll();
        studentRepository.deleteAll();
    }

    @Test
    void should_get_class_name() {
        Classroom classroom = new Classroom();
        classroom.setName("001");
        classroomRepository.save(classroom);
        assertThat(classroomRepository.findAll()).hasSize(1);
        assertThat(classroomRepository.findAll().get(0).getName()).isEqualTo("001");
    }

    @Test
    void should_get_student_size() {
        Classroom classroom = new Classroom();
        classroom.setName("1608");
        classroomRepository.save(classroom);

        Student student1 = new Student("sun ming", 16, 170, classroom);
        studentRepository.save(student1);
        assertThat(studentRepository.findAll()).hasSize(1);
    }

    @Test
    void should_get_student_by_class() {
        Classroom classroom = new Classroom();
        classroom.setName("1609");
        Classroom save = classroomRepository.save(classroom);

        Student student1 = new Student("sun ming", 16, 170, classroom);
        studentRepository.save(student1);
        assertThat(classroomRepository.findById(save.getId()).get().getStudents()).hasSize(1);
    }

    @Test
    void should_get_student_by_class_and_new_class() {
        Student student1 = Student.builder().name("sun ming").age(16).height(170).build();
        Classroom classroom = Classroom.builder().name("1607").build();
        classroom.setStudents(Arrays.asList(student1));
        classroomRepository.save(classroom);
        assertThat(classroomRepository.findByName("1607").getStudents()).hasSize(1);
        assertThat(studentRepository.findByName("sun ming").getId()).isNotNull();
        assertThat(studentRepository.findByName("sun ming").getClassroom().getName()).isEqualTo("1607");
    }

    @Test
    void should_get_student_name() {
        Student student1 = Student.builder().name("sun ming").age(16).height(170).build();
        Student student2 = Student.builder().name("sun ming2").age(16).height(165).build();
        Classroom classroom = Classroom.builder().name("1607").build();
        classroom.setStudents(Arrays.asList(student1, student2));
        classroomRepository.save(classroom);
        Student sunMing = studentRepository.findByName("sun ming");
        assertThat(sunMing.getAge()).isEqualTo(16);

    }


}
