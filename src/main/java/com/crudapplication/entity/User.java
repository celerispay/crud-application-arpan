package com.crudapplication.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name", nullable=false)
	private String name;
	
	@Column(name="user_password", nullable=false)
	private  String password;
	
	@Column(name="role", nullable=false)
	private String role;
	
	@Column(name="enabled")
	private boolean enabled;
	
	

}
