package com.test.spr4.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the LOGIN database table.
 * 
 */
@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOGIN_LOGINID_GENERATOR", sequenceName="SEQ_LOGIN")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOGIN_LOGINID_GENERATOR")
	@Column(name="LOGIN_ID")
	private long loginId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	@Column(name="USER_ROLE")
	private String userRole;

	private String username;

	//bi-directional many-to-one association to LoginDetail
	@OneToMany(mappedBy="login")
	private Set<LoginDetail> loginDetails;

    public Login() {
    }

	public long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<LoginDetail> getLoginDetails() {
		return this.loginDetails;
	}

	public void setLoginDetails(Set<LoginDetail> loginDetails) {
		this.loginDetails = loginDetails;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password
				+ ", userRole=" + userRole + ", username=" + username
				+ ", loginDetails=" + loginDetails + "]";
	}
	
	
}