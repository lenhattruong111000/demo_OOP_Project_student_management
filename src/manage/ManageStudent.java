package manage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


import dao.StudentDao;
import displayMenu.DisplayObjectsInfomation;
import objects.Student;



public class ManageStudent {
	 public static Scanner scanner = new Scanner(System.in);
	    private List<Student> studentList;
	    private StudentDao studentDao;
	    /**
	     * init StudentDao object and
	     * read list student when init StudentManager object
	     */   
	    public ManageStudent() {
	        studentDao = new StudentDao();
	        studentList = studentDao.read();
	    }
	 
	   
	    // add student to studentList 
	    public void add() {
	        String id = inputId();
	        boolean isExisted = false;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)== true) {
	                isExisted = true;
	                System.out.println("this Id has been existed! Please input again");
	                id= inputId();
	                break;
	               
	            }
	        }
	        System.out.println("student id = " + id);
	        String name = inputName();
	        String major= inputMajor();
	        String strBirthDate= inputBirthDate();
	        String sex=inputSex();
	        String address = inputAddress();
	        String phoneNumber= inputPhoneNumber();
	        String mail= inputMail();
	        float gpa = inputGpa();
	        Student student = new Student(id, name, major, strBirthDate, sex, address, phoneNumber, mail, gpa);
	        student.setId(id);
	        student.setName(name);
	        student.setMajor(major);
	        student.setSex(sex);
	        student.setAddress(address);
	        student.setBirthDate(strBirthDate);
	        student.setAge();
	        studentList.add(student);
	        studentDao.write(studentList);
	    }
	  
	    // update information of Student
	    public void edit(String id) {
	        boolean isExisted = false;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
	                isExisted = true;
	                studentList.get(i).setName(inputName());
	                studentList.get(i).setMajor(inputMajor());
	                studentList.get(i).setSex(inputSex());
	                studentList.get(i).setSex(inputBirthDate());
	                studentList.get(i).setAge();
	                studentList.get(i).setPhoneNumber(inputPhoneNumber());
	                studentList.get(i).setMail(inputMail());
	                studentList.get(i).setAddress(inputAddress());
	                studentList.get(i).setGpa(inputGpa());
	                break;
	            }
	        }
	        if (!isExisted) {
	            System.out.printf("id = %d not existed.\n", id);
	        } else {
	            studentDao.write(studentList);
	        }
	    }
	 
	    // delete student information
	    public void delete(String id) {
	        Student student = null;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
	                student = studentList.get(i);
	                break;
	            }
	        }
	        if (student != null) {
	            studentList.remove(student);
	            studentDao.write(studentList);
	        } else {
	            System.out.printf("id = %s not existed.\n", id);
	        }
	    }
	 
	    // sort student by name
	    public class SortStudentByName implements Comparator<Student> {
	        @Override
	        public int compare(Student student1, Student student2) {
	            return student1.getName().compareTo(student2.getName());
	        }
	    }
	    public void sortStudentByName() {
	        Collections.sort(studentList, new SortStudentByName());
	    }
	 
	    
	    // sort student by id
	    public class SortStudentByGPA implements Comparator<Student> {
	        @Override
	        public int compare(Student student1, Student student2) {
	            if (student1.getGpa() > student2.getGpa()) {
	                return 1;
	            }
	            return -1;
	        }
	    }
	    public void sortStudentByGPA() {
	        Collections.sort(studentList, new SortStudentByGPA());
	    }
	 
	    // show list student to screen  
	    public void show() {
	    	DisplayObjectsInfomation.displayStudentInfo();
	    	for (Student student : studentList) {
	            System.out.format("%10s | ", student.getId());
	            System.out.format("%30s | ", student.getName());
	            System.out.format("%7s | ", student.getSex());
	            System.out.format("%5s    | ", student.getBirthDate());
	            System.out.format("%5d | ", student.getAge());
	            System.out.format("%20s | ", student.getAddress());
	            System.out.format("%20s | ", student.getPhoneNumber());
                System.out.format("%20s | ", student.getMail());
	            System.out.format("%10.1f%n", student.getGpa());
	        }
	    }
	    // find student by id
	    public void findById(String id) {
	    	Student student = null;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
	                student = studentList.get(i);
	                DisplayObjectsInfomation.displayStudentInfo();
	                System.out.format("%10s | ", studentList.get(i).getId());
	                System.out.format("%20s | ", studentList.get(i).getName());
	                System.out.format("%7s | ", studentList.get(i).getSex());
	                System.out.format("%5s    | ", studentList.get(i).getBirthDate());
	                System.out.format("%5d | ", studentList.get(i).getAge());
	                System.out.format("%20s | ", studentList.get(i).getAddress());
	                System.out.format("%20s | ", studentList.get(i).getPhoneNumber());
	                System.out.format("%20s | ", studentList.get(i).getMail());
	                System.out.format("%10.1f%n", studentList.get(i).getGpa());
	                
	                break;
	            }
	        }
	        if (student != null) {
	            
	        } else {
	            System.out.printf("id = %s not existed.\n", id);
	        }
	    }
	    // input student id 
	    public String inputId() {
	        System.out.print("Input student id: ");
	        while (true) {
	            try {
	                String id = scanner.nextLine();
	                return id;
	            } catch (NullPointerException ex) {
	                System.out.print("invalid! Input student id again: ");
	            }
	        }
	    }
	     
	    // input student name
	    private String inputName() {
	        System.out.print("Input student name: ");
	        return scanner.nextLine();
	    }
	    // input major of student 
	    private String inputMajor() {
	        System.out.print("Input major of student: ");
	        return scanner.nextLine();
	    }
	    
	    //input student birthdate
	    private String inputBirthDate() {
	    	System.out.print("Input student birthDate:");
	        return scanner.nextLine();
	    }
	    
	    // input sex of student
	    private String inputSex() {
	    	System.out.print("Input student sex: ");
	        return scanner.nextLine();
	    }
	    
	    // input student address
	    private String inputAddress() {
	        System.out.print("Input student address: ");
	        return scanner.nextLine();
	    }
	    
	   //input phoneNUmber
	    private String inputPhoneNumber() {
	        System.out.print("Input phone number of student: ");
	        return scanner.nextLine();
	    }
	    
	    //input mail
	    private String inputMail() {
	        System.out.print("Input mail of student: ");
	        return scanner.nextLine();
	    }
	    
	    // input student gpa 
	    private float inputGpa() {
	        System.out.print("Input student gpa: ");
	        while (true) {
	            try {
	                float gpa = Float.parseFloat((scanner.nextLine()));
	                if (gpa < 0.0 && gpa > 100.0) {
	                    throw new NumberFormatException();
	                }
	                return gpa;
	            } catch (NumberFormatException ex) {
	                System.out.print("invalid! Input student age again: ");
	            }
	        }
	    }
	 
	    // getter && setter
	    public List<Student> getStudentList() {
	        return studentList;
	    }
	 
	    public void setStudentList(List<Student> studentList) {
	        this.studentList = studentList;
	    }
}
