package mangeAccount;

import java.io.Serializable;

public class Account implements Serializable{
	private String nameUser;
	private String accountName;
	private String accountPassword;
	
	public Account() {
	    }
	 
	public Account(String nameUser, String accountName, String accountPassword) {
		super();
		this.nameUser= nameUser;
		this.accountName=accountName;
		this.accountPassword=accountPassword;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	
	
}

