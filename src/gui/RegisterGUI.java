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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RegisterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAccountName;
	private JLabel lblPassword;
	private JLabel lblInputPasswordAgain;
	private JLabel lblPhone;
	private JLabel lblMail;
	private JLabel lblWorkplace;
	private JLabel lblDateOfBirth;
	private JTextField textFullUserName;
	private JTextField textAccountName;
	private JPasswordField passwordAccount;
	private JPasswordField passwordRegisterAgain;
	private JTextField textPhone;
	private JTextField textMail;
	private JTextField textWorkplace;
	private JButton btnRegister;
	private JTextField textDateOfBirth;
	private JLabel lblEx;
	private JButton btnPolicy;
	private JRadioButton rdbtnAgree;
	private List<Account> accountList;
	private AccountDao accountDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		accountDao= new AccountDao();
		accountList= accountDao.read();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterInformation = new JLabel("Register Information");
		lblRegisterInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegisterInformation.setBounds(206, 10, 278, 37);
		contentPane.add(lblRegisterInformation);
		
		JLabel lblFullUserName = new JLabel("Full User Name:");
		lblFullUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFullUserName.setBounds(34, 70, 211, 25);
		contentPane.add(lblFullUserName);
		
		lblAccountName = new JLabel("Account ID:");
		lblAccountName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountName.setBounds(34, 121, 211, 25);
		contentPane.add(lblAccountName);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(34, 170, 211, 25);
		contentPane.add(lblPassword);
		
		lblInputPasswordAgain = new JLabel("Input Password again:");
		lblInputPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInputPasswordAgain.setBounds(34, 214, 211, 31);
		contentPane.add(lblInputPasswordAgain);
		
		lblPhone = new JLabel("Phone: ");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(34, 334, 211, 25);
		contentPane.add(lblPhone);
		
		lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMail.setBounds(34, 381, 211, 25);
		contentPane.add(lblMail);
		
		lblWorkplace = new JLabel("Workplace:");
		lblWorkplace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkplace.setBounds(34, 431, 211, 25);
		contentPane.add(lblWorkplace);
		
		lblDateOfBirth = new JLabel("Date Of Birth: ");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDateOfBirth.setBounds(34, 282, 192, 25);
		contentPane.add(lblDateOfBirth);
		
		textFullUserName = new JTextField();
		textFullUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFullUserName.setBounds(249, 70, 288, 26);
		contentPane.add(textFullUserName);
		textFullUserName.setColumns(10);
		
		textAccountName = new JTextField();
		textAccountName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textAccountName.setBounds(249, 121, 288, 26);
		contentPane.add(textAccountName);
		textAccountName.setColumns(10);
		
		passwordAccount = new JPasswordField();
		passwordAccount.setBounds(249, 164, 288, 25);
		contentPane.add(passwordAccount);
		
		passwordRegisterAgain = new JPasswordField();
		passwordRegisterAgain.setBounds(249, 214, 288, 25);
		contentPane.add(passwordRegisterAgain);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPhone.setBounds(249, 333, 288, 26);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMail.setBounds(249, 381, 288, 26);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textWorkplace = new JTextField();
		textWorkplace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textWorkplace.setBounds(249, 430, 288, 26);
		contentPane.add(textWorkplace);
		textWorkplace.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccount();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(281, 526, 157, 37);
		contentPane.add(btnRegister);
		
		textDateOfBirth = new JTextField();
		textDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDateOfBirth.setBounds(249, 281, 288, 26);
		contentPane.add(textDateOfBirth);
		textDateOfBirth.setColumns(10);
		
		lblEx = new JLabel("Ex: 1/1/2000 --> input: 01012000");
		lblEx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEx.setBounds(249, 266, 288, 16);
		contentPane.add(lblEx);
		
		rdbtnAgree = new JRadioButton("Agree with all policy.");
		rdbtnAgree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnAgree.setBounds(249, 462, 217, 21);
		contentPane.add(rdbtnAgree);
		
		btnPolicy = new JButton("Policy");
		btnPolicy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnPolicy)) {
					PolicyGUI p =new PolicyGUI();
					p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					p.setVisible(true);
				}
			}
		});
		btnPolicy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPolicy.setBounds(458, 466, 79, 16);
		contentPane.add(btnPolicy);
	}
	@SuppressWarnings("deprecation")
	public void addAccount() {
		try {
			String accountName =textAccountName.getText();
	        boolean isExisted = false;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	            if (accountList.get(i).getId().equalsIgnoreCase(accountName)== true &&
	            		accountList.get(i).getMail().equals(textMail.getText())==true) {
	                isExisted = true;
	                if(accountList.get(i).getId().equalsIgnoreCase(accountName)== true) {
	                	 JOptionPane.showMessageDialog(null, "this account "+accountName+" has been exited!");
	                }
	               if(accountList.get(i).getMail().equals(textMail.getText())==true) {
	            	   JOptionPane.showMessageDialog(null, "this mail: "+textMail.getText()+" has been exited!");
	               }
	                
	                break;
	               
	            }
	        }
	        if(isExisted==false) {

	        	String userName = textFullUserName.getText();
		        String strBirthDate= textDateOfBirth.getText();
		        String phoneNumber= textPhone.getText();
		        String mail= textMail.getText();
		        String workplace =textWorkplace.getText();
		        String accountPassword = passwordAccount.getText();
		        
		        if(accountPassword.equals(passwordRegisterAgain.getText())==true &&
		        		rdbtnAgree.isSelected()==true) {
		        	Account account =new Account(accountName, accountPassword, userName, strBirthDate, phoneNumber, mail, workplace);
			        account.setId(accountName);
			        account.setName(userName);
			        account.setBirthDate(strBirthDate);
			        account.setStrBirthDate(strBirthDate);
			        account.setPhoneNumber(phoneNumber);
			        account.setMail(mail);
			        account.setAge();
			        accountList.add(account);
			        accountDao.write(accountList);
			        JOptionPane.showMessageDialog(null, "Register is successfull");
		        }else {
		        	if(accountPassword.equals(passwordRegisterAgain.getText())!=true) {
		        		JOptionPane.showMessageDialog(null, "Two password must be the same");
		        	}
		        		
		        	if(rdbtnAgree.isSelected()==false) {
		        		JOptionPane.showMessageDialog(null, "Please, agree with the policy to register");
		        	}
		        }
		        
		  
	        }
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Please, filling on information into the blank");
		}
	}
}
