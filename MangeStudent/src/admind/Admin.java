package admind;

import java.io.Serializable;
import java.util.Scanner;

import displayMenu.DisplayMenu;
import mangeAccount.AccountManager;
import selectFeatures.SelectFeatures;
import selectFeatures.SelectFeaturesOfStudent;
import selectFeatures.SelectionFeaturesOfLecture;

public class Admin {
	public static Scanner scanner= new Scanner(System.in);
	public static void admin() {
		
		String choose = null;
	    boolean exit = false;
	    
	    	DisplayMenu.showMenuAdmin();
	     	while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	            	SelectFeaturesOfStudent.selectFeatures();
	                break;
	            case "2":
	                SelectionFeaturesOfLecture.selectFeatures();;
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
	
}
