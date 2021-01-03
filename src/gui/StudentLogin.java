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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class StudentLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdAccount;
	private JPasswordField passwordStudentLogin;
	private List<Student> studentList ;
	private StudentDao studentDao;
	public static String idLogin;
	public static String nameLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		studentDao = new StudentDao();
	    studentList = studentDao.read();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentLogin = new JLabel("Student Login");
		lblStudentLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblStudentLogin.setBounds(154, 10, 204, 37);
		contentPane.add(lblStudentLogin);
		
		JLabel lblIdAccount = new JLabel("ID Account:");
		lblIdAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdAccount.setBounds(10, 68, 114, 25);
		contentPane.add(lblIdAccount);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 124, 114, 20);
		contentPane.add(lblPassword);
		
		textIdAccount = new JTextField();
		textIdAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textIdAccount.setBounds(134, 69, 296, 25);
		contentPane.add(textIdAccount);
		textIdAccount.setColumns(10);
		
		passwordStudentLogin = new JPasswordField();
		passwordStudentLogin.setBounds(134, 119, 296, 25);
		contentPane.add(passwordStudentLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnLogin)) {
					setLoginButton();
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(226, 208, 93, 33);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnBack)) {
					setBackButton();
				}
			}
		});
		btnBack.setBounds(0, 0, 85, 21);
		contentPane.add(btnBack);
	}
	public void setBackButton() {
		dispose();
		LoginGUI l= new LoginGUI();
		l.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public void setLoginButton() {
		
			try {
				String id=textIdAccount.getText() ;
		        boolean isExisted = false;
		        int size = studentList.size();
		        for (int i = 0; i < size; i++) {
		            if (studentList.get(i).getId().equalsIgnoreCase(id)== true &&
		            		studentList.get(i).getPasswordAccount().equals(passwordStudentLogin.getText())==true) {
		                isExisted = true;
		                idLogin=id;
		                nameLogin=studentList.get(i).getName();
		                dispose();
		                YourInformation y= new YourInformation();
		                y.setVisible(true);
		                
		                break;
		               
		            }
		        }
		        if(isExisted==false) {
		        	
		        	JOptionPane.showMessageDialog(null, "this id "+id+" or password is not correct!");
		        	
		        }
			}catch(NullPointerException e) {
	        	
	        }
	}
}
