package com.remotehiring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Users {

	@Id
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Fullname cannot be blank")
	private String fullname;

	@NotBlank(message = "Mobile number cannot be blank")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
	private String mobno;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	private String password;

	public Users() {
	}

	public Users(String email, String fullname, String mobno, String password) {
		this.email = email;
		this.fullname = fullname;
		this.mobno = mobno;
		this.password = password;
	}

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
