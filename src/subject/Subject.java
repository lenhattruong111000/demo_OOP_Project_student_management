package subject;

import java.io.Serializable;

public class Subject implements Serializable {
	private String idSubject;
	private String nameSubject;
	private String idLecturer;
	private String nameLecturer;
	private float midtermGrade;
	private float finalGrade;
	private float proccessGrade;
	private String dateTeaching;
	private String timeTeaching;
	private String timeBeginTeaching;
	private String timeEndTeaching;
	private String idStudent;
	private String nameStudent;
	public Subject() {
		
	} 
	
	public Subject(String idSubject, String nameSubject,String nameLecturer,
			float midtermGrade, float finalGrade, float proccessGrade) {
		this.idSubject		= idSubject;
		this.nameLecturer	= nameLecturer;
		this.nameSubject	= nameSubject;
		this.finalGrade		= finalGrade;
		this.midtermGrade	= midtermGrade;
		this.proccessGrade	= proccessGrade;
		
	}
	
	
	public String getIdLecturer() {
		return idLecturer;
	}

	public void setIdLecturer(String idLecturer) {
		this.idLecturer = idLecturer;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getTimeBeginTeaching() {
		return timeBeginTeaching;
	}

	public void setTimeBeginTeaching(String timeBeginTeaching) {
		this.timeBeginTeaching = timeBeginTeaching;
	}

	public String getTimeEndTeaching() {
		return timeEndTeaching;
	}

	public void setTimeEndTeaching(String timeEndTeaching) {
		this.timeEndTeaching = timeEndTeaching;
	}

	public String getDateTeaching() {
		return dateTeaching;
	}

	public void setDateTeaching(String dateTeaching) {
		this.dateTeaching = dateTeaching;
	}

	public String getTimeTeaching() {
		return timeTeaching;
	}

	public void setTimeTeaching(String timeTeaching) {
		this.timeTeaching = timeTeaching;
	}

	public String getIdSubject() {
		return idSubject;
	}


	public void setIdSubject(String idSubject) {
		this.idSubject = idSubject.toUpperCase();
	}


	public String getNameSubject() {
		return nameSubject;
	}


	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject.toUpperCase();
	}


	public String getNameLecturer() {
		return nameLecturer;
	}


	public void setNameLecturer(String nameLecturer) {
		this.nameLecturer = nameLecturer;
	}


	public float getMidtermGrade() {
		return midtermGrade;
	}


	public void setMidtermGrade(float midtermGrade) {
		this.midtermGrade = midtermGrade;
	}


	public float getFinalGrade() {
		return finalGrade;
	}


	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}


	public float getProccessGrade() {
		return proccessGrade;
	}


	public void setProccessGrade(float proccessGrade) {
		this.proccessGrade = proccessGrade;
	}
	
}
