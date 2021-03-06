package com.emwa.model;
// Generated Feb 27, 2020 12:51:18 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * LeaveRequest generated by hbm2java
 */
@Entity
@Table(name = "leave_request", catalog = "employeemanager")
public class LeaveRequest implements java.io.Serializable {

	private Long lrId;
	private Staff staff;
	private Date lrStart;
	private Date lrEnd;
	private Long leaderId;
	private String reason;
	private Date createTime;
	private int status;

	public LeaveRequest() {
	}

	public LeaveRequest(Staff staff, Date lrStart, Date lrEnd, Long leaderId, String reason, Date createTime,
			int status) {
		this.staff = staff;
		this.lrStart = lrStart;
		this.lrEnd = lrEnd;
		this.leaderId = leaderId;
		this.reason = reason;
		this.createTime = createTime;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "lr_id", unique = true, nullable = false)
	public Long getLrId() {
		return this.lrId;
	}

	public void setLrId(Long lrId) {
		this.lrId = lrId;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "lr_start", nullable = false, length = 10)
	public Date getLrStart() {
		return this.lrStart;
	}

	public void setLrStart(Date lrStart) {
		this.lrStart = lrStart;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lr_end", nullable = false, length = 10)
	public Date getLrEnd() {
		return this.lrEnd;
	}

	public void setLrEnd(Date lrEnd) {
		this.lrEnd = lrEnd;
	}

	@Column(name = "leader_id", nullable = false)
	public Long getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	@Column(name = "reason", nullable = false, length = 250)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
