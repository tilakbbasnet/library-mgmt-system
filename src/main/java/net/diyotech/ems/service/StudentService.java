package net.diyotech.ems.service;

import net.diyotech.ems.dto.StudentDto;
import net.diyotech.ems.entity.Student;
import net.diyotech.ems.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Value("${message}")
    private String msg;

    @Value("${city}")
    private String city;

    @Value("${your.state}")
    private String state;

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<StudentDto> getAllStudents() {
        System.out.println("Your message is: "+msg);
        System.out.println("Your state is: "+state);
        System.out.println("Your city is: "+city);
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(student -> {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }

    public String deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) { //If student with this id exists in database table
            //delete student
            studentRepository.deleteById(id);
            return "Student having id "+id+ " deleted successfully.";
        }
        return "Student having id "+id+ " not found.";
    }

    public String updateStudent(Long id, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            // update student
            Student existingStudent = studentOptional.get();
            if(student.getFullName() != null) {
                existingStudent.setFullName(student.getFullName());
            }
            if(student.getAddress() != null) {
                existingStudent.setAddress(student.getAddress());
            }
            if(student.getGender() != null) {
                existingStudent.setGender(student.getGender());
            }
            if(student.getPhone() != null) {
                existingStudent.setPhone(student.getPhone());
            }
            if(student.getEmail() != null) {
                existingStudent.setEmail(student.getEmail());
            }
            studentRepository.save(existingStudent);
            return "Student having id "+id+ " updated successfully.";
        }
        return "Student having id "+id+ " not found.";
    }

    public String updateFullStudent(Long id, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            // update student
            Student existingStudent = studentOptional.get();
            existingStudent.setFullName(student.getFullName());
            existingStudent.setGender(student.getGender());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setAddress(student.getAddress());
            studentRepository.save(existingStudent);
            return "Student having id "+id+ " updated successfully.";
        }
        return "Student having id "+id+ " not found.";
    }

    public List<Student> getMaleStudents() {
        return studentRepository.getMaleStudents();
    }

    public List<Student> getStudentsByState(String state) {
        //return studentRepository.getStudentsByState(state);
        return studentRepository.findByAddress(state);
    }

    public List<Student> getStudentsByStateAndGender(String state, String gender) {
        return studentRepository.findByAddressAndGender(state, gender);
    }

    public void test() {
        Student student3 = Student.builder()
                .id(5L)
                .address("VA")
                .build();
    }
}
