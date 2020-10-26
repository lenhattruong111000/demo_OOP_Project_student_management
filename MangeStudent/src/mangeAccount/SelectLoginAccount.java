package mangeAccount;

import java.util.Scanner;

import displayMenu.DisplayMenu;

public class SelectLoginAccount {
	public static Scanner scanner = new Scanner(System.in);
	public static void selectionLoginAccount() {
		String choose = null;
	    boolean exit = false;
	    DisplayMenu.showLoginMenu();
	    while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
                
                break;
            case "2":
               
                break;
            case "3":
               
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
