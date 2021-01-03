package account;

import java.io.Serializable;
import java.util.List;

import objects.Person;
import subject.Subject;

public class Account extends Person implements Serializable {
	private String accountPassword;
	private String workplace;
	public List<Subject> subjectList;
	public Account() {
	    }
	 
	public Account(String accountName,String accountPassword,String nameUser,
			String strBirthDate,String phoneNumber,String mail,String workplace) {
		super(accountName, nameUser, strBirthDate, phoneNumber, mail);
		
		this.accountPassword= accountPassword;
		this.workplace= workplace;
	}
	
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	
}
