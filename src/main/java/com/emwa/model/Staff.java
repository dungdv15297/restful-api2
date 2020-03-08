package com.emwa.model;
// Generated Feb 27, 2020 12:51:18 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Staff generated by hbm2java
 */
@Entity
@Table(name = "staff", catalog = "employeemanager")
public class Staff implements java.io.Serializable {

	private Long staffId;
	private Depart depart;
	private Position position;
	private String staffName;
	private Boolean gender;
	private String address;
	private Long leaderId;
	private String phoneNumber;
	private Date startDate;
	private Date endDate;
	private String email;
	private String avatar;
	private boolean status;
	private Account accounts = new Account();
	private Set<LeaveRequest> leaveRequests = new HashSet<LeaveRequest>(0);
	private Set<Recruitment> recruitments = new HashSet<Recruitment>(0);
	private Set<Report> reports = new HashSet<Report>(0);

	public Staff() {
	}

	public Staff(String staffName, Date startDate, String email, boolean status) {
		this.staffName = staffName;
		this.startDate = startDate;
		this.email = email;
		this.status = status;
	}

	public Staff(Depart depart, Position position, String staffName, Boolean gender, String address, Long leaderId,
			String phoneNumber, Date startDate, Date endDate, String email, String avatar, boolean status,
			Account accounts, Set<LeaveRequest> leaveRequests, Set<Recruitment> recruitments,
			Set<Report> reports) {
		this.depart = depart;
		this.position = position;
		this.staffName = staffName;
		this.gender = gender;
		this.address = address;
		this.leaderId = leaderId;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.email = email;
		this.avatar = avatar;
		this.status = status;
		this.accounts = accounts;
		this.leaveRequests = leaveRequests;
		this.recruitments = recruitments;
		this.reports = reports;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "staff_id", unique = true, nullable = false)
	public Long getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depart_id")
	@JsonBackReference
	public Depart getDepart() {
		return this.depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "positoin_id")
	@JsonBackReference
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Column(name = "staff_name", nullable = false, length = 250)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "gender")
	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Column(name = "address", length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "leader_id")
	public Long getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	@Column(name = "phone_number", length = 12)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "email", nullable = false, length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "avatar", length = 250)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "staff")
	@JsonManagedReference
	public Account getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
	@JsonManagedReference
	public Set<LeaveRequest> getLeaveRequests() {
		return this.leaveRequests;
	}

	public void setLeaveRequests(Set<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
	@JsonManagedReference
	public Set<Recruitment> getRecruitments() {
		return this.recruitments;
	}

	public void setRecruitments(Set<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
	@JsonManagedReference
	public Set<Report> getReports() {
		return this.reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

}
