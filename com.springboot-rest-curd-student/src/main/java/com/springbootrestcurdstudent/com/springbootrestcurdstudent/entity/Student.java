package com.springbootrestcurdstudent.com.springbootrestcurdstudent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;







@Entity
public class Student {

	public Student(long id,
			@NotEmpty @Size(min = 5, message = "firstName should have atleast 5 characters") String firstName,
			String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotEmpty
	@Size(min=5, message="firstName should have atleast 5 characters")
	private String firstName;
	private String lastName;
	private String email;
	
	
}
