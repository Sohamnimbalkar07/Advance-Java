package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;


@Entity
@Table(name="users")
public class User extends BaseEntity{
//id | name    | email          | password | reg_amt | reg_date   | role 
	
	private String name;
	private String email;
	private String password;
	@Column(name="reg_amt")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	@Enumerated(EnumType.STRING)
	private Role role;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
		
}
