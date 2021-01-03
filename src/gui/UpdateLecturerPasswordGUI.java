package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateLecturerPasswordGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pwdNewpassword;
	private JPasswordField pwdInputPasswordAgain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateLecturerPasswordGUI frame = new UpdateLecturerPasswordGUI();
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
	public UpdateLecturerPasswordGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdatePassword = new JLabel("Update Password");
		lblUpdatePassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUpdatePassword.setBounds(225, 10, 243, 37);
		contentPane.add(lblUpdatePassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(10, 78, 254, 25);
		contentPane.add(lblNewPassword);
		
		JLabel lblInputNewPasswordAgain = new JLabel("Input New Password Again:");
		lblInputNewPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInputNewPasswordAgain.setBounds(10, 130, 254, 25);
		contentPane.add(lblInputNewPasswordAgain);
		
		pwdNewpassword = new JPasswordField();
		pwdNewpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdNewpassword.setBounds(286, 78, 282, 25);
		contentPane.add(pwdNewpassword);
		
		pwdInputPasswordAgain = new JPasswordField();
		pwdInputPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdInputPasswordAgain.setBounds(286, 137, 282, 25);
		contentPane.add(pwdInputPasswordAgain);
		
		JButton btnUpdatePassword = new JButton("Update");
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdatePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdatePassword.setBounds(269, 235, 137, 37);
		contentPane.add(btnUpdatePassword);
	}

}
