package displayMenu;

public class DisplayObjectsInfomation {
	public static void displayStudentInfo() {
		System.out.format("%10s  | ", "Student ID");
        System.out.format("%30s | ", "Full name");
        System.out.format("%7s | ", "Sex");
        System.out.format("%5s | ", "Date of Birth");
        System.out.format("%5s | ", "Age");
        System.out.format("%20s | ", "Address");
        System.out.format("%20s | ", "Phone");
        System.out.format("%20s | ", "Mail");
        System.out.format("%9s", "GPA");
        System.out.println();
	}
}
