package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import account.Account;
import dao.AccountDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ForgotPasswordGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFullUserName;
	private JTextField textAccountName;
	private JTextField textDateOfBirth;
	private JTextField textPhone;
	private JTextField textMail;
	private JTextField textWorkplace;
	private List<Account> accountList;
	private AccountDao accountDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordGUI frame = new ForgotPasswordGUI();
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
	public ForgotPasswordGUI() {
		accountDao= new AccountDao();
		accountList= accountDao.read();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullUserName = new JLabel("Full User Name: ");
		lblFullUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFullUserName.setBounds(10, 70, 165, 23);
		contentPane.add(lblFullUserName);
		
		JLabel lblVerifyInformation = new JLabel("Verify Information");
		lblVerifyInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblVerifyInformation.setBounds(185, 10, 262, 37);
		contentPane.add(lblVerifyInformation);
		
		JLabel lblAccountName = new JLabel("Account Name:");
		lblAccountName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountName.setBounds(10, 115, 136, 23);
		contentPane.add(lblAccountName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(10, 229, 136, 23);
		contentPane.add(lblPhone);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMail.setBounds(10, 269, 136, 23);
		contentPane.add(lblMail);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(10, 175, 136, 23);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblWorkplace = new JLabel("Workplace:");
		lblWorkplace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkplace.setBounds(10, 314, 103, 23);
		contentPane.add(lblWorkplace);
		
		textFullUserName = new JTextField();
		textFullUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFullUserName.setBounds(185, 70, 273, 25);
		contentPane.add(textFullUserName);
		textFullUserName.setColumns(10);
		
		textAccountName = new JTextField();
		textAccountName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textAccountName.setBounds(185, 115, 273, 25);
		contentPane.add(textAccountName);
		textAccountName.setColumns(10);
		
		textDateOfBirth = new JTextField();
		textDateOfBirth.setBounds(185, 173, 273, 25);
		contentPane.add(textDateOfBirth);
		textDateOfBirth.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPhone.setBounds(185, 229, 273, 23);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMail.setBounds(187, 269, 271, 25);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textWorkplace = new JTextField();
		textWorkplace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textWorkplace.setBounds(185, 314, 273, 23);
		contentPane.add(textWorkplace);
		textWorkplace.setColumns(10);
		
		JLabel lblExInputDateOfBirth = new JLabel("Ex: 1/1/2000--> input 01012000");
		lblExInputDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExInputDateOfBirth.setBounds(185, 160, 233, 13);
		contentPane.add(lblExInputDateOfBirth);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyAccount();
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerify.setBounds(263, 372, 122, 37);
		contentPane.add(btnVerify);
	}
	public void verifyAccount() {
		try {
			String accountName =textAccountName.getText();
	        boolean isExisted = false;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	            if (accountList.get(i).getId().equalsIgnoreCase(accountName)== true &&
	            		accountList.get(i).getName().equalsIgnoreCase(textFullUserName.getText())==true &&
	            		accountList.get(i).getStrBirthDate().equalsIgnoreCase(textDateOfBirth.getText())==true &&
	            		accountList.get(i).getPhoneNumber().equalsIgnoreCase(textPhone.getText())==true &&
	            		accountList.get(i).getMail().equals(textMail.getText())==true &&
	            		accountList.get(i).getWorkplace().equalsIgnoreCase(textWorkplace.getText())==true) {
	                isExisted = true;
	                JOptionPane.showMessageDialog(null, "Account "+accountName+" verify successfull.");
	                UpdateLecturerPasswordGUI u =new UpdateLecturerPasswordGUI();
	                u.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	                u.setVisible(true);
	                
	                break;
	               
	            }
	        }
	        if(isExisted==false) {
		        		JOptionPane.showMessageDialog(null, "The account cannot verify");	
	        }
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Please, filling on information into the blank");
		}
	}
}
