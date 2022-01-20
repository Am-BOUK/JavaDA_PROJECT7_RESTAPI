package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 4)
	private Integer id;
	@NotBlank(message = "Username is mandatory")
	@Column(length = 125)
	private String username;
	@NotBlank(message = "Password is mandatory")
	@Column(length = 125)
	private String password;
	@NotBlank(message = "FullName is mandatory")
	@Column(length = 125)
	private String fullname;
	@NotBlank(message = "Role is mandatory")
	@Column(length = 125)
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
