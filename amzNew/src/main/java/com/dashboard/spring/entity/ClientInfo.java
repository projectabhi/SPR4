package com.dashboard.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CLIENT_INFO database table.
 * 
 */
@Entity
@Table(name="CLIENT_INFO")
@NamedQuery(name="ClientInfo.findAll", query="SELECT c FROM ClientInfo c")
public class ClientInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENT_INFO_CLIENTID_GENERATOR", sequenceName="SEQ_CLIENTINFO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENT_INFO_CLIENTID_GENERATOR")
	@Column(name="CLIENT_ID")
	private long clientId;

	@Column(name="CLIENT_IP")
	private String clientIp;

	@Column(name="CLIENT_OS")
	private String clientOs;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	public ClientInfo() {
	}

	public long getClientId() {
		return this.clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getClientOs() {
		return this.clientOs;
	}

	public void setClientOs(String clientOs) {
		this.clientOs = clientOs;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}