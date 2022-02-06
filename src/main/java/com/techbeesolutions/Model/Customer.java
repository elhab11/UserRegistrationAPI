package com.techbeesolutions.Model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	  @Id
	  @GeneratedValue
	 private Long id;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
    private String LastName;
	
	@Column(name="PhoneNumber")
	private long PhoneNumber;
	
	@Column(name="EmailAdress")
	private String EmailAdress;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="Age")
	private int Age;
	
    String regexName = "^[a-zA-z]\\p{L} .'-$";
    String regexPhone = "(\\d{3})(\\d{3})(\\d+)";
    
    
	
	public Customer(String firstName, String lastName, long phoneNumber, String emailAdress, String userName, int age) {
		
		    this.setFirstName(firstName);
	        this.setLastName(lastName);
	        this.setPhoneNumber(phoneNumber);
	        this.setUserName(userName);
	        this.setEmailAdress(emailAdress);
	        this.setAge(age);
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		 Pattern p = Pattern.compile(regexName);
	        Matcher first = p.matcher(FirstName);

	        if(FirstName.length() < 24 || first.matches()) {
	            this.FirstName = FirstName;
	        }
	        else {
	            System.out.println("Please enter a valid first name");
	        }
		FirstName = FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		
        Pattern p = Pattern.compile(regexName);
        Matcher last = p.matcher(lastName);

        if(lastName.length() < 24 || last.matches()) {
            this.LastName = lastName;
        }
        else {
            System.out.println("Please enter a valid last name");
        }
	}
	public Long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		
		String phoneNumbern = String.valueOf(phoneNumber);
		String strPattern = "^[0-9]{9}$";
		if(phoneNumbern.matches(strPattern)) {
			
			this.PhoneNumber = phoneNumber;
		}else 
            System.out.println("Enter a valid phone number");

	}
	public String getEmailAdress() {
		return EmailAdress;
	}
	public boolean setEmailAdress(String emailAdress) {
		if (emailAdress.contains("@"))
		{
		this.EmailAdress = emailAdress;
		return true;
		}
		else {
		System.out.println("Please enter valid email!!");
		return false;
		}
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		if(userName.length()<=24 && userName.length()>=18) 
		{
			this.UserName = userName;
		}
		else
		{
			System.out.println("Please enter valid user name!!");
		}
		
	}
	public int getAge() {
		return Age;
	}
	public boolean setAge(int age) {
		if(age <100 && age >18) 
		{
			this.Age = age;
			return true;
		}
		else
		{
			System.out.println("Please enter valid age!!");
			return false;
		}
	}
	@Override
	public String toString() {
		return "Registration [FirstName=" + FirstName + ", LastName=" + LastName + ", PhoneNumber=" + PhoneNumber
				+ ", EmailAdress=" + EmailAdress + ", UserName=" + UserName + ", Age=" + Age + "]";
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
