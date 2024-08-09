package com.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="userrequirements")
public class UserRequirement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reuirementId" ,unique = true, nullable = false)
	
	private int requirementid;
	@Column(name="Namefirst")
	private String Namefirst;
	@Column(name="Namelast")
	private String Namelast;
	@Column(name="Phonenumber")
	private String Phonenumber;
	@Column(name="Skills")
	private String Skills;
	
	@Column(name="Wages")
	private int Wages;
	@Column(name="Address")
	private String Address;
	@Column(name="Date")
	private String Date;
	@OneToOne
	@JoinColumn(name="Userid")
	private  User userid;

	
	public UserRequirement() {
		super();
	}

	public UserRequirement(int requirementid, String namefirst, String namelast, String phonenumber, String skills,
			int wages, String address, String date, User userid) {
		super();
		this.requirementid = requirementid;
		Namefirst = namefirst;
		Namelast = namelast;
		Phonenumber = phonenumber;
		Skills = skills;
		Wages = wages;
		Address = address;
		Date = date;
		this.userid = userid;
	}

	public UserRequirement(String namefirst, String namelast, String phonenumber, String skills, int wages,
			String address, String date, User userId) {
		super();
		Namefirst = namefirst;
		Namelast = namelast;
		Phonenumber = phonenumber;
		Skills = skills;
		Wages = wages;
		Address = address;
		Date = date;
		this.userid = userId;
	}

	public int getRequirementId() {
		return requirementid;
	}

	public void setRequirementId(int requirementId) {
		this.requirementid = requirementId;
	}

	public String getNamefirst() {
		return Namefirst;
	}

	public void setNamefirst(String namefirst) {
		Namefirst = namefirst;
	}

	public String getNamelast() {
		return Namelast;
	}

	public void setNamelast(String namelast) {
		Namelast = namelast;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public String getSkills() {
		return Skills;
	}

	public void setSkills(String skills) {
		Skills = skills;
	}

	public int getWages() {
		return Wages;
	}

	public void setWages(int wages) {
		Wages = wages;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public User getUserId() {
		return userid;
	}

	public void setUserId(User userId) {
		this.userid = userId;
	}

	@Override
	public String toString() {
		return "UserRequirement [requirementId=" + requirementid + ", Namefirst=" + Namefirst + ", Namelast=" + Namelast
				+ ", Phonenumber=" + Phonenumber + ", Skills=" + Skills + ", Wages=" + Wages + ", Address=" + Address
				+ ", Date=" + Date + ", userId=" + userid + "]";
	}

	

	
	
	
	
}
