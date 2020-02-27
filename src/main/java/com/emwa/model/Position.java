package com.emwa.model;
// Generated Feb 27, 2020 12:51:18 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Position generated by hbm2java
 */
@Entity
@Table(name = "position", catalog = "employeemanager")
public class Position implements java.io.Serializable {

	private Integer positionId;
	private String positionName;
	private String description;
	private Set<Staff> staffs = new HashSet<Staff>(0);

	public Position() {
	}

	public Position(String positionName) {
		this.positionName = positionName;
	}

	public Position(String positionName, String description, Set<Staff> staffs) {
		this.positionName = positionName;
		this.description = description;
		this.staffs = staffs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "position_id", unique = true, nullable = false)
	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@Column(name = "position_name", nullable = false, length = 250)
	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
	public Set<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

}