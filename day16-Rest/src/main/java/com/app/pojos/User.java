package com.app.pojos;

import org.hibernate.annotations.Table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="my_users")
public class User extends BaseEntity {
   
	@Column(length=30)
	private String firstName;
	@Column(length=30)
	private String lastName;
	@Column(length=30,unique=true)
	private String UserName;
	private int age;
	private double salary;
}
