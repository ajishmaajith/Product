package com.company.EmployeeManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.company.EmployeeManagement.audit.Auditable;
import com.sun.istack.NotNull;


@Entity
@EntityListeners(AuditingEntityListener.class)

public class Employee extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotNull
	@Size(min=2,message="First name should have atleast 2 characters")
	private String firstName;
	@Column(name = "last_name")
    @NotNull
	@Size(min=2,message="last name should have atleast 2 characters")

	private String lastName;

	@Column(name = "email_id")
	@Email
	@NotBlank
	@Size(min=2,message="email should have atleast 2 characters")

	private String emailId;

	public Employee(String firstName, String lastName, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
