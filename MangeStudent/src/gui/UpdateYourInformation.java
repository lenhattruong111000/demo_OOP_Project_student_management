package gui;

import java.awt.BorderLayout;
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

public class UpdateYourInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textNewPhone;
	private JTextField textNewMail;
	private JLabel lblTextMail;
	private JLabel lblTextPhone;
	private List<Student> studentList ;
	private StudentDao studentDao;
	private JLabel lblTextId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateYourInformation frame = new UpdateYourInformation();
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
	public UpdateYourInformation() {
		studentDao = new StudentDao();
	    studentList = studentDao.read();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateYourInfomation = new JLabel("Update Your Infomation");
		lblUpdateYourInfomation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUpdateYourInfomation.setBounds(174, 10, 325, 31);
		contentPane.add(lblUpdateYourInfomation);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(10, 121, 108, 25);
		contentPane.add(lblPhone);
		
		JLabel lblNewPhone = new JLabel("New Phone:");
		lblNewPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPhone.setBounds(10, 182, 108, 25);
		contentPane.add(lblNewPhone);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMail.setBounds(10, 232, 108, 20);
		contentPane.add(lblMail);
		
		JLabel lblNewMail = new JLabel("New Mail:");
		lblNewMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewMail.setBounds(10, 275, 108, 20);
		contentPane.add(lblNewMail);
		
		lblTextPhone = new JLabel("");
		lblTextPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTextPhone.setBounds(128, 123, 242, 23);
		contentPane.add(lblTextPhone);
		
		lblTextMail = new JLabel("");
		lblTextMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTextMail.setBounds(132, 231, 405, 21);
		contentPane.add(lblTextMail);
		
		textNewPhone = new JTextField();
		textNewPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNewPhone.setBounds(128, 182, 242, 25);
		contentPane.add(textNewPhone);
		textNewPhone.setColumns(10);
		
		textNewMail = new JTextField();
		textNewMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNewMail.setBounds(128, 275, 371, 24);
		contentPane.add(textNewMail);
		textNewMail.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudentInformation(StudentLogin.idLogin);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(252, 377, 118, 44);
		contentPane.add(btnUpdate);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(381, 322, 118, 21);
		contentPane.add(btnChangePassword);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(10, 72, 108, 20);
		contentPane.add(lblId);
		
		lblTextId = new JLabel("");
		lblTextId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTextId.setBounds(128, 72, 195, 21);
		contentPane.add(lblTextId);
	}
	public void updateStudentPassword() {
		
	}
	public void updateStudentInformation(String id) {
		try {
			Student student= null;
	        boolean isExisted = false;
	        int size = studentList.size();
	        for (int i = 0; i < size; i++) {
	            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
	                isExisted = true;
	                student= studentList.get(i);
	                lblTextId.setText(student.getId());
	                lblTextPhone.setText(student.getPhoneNumber());
	                lblTextMail.setText(student.getMail());
	                
	                student.setPhoneNumber(textNewPhone.getText());
	                student.setMail(textNewMail.getText());
	                
	               
	                break;
	            }
	        }
	        if (!isExisted) {
	        	JOptionPane.showMessageDialog(null, "this "+id+" is not existed");
	        } else {
	            studentDao.write(studentList);
	            JOptionPane.showMessageDialog(null, "Update "+id+" successfull");
	            showInformation(id);
	        }
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "please choose sex of student");
		}		
	}
	public void showInformation(String id) {
		Student student= null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                student= studentList.get(i);
                lblTextId.setText(student.getId());
                lblTextPhone.setText(student.getPhoneNumber());
                lblTextMail.setText(student.getMail());
                textNewMail.setText(student.getMail());
                textNewPhone.setText(student.getPhoneNumber());
                break;
            }
        }
	}
}
