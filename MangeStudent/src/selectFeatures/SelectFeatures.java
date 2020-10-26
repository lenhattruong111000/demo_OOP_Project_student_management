package selectFeatures;

import java.util.Scanner;

import admind.Admin;
import displayMenu.DisplayMenu;
import manageStudent.Student;
import manageStudent.StudentManager;
import mangeAccount.Account;
import mangeAccount.AccountManager;



public class SelectFeatures {
	
	public static Scanner scanner = new Scanner(System.in);
	public static void selectFeartures() {
		String choose = null;
	    boolean exit = false;
	    StudentManager studentManager = new StudentManager();
	    AccountManager accountManager = new AccountManager();
	    String studentId;
	    String accountName;
	    String accountPassword;
	    final String accountAdmin="admin";
	    final String accountAdmindPassword="adminpro123";
	    String inputPasswordAdmin=null;
	    DisplayMenu.showLoginMenu();
	    while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	            	studentId = studentManager.inputId();
	                studentManager.findById(studentId);
	                break;
	            case "2":
	                accountName = accountManager.inputAccountName();
	                
	                accountPassword = accountManager.inputAccountPassword();
	 	            Account account = null;
	 	            int size = accountManager.getAccountList().size();
	 	            for (int i = 0; i < size; i++) {
	 	                 if (accountManager.getAccountList().get(i).getAccountName().equalsIgnoreCase(accountName)==true&&
	 	                    accountManager.getAccountList().get(i).getAccountPassword().equals(accountPassword)==true) {
	 	                        account = accountManager.getAccountList().get(i);
	 	                        SelectFeaturesOfStudent.selectFeatures();
	 	                        break;
	 	                  }
	 	             }
	 	                if (account != null) {
	 	                    
	 	                } else {
	 	                    System.out.printf("Name of account = %s not existed.\n", accountName);
	 	                }
	               
	                break;
	            case "3":
	                System.out.println("input password of admin:");
	                inputPasswordAdmin= scanner.nextLine();
	                if(inputPasswordAdmin.equals(accountAdmindPassword)==true) {
	                	Admin.admin();
	                }	
	                break;
	            case "0":
	                System.out.println("exited!");
	                exit = true;
	                break;
	            default:
	                System.out.println("invalid! please choose action in below menu:");
	                break;
	            }
	            if (exit) {
	                break;
	            }
	            // show menu
	            DisplayMenu.showLoginMenu();
	        }
		
		
	}
}
