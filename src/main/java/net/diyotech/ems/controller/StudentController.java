package net.diyotech.ems.controller;

import net.diyotech.ems.dto.StudentDto;
import net.diyotech.ems.entity.Student;
import net.diyotech.ems.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // URL: http://localhost:8082/students
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student s = studentService.save(student);
        return ResponseEntity.ok(s);
    }

    // URL: http://localhost:8082/students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    //URL: http://localhost:8082/students/3
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        String result = studentService.deleteStudent(id);
        return ResponseEntity.ok(result);
    }

    //URL: http://localhost:8082/students
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    //URL: http://localhost:8082/students
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFullStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return ResponseEntity.ok(studentService.updateFullStudent(id, student));
    }

    //URL: http://localhost:8082/students/male
    @GetMapping("/male")
    public ResponseEntity<List<Student>> getMaleStudents() {
        return ResponseEntity.ok(studentService.getMaleStudents());
    }

    //URL: http://localhost:8082/students/address/Wisconsin
    @GetMapping("/address/{state}")
    public ResponseEntity<List<Student>> getStudentsByState(@PathVariable("state") String state) {
        return ResponseEntity.ok(studentService.getStudentsByState(state));
    }

    //URL: http://localhost:8082/students/New York/Male
    @GetMapping("/{state}/{gender}")
    public ResponseEntity<List<Student>> getStudentsByState(@PathVariable("state") String state, @PathVariable("gender") String gender) {
        return ResponseEntity.ok(studentService.getStudentsByStateAndGender(state, gender));
    }
}
