package selectFeatures;

import java.util.Scanner;

import displayMenu.DisplayMenu;
import manageStudent.StudentManager;
import mangeAccount.AccountManager;

public class SelectFeaturesOfStudent {
	
	public static Scanner scanner = new Scanner(System.in);
	public static void selectFeatures() {
		
		String choose = null;
	    boolean exit = false;
	   
	    StudentManager studentManager = new StudentManager();
	    String studentId;
			
	    	DisplayMenu.showMenu();
	     	while (true) {
	            choose = scanner.nextLine();
	            switch (choose) {
	            case "1":
	                studentManager.add();
	                break;
	            case "2":
	                studentId = studentManager.inputId();
	                studentManager.edit(studentId);
	                break;
	            case "3":
	                studentId = studentManager.inputId();
	                studentManager.delete(studentId);
	                break;
	            case "4":
	                studentManager.sortStudentByGPA();
	                break;
	            case "5":
	                studentManager.sortStudentByName();
	                break;
	            case "6":
	                studentManager.show();
	                break;
	            case "7":
	            	studentId = studentManager.inputId();
	                studentManager.findById(studentId);
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

}
