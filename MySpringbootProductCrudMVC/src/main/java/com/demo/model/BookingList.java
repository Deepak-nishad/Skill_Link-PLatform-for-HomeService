package com.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bookinglist")
public class BookingList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int Bookingid;
	@ManyToOne
	@JoinColumn(name="Userid")
	private User userid;
//	private int userid;
	@Column(name="sid")
	private int sid;
	@Column(name="Namefirst")
	private String Namefirst;
	@Column(name="Namelast")
	private String Namelast;
	@Column(name="Phonenumber")
	private String Phonenumber;
	@Column(name="Skills")
	private String Skills;
	@Column(name="Date")
	private String Date;
	@Column(name="Rating")
	private String Rating;
	@Column(name="Status")
	private String Status;
	@Column(name="Wages")
	private String Wages;
	@Column(name="Address")
	private String Address;
	@Column(name="requirementId")
	private int requirementId;
	
	
	
	public BookingList(User userid, int sid, String namefirst, String namelast, String phonenumber, String skills,
			String date, String rating, String status, String wages, String address, int requirementId) {
		super();
		this.userid = userid;
		this.sid = sid;
		Namefirst = namefirst;
		Namelast = namelast;
		Phonenumber = phonenumber;
		Skills = skills;
		Date = date;
		Rating = rating;
		Status = status;
		Wages = wages;
		Address = address;
		this.requirementId = requirementId;
	}
	public BookingList(User userid, int sid, String namefirst, String namelast, String phonenumber, String skills,
			String date, String rating, String status, int requirementId) {
		super();
		this.userid = userid;
		this.sid = sid;
		Namefirst = namefirst;
		Namelast = namelast;
		Phonenumber = phonenumber;
		Skills = skills;
		Date = date;
		Rating = rating;
		Status = status;
		this.requirementId = requirementId;
	}
	public BookingList() {
		super();
		
	}
	public BookingList(User userid, int sid, String namefirst, String namelast, String phonenumber, String skills,
			String rating, String status, int requirementId) {
		super();
		this.userid = userid;
		this.sid = sid;
		Namefirst = namefirst;
		Namelast = namelast;
		Phonenumber = phonenumber;
		Skills = skills;
		Rating = rating;
		Status = status;
		this.requirementId = requirementId;
	}
	
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getWages() {
		return Wages;
	}
	public void setWages(String wages) {
		Wages = wages;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getBookingid() {
		return Bookingid;
	}
	public void setBookingid(int bookingid) {
		Bookingid = bookingid;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}
	@Override
	public String toString() {
		return "BookingList [Bookingid=" + Bookingid + ", userid=" + userid + ", sid=" + sid + ", Namefirst="
				+ Namefirst + ", Namelast=" + Namelast + ", Phonenumber=" + Phonenumber + ", Skills=" + Skills
				+ ", Date=" + Date + ", Rating=" + Rating + ", Status=" + Status + ", Wages=" + Wages + ", Address="
				+ Address + ", requirementId=" + requirementId + "]";
	}

	
	


	

	
	

	
	
}
