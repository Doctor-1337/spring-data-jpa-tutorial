package com.doc.spring.data.jpatutorial.repository;

import com.doc.spring.data.jpatutorial.entity.Guardian;
import com.doc.spring.data.jpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("iamdemoid@gmail.com")
                .firstName("Demo")
                .lastName("Name")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .mobile("9999999999")
                .name("Nikhil")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .lastName("Kumar")
                .emailId("shivam@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Shivam");

        System.out.println("students = "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("Sh");

        System.out.println("students = "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = "+ students);

    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("iamdemoid@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("iamdemoid@gmail.com");
        System.out.println("student = " + student);


    }

    @Test
    public void updateStudentnameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "nabeel",
                "iamdemoid@gmail.com"
        );
    }
}