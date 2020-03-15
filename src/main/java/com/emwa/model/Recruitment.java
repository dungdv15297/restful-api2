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

	private Long recruitmentId;
	private Staff staff;
	private String title;
	private String description;
	private Boolean status;

	public Recruitment() {
	}

	public Recruitment(Staff staff, String title, String description, Boolean status) {
		this.staff = staff;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "recruitment_id", unique = true, nullable = false)
	public Long getRecruitmentId() {
		return this.recruitmentId;
	}

	public void setRecruitmentId(Long recruitmentId) {
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
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
