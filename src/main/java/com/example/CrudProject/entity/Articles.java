package com.example.CrudProject.entity;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.CrudProject.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//import lombok.AllArgsConstructor;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="articles")
@Setter
@Getter
//@Data
//@NoArgsConstructor
//@AllArgsConstructor


public class Articles extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String title;
	@Column
	String content;
	@Column
	String address;
	@Column
	String AutherName;
	

	public Articles() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public String getAuthor() {
		return content;
	}

	public void setAuthor(String author) {
		this.content = author;
	}

	public String getNoOfPages() {
		return address;
	}

	public void setNoOfPages(String noOfPages) {
		this.address = noOfPages;
	}

	public String getPublication() {
		return AutherName;
	}

	public void setPublication(String publication) {
		this.AutherName = publication;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + ", content=" + content + ", address=" + address 
				+ ", AutherName=" + AutherName + "]";
	}

}
//public class Articles {
//	
//
//	public Articles(UUID randomUUID, String Title, String string2, String string3, String string4) {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Articles() {
//		
//
//		UUID id;
//		
//	 String Title;
//	
//		 String Content;
//		
//		String CreatedDate;
//	
//		String AuthorName;
//		// TODO Auto-generated constructor stub
//	}
//
//	@Id
//	@GeneratedValue(generator="UUID")
//	@Column(name="a_id")
//
//	private UUID id;
//	//private String id;
//	@Column(name="a_title")
//	private String Title;
//	@Column(name="a_content")
//	private String Content;
//	@Column(name="a_createDate")
//	private String CreatedDate;
//	@Column(name="a_authorName")
//	private String AuthorName;
//	
//}
