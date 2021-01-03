package gui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.StudentDao;
import objects.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditGUI extends JFrame {

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
	private JTextField textGPA;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnUnknown;
	private List<Student> studentList ;
	private StudentDao studentDao;
	private JTextField textFindIdNeedUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditGUI frame = new EditGUI();
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
	public EditGUI() {
		studentDao = new StudentDao();
	    studentList = studentDao.read();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateInformation = new JLabel("Update Information");
		lblUpdateInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUpdateInformation.setBounds(121, 10, 264, 37);
		contentPane.add(lblUpdateInformation);
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(10, 140, 139, 27);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 177, 139, 25);
		contentPane.add(lblName);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMajor.setBounds(10, 227, 139, 27);
		contentPane.add(lblMajor);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(10, 281, 139, 27);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSex.setBounds(10, 311, 119, 25);
		contentPane.add(lblSex);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 346, 139, 27);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(10, 396, 139, 27);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMail.setBounds(10, 444, 139, 27);
		contentPane.add(lblMail);
		
		JLabel lblGpa = new JLabel("GPA:");
		lblGpa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGpa.setBounds(10, 484, 139, 27);
		contentPane.add(lblGpa);
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textId.setBounds(150, 140, 257, 27);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName.setBounds(150, 176, 257, 27);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textMajor = new JTextField();
		textMajor.setBounds(150, 227, 257, 27);
		contentPane.add(textMajor);
		textMajor.setColumns(10);
		
		textDateOfBirth = new JTextField();
		textDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDateOfBirth.setBounds(150, 281, 257, 27);
		contentPane.add(textDateOfBirth);
		textDateOfBirth.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAddress.setBounds(150, 346, 257, 27);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPhoneNumber.setBounds(150, 396, 257, 27);
		contentPane.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMail.setBounds(150, 447, 257, 27);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textGPA = new JTextField();
		textGPA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textGPA.setBounds(150, 484, 183, 27);
		contentPane.add(textGPA);
		textGPA.setColumns(10);
		
		JLabel lblWarningDateOfBirth = new JLabel("Ex: 1/1/2000 -->input: 01012000");
		lblWarningDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningDateOfBirth.setBounds(150, 268, 199, 14);
		contentPane.add(lblWarningDateOfBirth);
		
		JLabel lblWarningMajor = new JLabel("Ex: Infomation Technology-->input: IT");
		lblWarningMajor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningMajor.setBounds(150, 213, 199, 14);
		contentPane.add(lblWarningMajor);
		
		JLabel lblWarningInputId = new JLabel("input ID here to add, or delete");
		lblWarningInputId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningInputId.setBounds(150, 126, 257, 14);
		contentPane.add(lblWarningInputId);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMale.setBounds(150, 314, 71, 21);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemale.setBounds(223, 314, 85, 21);
		contentPane.add(rdbtnFemale);
		
		rdbtnUnknown = new JRadioButton("Unknown");
		rdbtnUnknown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnUnknown.setBounds(310, 314, 101, 21);
		contentPane.add(rdbtnUnknown);
		
		ButtonGroup groupSexSelection =new ButtonGroup();
		groupSexSelection.add(rdbtnMale);
		groupSexSelection.add(rdbtnFemale);
		groupSexSelection.add(rdbtnUnknown);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(textFindIdNeedUpdate.getText());
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(182, 531, 139, 41);
		contentPane.add(btnUpdate);
		
		JLabel lblIdFindIdToUpdate = new JLabel("Find Id to Update:");
		lblIdFindIdToUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdFindIdToUpdate.setBounds(10, 57, 170, 27);
		contentPane.add(lblIdFindIdToUpdate);
		
		textFindIdNeedUpdate = new JTextField();
		textFindIdNeedUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFindIdNeedUpdate.setBounds(186, 57, 221, 27);
		contentPane.add(textFindIdNeedUpdate);
		textFindIdNeedUpdate.setColumns(10);
		
		JButton btnFindIdtoUpdate = new JButton("Find");
		btnFindIdtoUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindInfoNeedUpdate(textFindIdNeedUpdate.getText());
			}
		});
		btnFindIdtoUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFindIdtoUpdate.setBounds(417, 57, 85, 28);
		contentPane.add(btnFindIdtoUpdate);
		
	
	}
	public void FindInfoNeedUpdate(String id) {
		Student student= null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                student= studentList.get(i);
                // show information of student need to edit
                
                textAddress.setText(student.getAddress());
                textDateOfBirth.setText(student.getStrBirthDate());
                textGPA.setText(String.valueOf(student.getGpa()));
                textId.setText(student.getId());
                textMail.setText(student.getMail());
                textMajor.setText(student.getMajor());
                textName.setText(student.getName());
                textPhoneNumber.setText(student.getPhoneNumber());
                if(student.getSex().equalsIgnoreCase("Male")) {
                	rdbtnMale.setSelected(true);
                }
                if(student.getSex().equalsIgnoreCase("Female")) {
                	rdbtnFemale.setSelected(true);
                }
                if(student.getSex().equalsIgnoreCase("Unknown")) {
                	rdbtnUnknown.setSelected(true);
                }
                break;
            }
        }
        if (student== null) {

           JOptionPane.showMessageDialog(null, "this "+id+" is not existed");
        } 
	}
	public void update(String id) {
		try {
			Student student= null;
	        boolean isExisted = false;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
	                isExisted = true;
	                student= studentList.get(i);
	        
	                student.setId(textId.getText());
			        student.setName(textName.getText());
			        student.setMajor(textMajor.getText());
			        String sex=null;
			        if(rdbtnMale.isSelected()==true) {
			        	sex="1";
			        
			        }
			        if(rdbtnFemale.isSelected()==true) {
			        	sex="0";
			        }
			        if(rdbtnUnknown.isSelected()==true) {
			        	sex="-1";
			        }
			        student.setSex(sex);
			        student.setAddress(textAddress.getText());
			        student.setBirthDate(textDateOfBirth.getText());
			        student.setPhoneNumber(textPhoneNumber.getText());
			        student.setMail(textMail.getText());
			        student.setGpa(Float.parseFloat(textGPA.getText()));
			        student.setAge();
	               
	                break;
	            }
	        }
	        if (!isExisted) {
	        	JOptionPane.showMessageDialog(null, "this "+id+" is not existed");
	        } else {
	            studentDao.write(studentList);
	            JOptionPane.showMessageDialog(null, "Update "+id+" successfull");
	        }
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "please choose sex of student");
		}
		
	}
}
