//package com.example.CrudProject.entity;
//
//
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EntityListeners;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@Table(name="user")
//@Setter
//@Getter
//
//public class User {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	
//	@Column
//	String username;
//	@Column
//	String password;
//	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String  username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	
//
//	
//	
//	
//
//}
