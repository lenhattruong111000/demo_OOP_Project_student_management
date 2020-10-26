package displayMenu;

public class DisplayMenu {
	public static void showLoginMenu() {
		System.out.println("1.Login with student account");
		System.out.println("2. Login with lecturer/teacher account");
		System.out.println("3. Login with the admin account");
		System.out.println("0. Exit");
	}
	
	public static void showMenu() {
        System.out.println("===========Menu=============/");
        System.out.println("| 1. Add student.           \\");
        System.out.println("| 2. Edit student by id.    /");
        System.out.println("| 3. Delete student by id.  \\");
        System.out.println("| 4. Sort student by gpa.   /");
        System.out.println("| 5. Sort student by name.  \\");
        System.out.println("| 6. Show student.          /");
        System.out.println("| 7. Find student by id.    \\");
        System.out.println("| 0. exit.                  /");
        System.out.println("============================\\");
        System.out.print("Please choose: ");
    }
	public static void showMenuAdmin() {
		System.out.println("1. Student");
    	System.out.println("2. Lecture/Teacher");
    	System.out.println("0. Exit");
    	System.out.print("Please choose: ");
	}
	public static void showMenuManageLecturer() {
		 	System.out.println("=======================Menu=======================/");
	        System.out.println("| 1. Add lecture/teacher.                         \\");
	        System.out.println("| 2. Edit lecture/teacher by name of account .    /");
	        System.out.println("| 3. Delete lecture/teacher by name of account.  \\");
	        System.out.println("| 4. Show lecture/teacher.                       /");
	        System.out.println("| 5. Find lecture/teacher by name of account.    \\");
	        System.out.println("| 0. exit.                                       /");
	        System.out.println("=================================================\\");
	        System.out.print("Please choose: ");
	}
	
}
