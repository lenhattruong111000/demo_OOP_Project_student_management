package selectFeatures;

import java.util.Scanner;

import displayMenu.DisplayMenu;
import mangeAccount.AccountManager;

public class SelectionFeaturesOfLecture {
	public static Scanner scanner = new Scanner(System.in);
	public static void selectFeatures() {
		
		String choose = null;
	    boolean exit = false;
	   
	    AccountManager accountManager = new AccountManager();
	    String accountName;
			
	    	DisplayMenu.showMenuManageLecturer();
	     	while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	                accountManager.addAccount();
	                break;
	            case "2":
	                accountName = accountManager.inputAccountName();
	                accountManager.edit(accountName);
	                break;
	            case "3":
	                accountName = accountManager.inputAccountName();
	                accountManager.delete(accountName);
	                break;
	            case "4":
	                accountManager.show();
	                break;
	            case "5":
	            	accountName = accountManager.inputAccountName();
	                accountManager.findByAccountName(accountName);
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
}
