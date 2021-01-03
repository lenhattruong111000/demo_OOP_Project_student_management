package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnLecturer;
	private JRadioButton rdbtnAdmind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login Menu");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogin.setBounds(238, 10, 164, 42);
		contentPane.add(lblLogin);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnStudent.setBounds(108, 95, 103, 21);
		contentPane.add(rdbtnStudent);
		
		rdbtnLecturer = new JRadioButton("Lecturer");
		rdbtnLecturer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLecturer.setBounds(108, 151, 103, 21);
		contentPane.add(rdbtnLecturer);
		
		rdbtnAdmind = new JRadioButton("Admind");
		rdbtnAdmind.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnAdmind.setBounds(108, 201, 103, 21);
		contentPane.add(rdbtnAdmind);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnNext)== true) {
					setNextButton();
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.setBounds(343, 306, 111, 32);
		contentPane.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnCancel)== true) {
					setCancleButton();
				}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(481, 306, 103, 31);
		contentPane.add(btnCancel);
		
		ButtonGroup groupSelection = new ButtonGroup();
		groupSelection.add(rdbtnAdmind);
		groupSelection.add(rdbtnLecturer);
		groupSelection.add(rdbtnStudent);
	}
	public void setNextButton() {
		if(rdbtnAdmind.isSelected()==false && rdbtnLecturer.isSelected()==false &&
				rdbtnStudent.isSelected()==false) {
			JOptionPane.showMessageDialog(null, "Please, select one of these options above!");	
		}else {
			if(rdbtnAdmind.isSelected()==true) {
				dispose();
				 ManageStudentGUI m=new ManageStudentGUI();
				 m.setVisible(true);
			}
			if(rdbtnLecturer.isSelected()==true) {
				dispose();
				LecturerLoginGUI l =new LecturerLoginGUI();
				l.setVisible(true);
			}
			if(rdbtnStudent.isSelected()==true) {
				dispose();
				StudentLogin s =new StudentLogin();
				s.setVisible(true);
			}
		}
	}
	public void setCancleButton() {
		dispose();
	}
}
