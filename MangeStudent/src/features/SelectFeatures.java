package features;

import java.util.Scanner;

import displayMenu.DisplayMenu;
import manage.ManageAccount;
import manage.ManageStudent;
import account.Account;

public class SelectFeatures {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void selectFeaturesOfStudent() {
		String choose = null;
	    boolean exit = false;
	   
	    ManageStudent manageStudent = new ManageStudent();
	    String studentId;
			
	    	DisplayMenu.showMenu();
	     	while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	             //   manageStudent.add();
	                break;
	            case "2":
	                studentId = manageStudent.inputId();
	                manageStudent.edit(studentId);
	                break;
	            case "3":
	                studentId = manageStudent.inputId();
	                manageStudent.delete(studentId);
	                break;
	            case "4":
	                manageStudent.sortStudentByGPA();
	                break;
	            case "5":
	                manageStudent.sortStudentByName();
	                break;
	            case "6":
	                manageStudent.show();
	                break;
	            case "7":
	            	studentId = manageStudent.inputId();
	                manageStudent.findById(studentId);
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
	            DisplayMenu.showMenu();
	        }
	}
	
	public static void selectFeaturesOfLecturer() {
		String choose = null;
	    boolean exit = false;
	   
	    ManageAccount manageAccount = new ManageAccount();
	    String accountName;
			
	    	DisplayMenu.showMenuManageLecturer();
	     	while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	                manageAccount.addAccount();
	                break;
	            case "2":
	                accountName = manageAccount.inputAccountName();
	                manageAccount.edit(accountName);
	                break;
	            case "3":
	                accountName = manageAccount.inputAccountName();
	                manageAccount.delete(accountName);
	                break;
	            case "4":
	                manageAccount.show();
	                break;
	            case "5":
	            	accountName = manageAccount.inputAccountName();
	                manageAccount.findByAccountName(accountName);
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
	            DisplayMenu.showMenuManageLecturer();
	        }
	}
	
	public static void selectFeaturesOfAmind() {
		String choose = null;
	    boolean exit = false;
	    
	    	DisplayMenu.showMenuAdmin();
	     	while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	            	selectFeaturesOfStudent();
	                break;
	            case "2":
	                selectFeaturesOfLecturer();
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

		    	DisplayMenu.showMenuAdmin();
	        }
	}
	public static void selectFeaturesOfMenu() {
		String choose = null;
	    boolean exit = false;
	    ManageStudent  manageStudent= new ManageStudent();
	    ManageAccount manageAccount = new ManageAccount();
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
	            	studentId = manageStudent.inputId();
	                manageStudent.findById(studentId);
	                break;
	            case "2":
//	                accountName = manageAccount.inputAccountName();
//	                
//	                accountPassword = manageAccount.inputAccountPassword();
//	 	            Account account = null;
//	 	            // check account lecturers
//	 	            int size = manageAccount.getAccountList().size();
//	 	            for (int i = 0; i < size; i++) {
//	 	                 if (manageAccount.getAccountList().get(i).getAccountName().equalsIgnoreCase(accountName)==true&&
//	 	                    manageAccount.getAccountList().get(i).getAccountPassword().equals(accountPassword)==true) {
//	 	                        account = manageAccount.getAccountList().get(i);
//	 	                        selectFeaturesOfStudent();
//	 	                        break;
//	 	                  }
//	 	             }
//	 	                if (account != null) {
//	 	                    
//	 	                } else {
//	 	                    System.out.printf("Name of account = %s not existed.\n", accountName);
//	 	                }
//	               
	                break;
	            case "3":
	                System.out.println("input password of admin:");
	                inputPasswordAdmin= scanner.nextLine();
	                if(inputPasswordAdmin.equals(accountAdmindPassword)==true) {
	                	selectFeaturesOfAmind();
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

