package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import dao.StudentDao;
import dao.SubjectOfStudentDao;
import objects.Student;
import subject.Subject;

import java.util.List;
import javax.swing.JRadioButton;

public class ManageStudentGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textName;
	private JTextField textMajor;
	private JTextField textDateOfBirth;
	private JTextField textAddress;
	private JTextField textPhoneNumber;
	private JTextField textMail;
	private JTable table;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnUnknown;
	private JRadioButton rdbtnNoSelect;
	private List<Student> studentList ;
	private StudentDao studentDao;
	private List<Subject> subjectOfStudentList;
	private SubjectOfStudentDao subjectOfStudentDao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGUI frame = new ManageStudentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageStudentGUI() {
		studentDao = new StudentDao();
	    studentList = studentDao.read();
	    
	    subjectOfStudentDao = new SubjectOfStudentDao();
	    subjectOfStudentList =subjectOfStudentDao.read();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentInformation = new JLabel("Student Information");
		lblStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStudentInformation.setBounds(321, 10, 209, 27);
		contentPane.add(lblStudentInformation);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(10, 72, 139, 27);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 125, 139, 25);
		contentPane.add(lblName);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMajor.setBounds(10, 171, 139, 27);
		contentPane.add(lblMajor);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(10, 227, 139, 27);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSex.setBounds(10, 264, 119, 25);
		contentPane.add(lblSex);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 310, 139, 27);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(10, 347, 139, 27);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMail.setBounds(10, 396, 139, 27);
		contentPane.add(lblMail);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				addInfo();
			    setTableModel();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(10, 470, 85, 37);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource().equals(btnEdit)) {
					EditGUI edit= new EditGUI();
					edit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					edit.setVisible(true);				
				}
			}	
		});
		
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setBounds(128, 470, 85, 37);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				setTableModel();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(251, 469, 98, 37);
		contentPane.add(btnDelete);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSort.setBounds(10, 517, 158, 39);
		contentPane.add(btnSort);
		
		JButton btnFindById = new JButton("Find by ID");
		btnFindById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnFindById)) {
					FindByIdGUI s =new FindByIdGUI();
					// close only own's frame not close the another frame;
					s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					s.setVisible(true);
					///////////////
					// EXIT_ON_CLOSE: close all frame has relationship
					// HIDE_ON_CLOSE : Hide the Frame when press Close botton
					// DO_NOTHING_ON_CLOSE : do nothing
					///////////////
					
				}	
			}
		});
		btnFindById.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFindById.setBounds(191, 518, 158, 37);
		contentPane.add(btnFindById);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textId.setBounds(150, 72, 257, 27);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName.setBounds(150, 124, 257, 27);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textMajor = new JTextField();
		textMajor.setBounds(150, 175, 257, 27);
		contentPane.add(textMajor);
		textMajor.setColumns(10);
		
		textDateOfBirth = new JTextField();
		textDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDateOfBirth.setBounds(150, 227, 257, 27);
		contentPane.add(textDateOfBirth);
		textDateOfBirth.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAddress.setBounds(150, 310, 257, 27);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPhoneNumber.setBounds(150, 347, 257, 27);
		contentPane.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMail.setBounds(150, 399, 257, 27);
		contentPane.add(textMail);
		textMail.setColumns(10);
	
		table= new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		setTableModel();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBounds(20, 0, -406, 481);
		contentPane.add(table);
		
		JScrollPane scrollPane =new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(417, 72, 869, 483);
		contentPane.add(scrollPane);
		
		JLabel lblWarningDateOfBirth = new JLabel("Ex: 1/1/2000 -->input: 01012000");
		lblWarningDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningDateOfBirth.setBounds(150, 210, 199, 14);
		contentPane.add(lblWarningDateOfBirth);
		
		JLabel lblWarningMajor = new JLabel("Ex: Infomation Technology-->input: IT");
		lblWarningMajor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningMajor.setBounds(150, 161, 199, 14);
		contentPane.add(lblWarningMajor);
		
		JLabel lblWarningInputId = new JLabel("input ID here to add, or delete");
		lblWarningInputId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningInputId.setBounds(150, 56, 257, 14);
		contentPane.add(lblWarningInputId);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMale.setBounds(150, 267, 71, 21);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemale.setBounds(223, 268, 85, 21);
		contentPane.add(rdbtnFemale);
		
		rdbtnUnknown = new JRadioButton("Unknown");
		rdbtnUnknown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnUnknown.setBounds(310, 267, 101, 21);
		contentPane.add(rdbtnUnknown);
		
		rdbtnNoSelect =new JRadioButton();
		
		ButtonGroup groupSexSelection =new ButtonGroup();
		groupSexSelection.add(rdbtnMale);
		groupSexSelection.add(rdbtnFemale);
		groupSexSelection.add(rdbtnUnknown);
		groupSexSelection.add(rdbtnNoSelect);
		
		JButton btnRefreshToUpdate = new JButton("Refresh to Update");
		btnRefreshToUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManageStudentGUI m= new ManageStudentGUI();
				m.setDefaultCloseOperation(EXIT_ON_CLOSE);
				m.setVisible(true);
			}
		});
		btnRefreshToUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRefreshToUpdate.setBounds(692, 616, 199, 37);
		contentPane.add(btnRefreshToUpdate);
		
		JLabel lblAfterEditing = new JLabel("(*) After editing the student information your need to press the button here to upload the file ");
		lblAfterEditing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAfterEditing.setBounds(10, 622, 672, 29);
		contentPane.add(lblAfterEditing);
		
		getGpa();
		
	
	}
	public void setTableModel() {
		table.setModel(new AbstractTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] columnName= {"ID", "Name", "Major", "Sex", "Date of birth", "Address", "Phone", "Mail", "GPA"};
			Object[][] rawData= new Object[studentList.size()][9];
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				for(int i=0; i<studentList.size();i++) {
					rawData[i][0]= studentList.get(i).getId();
					rawData[i][1]= studentList.get(i).getName();
					rawData[i][2]= studentList.get(i).getMajor();
					rawData[i][3]= studentList.get(i).getSex();
					rawData[i][4]= studentList.get(i).getBirthDate();
					rawData[i][5]= studentList.get(i).getAddress();
					rawData[i][6]= studentList.get(i).getPhoneNumber();
					rawData[i][7]= studentList.get(i).getMail();
					rawData[i][8]= studentList.get(i).getGpa();
				}
				return rawData[rowIndex][columnIndex];
			}
			
			@Override
			public int getRowCount() {
				
				return rawData.length;
			}
			
			@Override
			public String getColumnName(int column) {
				return columnName[column].toString();
			}
			
			@Override
			public int getColumnCount() {
				return columnName.length;
			}
		});
	}
	
	public void addInfo() {
		
		try {
			String id= textId.getText();
	        boolean isExisted = false;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)== true) {
	                isExisted = true;
	                JOptionPane.showMessageDialog(null, "this id "+id+" has been existed!");
	                
	                break;
	               
	            }
	        }
	        if(isExisted==false) {

	        	String name = textName.getText();
		        String major= textMajor.getText();
		        String strBirthDate= textDateOfBirth.getText();
		        String sex=null;
		        if(rdbtnMale.isSelected()==true) {
		        	sex="1";
		        
		        }
		        else if(rdbtnFemale.isSelected()==true) {
		        	sex="0";
		        }
		        else if(rdbtnUnknown.isSelected()==true) {
		        	sex="-1";
		        }else {
		        	JOptionPane.showMessageDialog(null, "Please, select the sex of student");
		        }
		        String address = textAddress.getText();
		        String phoneNumber= textPhoneNumber.getText();
		        String mail= textMail.getText();
		        float gpa=getGpa();
		        //Student student = new Student(id, name, major, strBirthDate, sex, address, phoneNumber, mail, gpa);
		        Student student= new Student();
		        student.setId(id);
		        student.setName(name);
		        student.setMajor(major);
		        student.setSex(sex);
		        student.setAddress(address);
		        student.setBirthDate(strBirthDate);
		        student.setStrBirthDate(strBirthDate);
		        student.setPhoneNumber(phoneNumber);
		        student.setMail(mail);
		        student.setGpa(gpa);
		        student.setAge();
		        student.setPasswordAccount(strBirthDate);
		        studentList.add(student);
		        studentDao.write(studentList);
		        
		        //delete the data was filled in the blank
		       
		        textAddress.setText(null);
                textDateOfBirth.setText(null);
                textId.setText(null);
                textMail.setText(null);
                textMajor.setText(null);
                textName.setText(null);
                textPhoneNumber.setText(null);
                rdbtnMale.setSelected(false);
		        rdbtnFemale.setSelected(false);
		        rdbtnUnknown.setSelected(false);
		        rdbtnNoSelect.setSelected(true);
		        
	        }
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Please, filling on information into the blank");
		}
	}

	public void delete() {
		  Student student = null;
		  String id= textId.getText();
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
	            JOptionPane.showMessageDialog(null, "the id "+id+" is not existed");
	        }
	}	
	public float getGpa() {
		 float gpa = 0;
	        Subject subject=null;
	        int countSubject=0;
	        for(int i=0; i<studentList.size();i++) {
	        	for(int j=0; j<subjectOfStudentList.size();j++) {
		        	subject = subjectOfStudentList.get(j);
		        	if(subject.getIdStudent().equalsIgnoreCase(studentList.get(i).getId())==true) {
		        		countSubject++;
		        		gpa=gpa+((subject.getProccessGrade()+subject.getMidtermGrade()+subject.getFinalGrade())/3);
		        		
		        	}
		        }
	        	if(countSubject!=0) {
	        		gpa=gpa/countSubject;
	        		studentList.get(i).setGpa(gpa);
	        		studentDao.write(studentList);
	        		gpa=0;
	        		countSubject=0;
	        	}
	        	
	        	
	        }
	        return gpa;
	}
}
