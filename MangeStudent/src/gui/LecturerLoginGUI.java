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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LecturerLoginGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textUserName;
	private JPasswordField passwordAccount;
	private JButton btnLogin;
	private AccountDao accountDao;
	private List<Account> accountList;
	public static String idLecturer=null;
	public static String nameLecturer=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerLoginGUI frame = new LecturerLoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}catch(ExceptionInInitializerError e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LecturerLoginGUI() {
		accountDao= new AccountDao();
		accountList=accountDao.read();
		  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLecturerLogin = new JLabel("Lecturer Login");
		lblLecturerLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLecturerLogin.setBounds(229, 10, 133, 43);
		contentPane.add(lblLecturerLogin);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(38, 94, 99, 30);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(38, 150, 99, 30);
		contentPane.add(lblPassword);
		
		textUserName = new JTextField();
		textUserName.setBounds(147, 92, 340, 30);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		passwordAccount = new JPasswordField();
		passwordAccount.setBounds(147, 150, 340, 28);
		contentPane.add(passwordAccount);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnLogin)) {
					setLoginButton();
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(210, 262, 151, 43);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnRegister)) {
					RegisterGUI r= new RegisterGUI();
					r.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					r.setVisible(true);
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(394, 204, 123, 33);
		contentPane.add(btnRegister);
		
		JButton btnNewButton = new JButton("Forgot password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPasswordGUI f= new ForgotPasswordGUI();
				f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				f.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(39, 207, 150, 30);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnBack)==true) {
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
			String id=textUserName.getText() ;
	        boolean isExisted = false;
	        int size = accountList.size();
	        for (int i = 0; i < size; i++) {
	            if (accountList.get(i).getId().equalsIgnoreCase(id)== true &&
	            		accountList.get(i).getAccountPassword().equals(passwordAccount.getText())==true) {
	                isExisted = true;
	                idLecturer=id;
	                nameLecturer= accountList.get(i).getName();
	                dispose();
	                LecturerManagement l= new LecturerManagement();
	                l.setVisible(true);
	                
	                break;
	               
	            }
	        }
	        if(isExisted==false) {
	        	
	        	JOptionPane.showMessageDialog(null, "this id "+id+" or password is not correct!");
	        	
	        }
		}catch(NullPointerException e) {
        	
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
