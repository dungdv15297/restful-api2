package com.emwa.model;
// Generated Feb 27, 2020 12:51:18 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Recruitment generated by hbm2java
 */
@Entity
@Table(name = "recruitment", catalog = "employeemanager")
public class Recruitment implements java.io.Serializable {

	private Integer recruitmentId;
	private Staff staff;
	private int title;
	private int description;
	private int status;

	public Recruitment() {
	}

	public Recruitment(Staff staff, int title, int description, int status) {
		this.staff = staff;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "recruitment_id", unique = true, nullable = false)
	public Integer getRecruitmentId() {
		return this.recruitmentId;
	}

	public void setRecruitmentId(Integer recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	@JsonBackReference
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(name = "title", nullable = false)
	public int getTitle() {
		return this.title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false)
	public int getDescription() {
		return this.description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
