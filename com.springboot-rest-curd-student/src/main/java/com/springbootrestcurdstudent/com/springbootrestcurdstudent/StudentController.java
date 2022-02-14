package com.springbootrestcurdstudent.com.springbootrestcurdstudent;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestcurdstudent.com.springbootrestcurdstudent.entity.Student;

import com.springbootrestcurdstudent.com.springbootrestcurdstudent.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping("/hello")
	String hello() {
		return "welcome ";
	}
	
	@PostMapping("/addStudent")
	public Student addStudent( @Valid @RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	
	@PostMapping("/addStudents")
	public List<Student> addStudents( @RequestBody List<Student> students) {
		return studentService.createStudents(students);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable long id)
	{
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student")
	public List<Student> getAllstudents(){
		return studentService.getStudents();
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudentbyId(id);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@PutMapping("/student/{id}")
	public Student updateStudentbyId(@PathVariable Long id, @RequestBody Student student) {
		return ((StudentService) studentService).updateStudentbyId(id, student);
	}
}
