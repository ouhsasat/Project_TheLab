package com.example.CrudProject.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class Auditable{
	
	@CreatedBy
	protected String createdBy;
	@Temporal(TemporalType.TIMESTAMP)

    @CreatedDate
    
    protected Date createDate;
	
	


	
	
	
}


