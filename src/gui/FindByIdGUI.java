package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.StudentDao;
import objects.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FindByIdGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSearchId;
	private List<Student> studentList ;
	private StudentDao studentDao;
	private JLabel lblIdText;
	private JLabel lblNameText;
	private JLabel lblMajorText;
	private JLabel lblAddressText;
	private JLabel lblPhoneText;
	private JLabel lblSexText;
	private JLabel lblGPAText;
	private JLabel lblDateOfBirthText;
	private JLabel lblMailText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindByIdGUI frame = new FindByIdGUI();
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
	public FindByIdGUI() {
		studentDao = new StudentDao();
	    studentList = studentDao.read();
	    
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(10, 46, 127, 25);
		contentPane.add(lblStudentId);
		
		textSearchId = new JTextField();
		textSearchId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSearchId.setBounds(147, 46, 189, 26);
		contentPane.add(textSearchId);
		textSearchId.setColumns(10);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(24, 124, 45, 33);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(24, 183, 65, 25);
		contentPane.add(lblName);
		
		JLabel lblMajor = new JLabel("Major: ");
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMajor.setBounds(24, 279, 65, 25);
		contentPane.add(lblMajor);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(24, 409, 86, 25);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(24, 318, 86, 29);
		contentPane.add(lblPhone);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMail.setBounds(24, 357, 65, 27);
		contentPane.add(lblMail);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(24, 239, 127, 19);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGPA = new JLabel("GPA:");
		lblGPA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGPA.setBounds(411, 127, 72, 27);
		contentPane.add(lblGPA);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSex.setBounds(411, 233, 65, 25);
		contentPane.add(lblSex);
		
		lblIdText = new JLabel("");
		lblIdText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdText.setBounds(171, 127, 168, 27);
		contentPane.add(lblIdText);
		
		lblNameText = new JLabel("");
		lblNameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameText.setBounds(171, 184, 238, 23);
		contentPane.add(lblNameText);
		
		lblMajorText = new JLabel("");
		lblMajorText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMajorText.setBounds(168, 280, 168, 23);
		contentPane.add(lblMajorText);
		
		lblPhoneText = new JLabel("");
		lblPhoneText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneText.setBounds(168, 320, 238, 25);
		contentPane.add(lblPhoneText);
		
		lblAddressText = new JLabel("");
		lblAddressText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddressText.setBounds(168, 412, 262, 23);
		contentPane.add(lblAddressText);
		
		
		
		lblGPAText = new JLabel("");
		lblGPAText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGPAText.setBounds(482, 127, 86, 27);
		contentPane.add(lblGPAText);
		
		
		lblMailText = new JLabel("");
		lblMailText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMailText.setBounds(168, 361, 262, 23);
		contentPane.add(lblMailText);
		
		
		
		lblDateOfBirthText = new JLabel("");
		lblDateOfBirthText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirthText.setBounds(168, 233, 152, 25);
		contentPane.add(lblDateOfBirthText);
		
		lblSexText = new JLabel("");
		lblSexText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSexText.setBounds(470, 233, 113, 23);
		contentPane.add(lblSexText);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findById(textSearchId.getText());
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(381, 46, 107, 27);
		contentPane.add(btnSearch);
		
		
	}
	 public void findById(String id) {
	    	Student student = null;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
	                student = studentList.get(i);
	                lblIdText.setText(student.getId());
	                lblNameText.setText(student.getName());
	                lblAddressText.setText(student.getAddress());
	                lblDateOfBirthText.setText(student.getBirthDate());
	                lblGPAText.setText(String.valueOf(student.getGpa()));
	                lblMailText.setText(student.getMail());
	                lblMajorText.setText(student.getMajor());
	                lblPhoneText.setText(student.getPhoneNumber());
	                lblSexText.setText(student.getSex());
	                
	                break;
	            }
	        }
	        if (student == null) {
	        	JOptionPane.showMessageDialog(null, "the id "+textSearchId.getText()+" is not exist");
	        } 
	    }
}
