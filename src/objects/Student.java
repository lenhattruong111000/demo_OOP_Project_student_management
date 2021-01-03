package objects;

import java.io.Serializable;
import java.util.List;

import javax.swing.JOptionPane;

import subject.MySubject;
import subject.Subject;

public class Student extends Person implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String major;
	private float gpa;
	private String passwordAccount;
	public List<Subject> subjectListOfStudent;
	public Student() {
		
	}
	 public Student(String id, String name,String major, String strBirthDate,
    		 String sex, String address,String phoneNumber, String mail, float gpa) {
		 super(id, name, strBirthDate, sex, address, phoneNumber, mail);
		 this.gpa =gpa;
		 this.major=major;
	 }
	
	 public float getGpa() {
		return gpa;
	}
	 
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major.toUpperCase();
	}
	
	
	public String getPasswordAccount() {
		return passwordAccount;
	}
	
	public void setPasswordAccount(String passwordAccount) {
		this.passwordAccount = passwordAccount;
	}
}
