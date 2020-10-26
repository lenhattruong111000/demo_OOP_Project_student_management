package mangeAccount;

import java.util.List;
import java.util.Scanner;

public class AccountManager {
	  public static Scanner scanner = new Scanner(System.in);
	  private List<Account> accountList;
	  private AccountDao accountDao;
	  
	  public AccountManager() {
		  accountDao= new AccountDao();
		  accountList= accountDao.read();
	  }
	  
	  public void addAccount() {
	        String accountName = inputAccountName();
	        boolean isExisted = false;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	            if (accountList.get(i).getAccountName().equalsIgnoreCase(accountName)== true) {
	                isExisted = true;
	                System.out.println("this Id has been existed! Please input again");
	                accountName= inputAccountName();
	                break;
	               
	            }
	        }
	        System.out.println("Name of acccount = " + accountName);
	        String  accountPassword= inputAccountPassword(); 
	        String  nameUser=inputNameUser();
	        Account account = new Account(nameUser,accountName, accountPassword);
	        account.setNameUser(nameUser);
	        account.setAccountName(accountName);
	        account.setAccountPassword(accountPassword);
	        accountList.add(account);
	        accountDao.write(accountList);
	  }
	  public void edit(String accountName) {
	        boolean isExisted = false;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	        	if (accountList.get(i).getAccountName().equalsIgnoreCase(accountName)) {
	                isExisted = true;
	                accountList.get(i).setNameUser(inputNameUser());
	                accountList.get(i).setAccountName(inputAccountName());
	                accountList.get(i).setAccountPassword(inputAccountPassword());
	               
	                break;
	            }
	        }    
	        if (!isExisted) {
	            System.out.printf("Name of account = %d not existed.\n", accountName);
	        } else {
	            accountDao.write(accountList);
	        }
	  }
	  public void delete(String accountName) {
	        Account account = null;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	            if (accountList.get(i).getAccountName().equalsIgnoreCase(accountName)) {
	                account = accountList.get(i);
	                break;
	            }
	        }
	        if (account != null) {
	            accountList.remove(account);
	            accountDao.write(accountList);
	        } else {
	            System.out.printf("id = %s not existed.\n", accountName);
	        }
	  }
	  public void findByAccountName(String accountName) {
	    	Account account = null;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	            if (accountList.get(i).getAccountName().equalsIgnoreCase(accountName)) {
	                account = accountList.get(i);
	                System.out.format("%30s  | ", "Name User");
	                System.out.format("%20s  | ", "Account Name");
	                System.out.format("%20s | ", "Password");
	                System.out.println();
	                System.out.format("%30s  | ",accountList.get(i).getNameUser());
	                System.out.format("%20s | ", accountList.get(i).getAccountName());
	                System.out.format("%20s | ", accountList.get(i).getAccountPassword());
	                
	                break;
	            }
	        }
	        if (account != null) {
	            
	        } else {
	            System.out.printf("id = %s not existed.\n", accountName);
	        }
	  }
	  public void show() {
		  System.out.format("%30s    | ", "Name User");
		  	System.out.format("%20s  | ", "Name of account");
	        System.out.format("%30s%n ", "password");
	       
	        System.out.println();
	    	for (Account account : accountList) {
	    		System.out.format("%30s  | ", account.getNameUser());
	    		System.out.format("%20s  | ", account.getAccountName());
	            System.out.format("%30s%n ", account.getAccountPassword());
	            
	        }
	   }
	  private String inputNameUser() {
	        System.out.print("Input user name: ");
	        return scanner.nextLine();
	    }
	  public String inputAccountName() {
	        System.out.print("Input name of account: ");
	        return scanner.nextLine();
	  }
	  public String inputAccountPassword() {
	        System.out.print("Input Password: ");
	        return scanner.nextLine();
	  }
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	  
}
	
