package com.sr.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Table(name="Mp_JPA_Doctor")
@Entity
@Data
public class DoctorEntity 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName="DID_SEQ",initialValue =2,allocationSize = 1)
	@GeneratedValue(generator ="gen1",strategy=GenerationType.SEQUENCE)
	private Integer did;
	@Column(length=30)
    private String dname;
	@Column(length=30)
	private String specialz;
	private Double fee;
	@Column(length=30)
	private String qlfy;
	
	//Meta Data Properties
	@Version
	private Integer updateCount;
	@CreationTimestamp
	@Column(updatable=false,insertable = true)
	private LocalDateTime createdOn;
	@UpdateTimestamp
	@Column(updatable =true,insertable = false)
	private LocalDateTime lastaccessedOn;
	@Column(length=30)
	private String activString="active";
	@Column(length=30)
	private String createdBy;
	@Column(length=30)
	private String updatedBy;

}
