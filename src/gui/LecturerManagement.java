package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import dao.SubjectDao;
import dao.SubjectOfStudentDao;
import subject.Subject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LecturerManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textIDSubject;
	private JTextField textNameSubject;
	private List<Subject> subjectList;
	private SubjectDao subjectDao;
	private List<Subject> subjectOfStudentList;
	private SubjectOfStudentDao subjectOfStudentDao;
	private JComboBox comboBoxSelectionSubject;
	private JComboBox comboBoxToTimeSubject;
	private JComboBox comboBoxFromTimeSubject;
	private JComboBox comboBoxDateSubject;
	private ListSelectionModel select;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerManagement frame = new LecturerManagement();
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
	public LecturerManagement() {
		subjectDao = new SubjectDao();
	    subjectList = subjectDao.read();
	    
	    subjectOfStudentDao = new SubjectOfStudentDao();
	    subjectOfStudentList = subjectOfStudentDao.read();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLecturerManagement = new JLabel("Lecturer Management");
		lblLecturerManagement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLecturerManagement.setBounds(256, 0, 303, 43);
		contentPane.add(lblLecturerManagement);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setBounds(458, 64, 604, 404);
		contentPane.add(table);
		changeDataTable();
		
		JScrollPane scrollPane =new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(458, 64, 604, 404);
		contentPane.add(scrollPane);
		
		comboBoxSelectionSubject = new JComboBox();
		comboBoxSelectionSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxSelectionSubject.setBounds(20, 64, 333, 33);
		contentPane.add(comboBoxSelectionSubject);
		comboBoxSelectionSubject();
		
		JButton btnAddSubject = new JButton("Add Subject");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnAddSubject)) {
					addSubject();
				}
			}
		});
		btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddSubject.setBounds(10, 366, 184, 43);
		contentPane.add(btnAddSubject);
		
		JButton btnDeleteSubject = new JButton("Delete Subject");
		btnDeleteSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnDeleteSubject)) {
					setDeleteSubjectBotton();
				}
			}
		});
		btnDeleteSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeleteSubject.setBounds(225, 366, 174, 42);
		contentPane.add(btnDeleteSubject);
		
		
		JLabel lblIdSubject = new JLabel("ID Subject:");
		lblIdSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdSubject.setBounds(22, 126, 119, 33);
		contentPane.add(lblIdSubject);
		
		JLabel lblNameSubject = new JLabel("Name Subject:");
		lblNameSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameSubject.setBounds(10, 180, 137, 33);
		contentPane.add(lblNameSubject);
		
		textIDSubject = new JTextField();
		textIDSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textIDSubject.setBounds(161, 126, 276, 33);
		contentPane.add(textIDSubject);
		textIDSubject.setColumns(10);
		
		textNameSubject = new JTextField();
		textNameSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNameSubject.setBounds(161, 176, 276, 33);
		contentPane.add(textNameSubject);
		textNameSubject.setColumns(10);
		
		JLabel lblSetTime = new JLabel("Set time:");
		lblSetTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSetTime.setBounds(10, 238, 87, 24);
		contentPane.add(lblSetTime);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDate.setBounds(107, 245, 45, 13);
		contentPane.add(lblDate);
		
		comboBoxDateSubject = new JComboBox();
		comboBoxDateSubject.setModel(new DefaultComboBoxModel(new String[] {"None", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		comboBoxDateSubject.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxDateSubject.setBounds(161, 238, 238, 24);
		contentPane.add(comboBoxDateSubject);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFrom.setBounds(107, 276, 55, 28);
		contentPane.add(lblFrom);
		
		comboBoxFromTimeSubject = new JComboBox();
		comboBoxFromTimeSubject.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxFromTimeSubject.setModel(new DefaultComboBoxModel(new String[] {"1: 8h00-8h45", "2: 8h50-9h35", "3: 9h40-10h25", "4: 10h35-11h20", "5: 11h25-12h10", "6: 12h15-13h00", "7: 13h15-14h00", "8: 14h05-14h50", "9: 14h55-15h40", "10: 15h50-16h35", "11: 16h40-17h25", "12: 17h30-18h15"}));
		comboBoxFromTimeSubject.setBounds(161, 278, 238, 24);
		contentPane.add(comboBoxFromTimeSubject);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTo.setBounds(107, 318, 33, 16);
		contentPane.add(lblTo);
		
		comboBoxToTimeSubject = new JComboBox();
		comboBoxToTimeSubject.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxToTimeSubject.setModel(new DefaultComboBoxModel(new String[] {"1: 8h00-8h45", "2: 8h50-9h35", "3: 9h40-10h25", "4: 10h35-11h20", "5: 11h25-12h10", "6: 12h15-13h00", "7: 13h15-14h00", "8: 14h05-14h50", "9: 14h55-15h40", "10: 15h50-16h35", "11: 16h40-17h25", "12: 17h30-18h15"}));
		comboBoxToTimeSubject.setBounds(161, 316, 238, 21);
		contentPane.add(comboBoxToTimeSubject);
		
		JButton btnFindSubject = new JButton("Find");
		btnFindSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnFindSubject)) {
					setFindBotton();
				}
			}
		});
		btnFindSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFindSubject.setBounds(363, 64, 85, 33);
		contentPane.add(btnFindSubject);
	}
	
	public void addSubject() {
		try {
			String id= textIDSubject.getText();
	        boolean isExisted = false;
	        int size = subjectList.size();
	        for (int i = 0; i < size; i++) {
	            if (subjectList.get(i).getIdSubject().equalsIgnoreCase(id)== true) {
	                isExisted = true;
	                JOptionPane.showMessageDialog(null, "this id "+id+" has been existed!");
	                
	                break;
	               
	            }
	        }
	        if(isExisted==false) {

	        	String nameSubject = textNameSubject.getText();
	        	String dateTeaching=(String) comboBoxDateSubject.getSelectedItem();
	        	String timeBeginTeaching=(String) comboBoxFromTimeSubject.getSelectedItem();
	        	String timeEndTeaching=(String) comboBoxToTimeSubject.getSelectedItem();
	        	String timeTeaching= "From: "+timeBeginTeaching+
	        			"To: "+timeEndTeaching;
	        	Subject subject= new Subject();
		        subject.setIdSubject(id);
		        subject.setNameSubject(nameSubject);
		        subject.setIdLecturer(LecturerLoginGUI.idLecturer);
		        subject.setNameLecturer(LecturerLoginGUI.nameLecturer);
		        subject.setDateTeaching(dateTeaching);
		        subject.setTimeTeaching(timeTeaching);
		        subject.setTimeBeginTeaching(timeBeginTeaching);
		        subject.setTimeEndTeaching(timeEndTeaching);
		        String idNameSubject=id+"-"+nameSubject;
		        comboBoxSelectionSubject.addItem(idNameSubject.toUpperCase());
		        subjectList.add(subject);
		        subjectDao.write(subjectList);
		        
		        //delete the data was filled in the blank
		       
		       textIDSubject.setText(null);
		       textNameSubject.setText(null);
		       
	        }
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Please, filling on information into the blank");
		}
	}
	
	public void comboBoxSelectionSubject() {
		String[] arrSubject=new String[subjectList.size()];
		int countSubject=0;
		for(int i=0; i<subjectList.size();i++ ) {
			String idLecturer = LecturerLoginGUI.idLecturer;
			if(subjectList.get(i).getIdLecturer().equals(idLecturer)==true) {
				arrSubject[i]=subjectList.get(i).getIdSubject()+"-"+ subjectList.get(i).getNameSubject();
				
			}
			if(arrSubject[i]!=null) {
				countSubject=countSubject +1;
			}
		}
		String[] arr= new String[countSubject];
		for(int i=0;i<subjectList.size();i++) {
			if(arrSubject!=null) {
				for(int j=0;j<arr.length;j++) {
					if(arr[j]==null) {
						arr[j]=arrSubject[i];
						break;
					}
				}
			}
		}
		comboBoxSelectionSubject.setModel( new DefaultComboBoxModel(arr));
		System.out.println("ghgfhfghgf");
	}
	public void setTableModel() {
		table.setModel(new AbstractTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] columnName= {"ID", "Name","Processing","Midterm", "Final","Total"};
			Object[][] rowData= new Object[countStudent()][6];
			
			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		        Subject subject =null;
		        String idSelection= (String) comboBoxSelectionSubject.getSelectedItem();
		        for(int i=0;i<subjectOfStudentList.size();i++) {
		        	for(int j=0; j<countStudent();j++) {
		        		subject=subjectOfStudentList.get(i);
		        		if(table.getValueAt(j, 0).toString().equalsIgnoreCase(subject.getIdStudent())&&
		        				idSelection.equalsIgnoreCase(subjectOfStudentList.get(i).getIdSubject()+"-"+subjectOfStudentList.get(i).getNameSubject())&&
		        				subject.getIdLecturer().equalsIgnoreCase(LecturerLoginGUI.idLecturer)) {
		        			
		        			if(columnIndex==2 && table.isCellSelected(j, 2)==true) {
		    					subject.setProccessGrade(Float.parseFloat(aValue.toString()));
		    					subjectOfStudentDao.write(subjectOfStudentList);
		    					
		    				}
		    				
		    				if(columnIndex==3 && table.isCellSelected(j, 3)==true) {
		    					subject.setMidtermGrade(Float.parseFloat(aValue.toString()));
		    					subjectOfStudentDao.write(subjectOfStudentList);
		    					
		    					
		    				}
		    				if(columnIndex==4 && table.isCellSelected(j, 4)==true) {
		    					subject.setFinalGrade(Float.parseFloat(aValue.toString()));
		    					subjectOfStudentDao.write(subjectOfStudentList);
		    					
		    				}
		        		}
		        	}
		        }
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
					for(int i=0; i<subjectOfStudentList.size();i++) {
						if(subjectOfStudentList.get(i).getIdLecturer().equalsIgnoreCase(LecturerLoginGUI.idLecturer)&&
								subjectOfStudentList.get(i).getIdSubject().equalsIgnoreCase(textIDSubject.getText())) {
							for(int j=0; j<countStudent();j++) {
								if(rowData[j][0]==null) {
									rowData[j][0]= subjectOfStudentList.get(i).getIdStudent();
									rowData[j][1]= subjectOfStudentList.get(i).getNameStudent();
									rowData[j][2]= subjectOfStudentList.get(i).getProccessGrade();
									rowData[j][3]= subjectOfStudentList.get(i).getMidtermGrade();
									rowData[j][4]= subjectOfStudentList.get(i).getFinalGrade();
									rowData[j][5]= (subjectOfStudentList.get(i).getProccessGrade()
											+subjectOfStudentList.get(i).getMidtermGrade()
											+subjectOfStudentList.get(i).getFinalGrade())/3;
									break;
								}
								
							}
						}			
					}
				return rowData[rowIndex][columnIndex];
			}
			
			@Override
			public int getRowCount() {
				
				return rowData.length;
			}
			
			@Override
			public String getColumnName(int column) {
				return columnName[column].toString();
			}
			
			@Override
			public int getColumnCount() {
				return columnName.length;
			}
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				if(columnIndex==2|| columnIndex==3||columnIndex==4) {
					return true;
				}	
				return false;
			}
		});	
	}
	public int countStudent() {
		int countSubject=0;
		for(int i=0; i<subjectOfStudentList.size();i++) {
			if(subjectOfStudentList.get(i).getIdLecturer().equalsIgnoreCase(LecturerLoginGUI.idLecturer)&&
					subjectOfStudentList.get(i).getIdSubject().equalsIgnoreCase(textIDSubject.getText())) {
				countSubject++;
				
			}
		}
		return countSubject;
	}
	public void setFindBotton() {
		Subject subject = null;
		String idSelection= (String) comboBoxSelectionSubject.getSelectedItem();
        int size = subjectList.size();
        for (int i = 0; i < size; i++) {
            if (idSelection.equalsIgnoreCase(subjectList.get(i).getIdSubject()+"-"+subjectList.get(i).getNameSubject())) {
                subject = subjectList.get(i);
                textIDSubject.setText(subject.getIdSubject());
                textNameSubject.setText(subject.getNameSubject());
                comboBoxDateSubject.setSelectedItem(subject.getDateTeaching());
                comboBoxFromTimeSubject.setSelectedItem(subject.getTimeBeginTeaching());
                comboBoxToTimeSubject.setSelectedItem(subject.getTimeEndTeaching());
                
                break;
            }
        }
        if (subject == null) {
        	JOptionPane.showMessageDialog(null, "the id is not exist");
        } 
        setTableModel();
	}
	
	public void setDeleteSubjectBotton() {
		Subject subject = null;
		String idSelection= (String) comboBoxSelectionSubject.getSelectedItem();
        int size = subjectList.size();
        for (int i = 0; i < size; i++) {
            if (idSelection.equalsIgnoreCase(subjectList.get(i).getIdSubject()+"-"+subjectList.get(i).getNameSubject())) {
                subject = subjectList.get(i);
                subjectList.remove(subject);
                subjectDao.write(subjectList);
                comboBoxSelectionSubject();
                break;
            }
        }
        if (subject == null) {
        	JOptionPane.showMessageDialog(null, "the id is not exist");
        } 
	}
	public void changeDataTable() {
		select= table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String data=null;
				int[] row= table.getSelectedRows();
				int[] column= table.getSelectedColumns();
				
				for(int i=0; i<row.length;i++) {
					for(int j=0;j<column.length;j++) {
						//data=(String) table.getValueAt(row[i], column[j]);
						if(table.isCellSelected(row[i], column[j])==true) {
							table.isCellEditable(row[i], column[j]);
							table.editCellAt(row[i], column[j]);
						}
					
						//table.setValueAt(aValue, row[i], column[j]);
					}
				}
				System.out.println(data);;
			}
		});
	}
}
