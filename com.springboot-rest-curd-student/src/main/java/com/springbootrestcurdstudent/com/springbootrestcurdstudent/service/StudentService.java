package com.springbootrestcurdstudent.com.springbootrestcurdstudent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springbootrestcurdstudent.com.springbootrestcurdstudent.entity.Student;
import com.springbootrestcurdstudent.com.springbootrestcurdstudent.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student students)
	{
		return studentRepository.save(students);
	}
	
	public List<Student> createStudents(List<Student> students){
		return studentRepository.saveAll(students);
	}
	
	
	public Student getStudentById(long id)
	{
		return studentRepository.findById(id).orElse(null);
	}
	
	
	public List<Student> getStudents()
	{
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		Student oldStudent=null;
		Optional<Student> optionalstudent=studentRepository.findById((long) student.getId());
		if(optionalstudent.isPresent()) {
			oldStudent=optionalstudent.get();
			oldStudent.setFirstName(student.getFirstName());
			oldStudent.setLastName(student.getLastName());
			oldStudent.setEmail(student.getEmail());
			studentRepository.save(oldStudent);
			
		}
		else {
			return new Student();
		}
		return oldStudent;
	}
	
	public String deleteStudentbyId(long id) {
		studentRepository.deleteById(id);
		return "student got deleted successfully";
		
	}
	
	
	
	public Student updateStudentbyId( Long id,  Student student) {
		Student getStudent=studentRepository.getById(id);
		getStudent.setFirstName(student.getFirstName());
		getStudent.setLastName(student.getLastName());
		getStudent.setEmail(student.getEmail());
		
		return studentRepository.save(getStudent);
		
	}
}
