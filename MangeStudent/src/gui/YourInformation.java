package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import dao.StudentDao;
import dao.SubjectDao;
import dao.SubjectOfStudentDao;
import objects.Student;
import dao.SubjectDao;
import subject.Subject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class YourInformation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<Subject> subjectList;
	private SubjectDao subjectDao;
	private List<Subject> subjectOfStudentList;
	private SubjectOfStudentDao subjectOfStudentDao;
	private JComboBox comboBoxAddSubject;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourInformation frame = new YourInformation();
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
	public YourInformation() {
		subjectDao = new SubjectDao();
	    subjectList = subjectDao.read();
	    
	    subjectOfStudentDao = new SubjectOfStudentDao();
	    subjectOfStudentList = subjectOfStudentDao.read(); 
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourInformation = new JLabel("Your Information");
		lblYourInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblYourInformation.setBounds(327, 10, 236, 25);
		contentPane.add(lblYourInformation);
		
		JButton btnUpdateInfomation = new JButton("Update Infomation");
		btnUpdateInfomation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnUpdateInfomation)) {
					updateInformation();
				}
			}
		});
		btnUpdateInfomation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdateInfomation.setBounds(10, 400, 242, 33);
		contentPane.add(btnUpdateInfomation);
		
		JButton btnAddSubject = new JButton("Add Subject");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnAddSubject)) {
					addSubject();
					setTableModel();
				}
			}
		});
		btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddSubject.setBounds(706, 72, 159, 31);
		contentPane.add(btnAddSubject);
		
		table = new JTable();
		table.setBounds(293, 143, 524, 290);
		contentPane.add(table);
		setTableModel();
		
		JScrollPane scrollPane =new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(293, 143, 524, 290);
		contentPane.add(scrollPane);
		
		JButton btnSentMessage = new JButton("Send Message");
		btnSentMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSentMessage.setBounds(10, 355, 242, 21);
		contentPane.add(btnSentMessage);
		
		JTextPane txtpnTextMessage = new JTextPane();
		txtpnTextMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnTextMessage.setToolTipText("text here to send a message");
		txtpnTextMessage.setBounds(10, 204, 242, 138);
		contentPane.add(txtpnTextMessage);
		
		JLabel lblTextHereTo = new JLabel("Text here to sent a message");
		lblTextHereTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTextHereTo.setBounds(10, 187, 172, 15);
		contentPane.add(lblTextHereTo);
		
		comboBoxAddSubject = new JComboBox();
		comboBoxAddSubject.setBounds(33, 72, 663, 31);
		contentPane.add(comboBoxAddSubject);
		setComboBoxSelection();
	}
	public void addSubject() {
		Subject subject=null;
		String strSubject= comboBoxAddSubject.getSelectedItem().toString();
		System.out.println(comboBoxAddSubject.getSelectedItem().toString());
		String idSubject=null;
		String nameSubject=null;
    	String nameLecturer=null;
    	String dateTeaching=null;
    	String timeBeginTeaching=null;
    	String timeEndTeaching=null;
    	String timeTeaching=null;
    	String idLecturer=null;
    	String idStudent=StudentLogin.idLogin;
    	String nameStudent=StudentLogin.nameLogin;
    	float proccessGrade=0;
    	float midtermGrade=0;
    	float finalGrade=0;
		for(int i=0; i<subjectList.size();i++) {
			subject= subjectList.get(i);
			if(strSubject.contains(subject.getDateTeaching()) &&
					strSubject.contains(subject.getIdSubject())&&
					strSubject.contains(subject.getNameLecturer())&&
					strSubject.contains(subject.getNameSubject())&&
					strSubject.contains(subject.getTimeBeginTeaching())&&
					strSubject.contains(subject.getTimeEndTeaching())) {
				
				idSubject=subject.getIdSubject();
				nameSubject=subject.getNameSubject();
				nameLecturer=subject.getNameLecturer();
				dateTeaching=subject.getDateTeaching();
				timeBeginTeaching=subject.getTimeBeginTeaching();
		    	timeEndTeaching=subject.getTimeEndTeaching();
		    	timeTeaching=subject.getTimeTeaching();
		    	idLecturer=subject.getIdLecturer();
//		    	idStudent=null;
//		    	nameStudent=null;
		    	proccessGrade=subject.getProccessGrade();
		    	midtermGrade=subject.getMidtermGrade();
		    	finalGrade=subject.getFinalGrade();
		    	System.out.println(idSubject);
		    	System.out.println(nameSubject);
		    	System.out.println(nameLecturer);
		    	break;			
			}
		}
			
        boolean isExisted = false;
        int size = subjectOfStudentList.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
        	System.out.println("hoooo");
            if (subjectOfStudentList.get(i).getIdSubject().equalsIgnoreCase(idSubject)&&
            		subjectOfStudentList.get(i).getIdStudent().equalsIgnoreCase(StudentLogin.idLogin)) {
                isExisted = true;
                JOptionPane.showMessageDialog(null, "this subject "+idSubject+" has been existed!");
                
                break;
               
            }
        }
        if(isExisted==false) {
        	System.out.println("start");
        	Subject addSubject = new Subject();
        	
			addSubject.setDateTeaching(dateTeaching);
			addSubject.setFinalGrade(finalGrade);
			addSubject.setIdStudent(idStudent);
        	addSubject.setIdSubject(idSubject);
        	addSubject.setIdLecturer(idLecturer);
			addSubject.setMidtermGrade(midtermGrade);
			addSubject.setNameLecturer(nameLecturer);
			addSubject.setNameStudent(nameStudent);
        	addSubject.setNameSubject(nameSubject);
        	addSubject.setProccessGrade(proccessGrade);
        	addSubject.setTimeBeginTeaching(timeBeginTeaching);
        	addSubject.setTimeEndTeaching(timeEndTeaching);
        	addSubject.setTimeTeaching(timeTeaching);
        	subjectOfStudentList.add(addSubject);
        	subjectOfStudentDao.write(subjectOfStudentList);
        	System.out.println("add finished");
        }
        
	}
	
	public void updateInformation() {
		UpdateYourInformation u= new UpdateYourInformation();
		u.showInformation(StudentLogin.idLogin);
		u.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		u.setVisible(true);
	}
	public void setComboBoxSelection() {
		Subject subject=null;
		String[] arrSubject=new String[subjectList.size()];
		comboBoxAddSubject.setModel( new DefaultComboBoxModel(arrSubject));
		comboBoxAddSubject.removeAllItems();
		for(int i=0; i<subjectList.size();i++ ) {
				subject=subjectList.get(i);
				arrSubject[i]=subject.getIdSubject()+"-"+ subject.getNameSubject()
				+"-"+subject.getDateTeaching()+"-"+subject.getTimeTeaching()+"-"+subject.getNameLecturer();				
					comboBoxAddSubject.addItem(arrSubject[i]);
		}
		
	}
	public void setTableModel() {
		table.setModel(new AbstractTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] columnName= {"ID Subject", "Subject","Lecturer","Processing","Midterm", "Final","Total"};
			Object[][] rawData= new Object[countSubject()][7];
		
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
					//System.out.println(countSubject);
					for(int i=0; i<subjectOfStudentList.size();i++) {
						if(subjectOfStudentList.get(i).getIdStudent().equalsIgnoreCase(StudentLogin.idLogin)) {
							for(int j=0; j<countSubject();j++) {
								if(rawData[j][0]==null) {
									rawData[j][0]= subjectOfStudentList.get(i).getIdSubject();
									rawData[j][1]= subjectOfStudentList.get(i).getNameSubject();
									rawData[j][2]= subjectOfStudentList.get(i).getNameLecturer();
									rawData[j][3]= subjectOfStudentList.get(i).getProccessGrade();
									rawData[j][4]= subjectOfStudentList.get(i).getMidtermGrade();
									rawData[j][5]= subjectOfStudentList.get(i).getFinalGrade();
									rawData[j][6]= (subjectOfStudentList.get(i).getProccessGrade()
											+subjectOfStudentList.get(i).getMidtermGrade()
											+subjectOfStudentList.get(i).getFinalGrade())/3;
									break;
								}
								
							}
						}			
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
	public int countSubject() {
		int countSubject=0;
		for(int i=0; i<subjectOfStudentList.size();i++) {
			if(subjectOfStudentList.get(i).getIdStudent().equalsIgnoreCase(StudentLogin.idLogin)) {
				countSubject++;
				
			}
		}
		return countSubject;
	}
}
