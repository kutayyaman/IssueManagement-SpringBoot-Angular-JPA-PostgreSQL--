package com.kutayyaman.issuemanagement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable { //Serializable bu nesnenin networkten tasinabilmesini veya diske yazilabilmesi gibi islemleri bu classa o yetenekleri kazandirmak icin implement ediyoruz.
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "created_by",length = 100)
	private String createdBy;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@Column(name = "updated_by",length = 100)
	private String updatedBy;
	
	@Column(name = "status")
	private Boolean status;
	
}
