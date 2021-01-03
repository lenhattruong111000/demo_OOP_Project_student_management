package subject;

public class MySubject<S,G1,G2,G3> {
	private S subjectName;
	private G1 processGrade;
	private G2 midtermGrade;
	private G3 finalGrade;
	public MySubject(S subjectName, G1 processGrade, G2 midtermGrade, G3 finalGrade ) {
		this.subjectName= subjectName;
		this.processGrade= processGrade;
		this.midtermGrade= midtermGrade;
		this.finalGrade= finalGrade;
	}
	public S getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(S subjectName) {
		this.subjectName = subjectName;
	}
	public G1 getProcessGrade() {
		return processGrade;
	}
	public void setProcessGrade(G1 processGrade) {
		this.processGrade = processGrade;
	}
	public G2 getMidtermGrade() {
		return midtermGrade;
	}
	public void setMidtermGrade(G2 midtermGrade) {
		this.midtermGrade = midtermGrade;
	}
	public G3 getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(G3 finalGrade) {
		this.finalGrade = finalGrade;
	}
	
}
