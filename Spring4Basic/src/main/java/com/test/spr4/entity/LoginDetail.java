package com.test.spr4.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the LOGIN_DETAILS database table.
 * 
 */
@Entity
@Table(name="LOGIN_DETAILS")
public class LoginDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOGIN_DETAILS_LOGDETID_GENERATOR", sequenceName="SEQ_LOGINDETAILS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOGIN_DETAILS_LOGDETID_GENERATOR")
	@Column(name="LOG_DET_ID")
	private long logDetId;

	@Column(name="LOGIN_DATE")
	private Timestamp loginDate;

	@Column(name="LOGIN_ROLE")
	private String loginRole;

	@Column(name="LOGOUT_DATE")
	private Timestamp logoutDate;

	//bi-directional many-to-one association to Login
    @ManyToOne
	@JoinColumn(name="LOGIN_ID")
	private Login login;

    public LoginDetail() {
    }

	public long getLogDetId() {
		return this.logDetId;
	}

	public void setLogDetId(long logDetId) {
		this.logDetId = logDetId;
	}

	public Timestamp getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginRole() {
		return this.loginRole;
	}

	public void setLoginRole(String loginRole) {
		this.loginRole = loginRole;
	}

	public Timestamp getLogoutDate() {
		return this.logoutDate;
	}

	public void setLogoutDate(Timestamp logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}