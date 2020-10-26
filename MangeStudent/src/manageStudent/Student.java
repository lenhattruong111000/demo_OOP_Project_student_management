package manageStudent;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student implements Serializable {
    private String id;
    private String name;
    private String strBirthDate;
    private Date birthDate;
    private int age;
    private String sex;
    private String address;
    private float gpa;
 
    public Student() {
    }
 
    public Student(String id, String name, String strBirthDate,
    		 String sex, String address, float gpa) {
        super();
        this.id = id;
        this.name = name;
        this.strBirthDate= strBirthDate;
        this.sex = sex;
        this.address = address;
        this.gpa = gpa;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        id= id.toUpperCase();
    	this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
    	// capital first character of each letter
    	String a= name;
		String[] b =new String[a.length()];
		String namef="";
		for(int i=1; i<=a.length()-1;i++) {
			b[0]=String.valueOf(a.charAt(0)).toUpperCase();
			
			
			if(a.charAt(i)==' ' && a.charAt(i+1)!=' ') {
				b[i]=String.valueOf(a.charAt(i)).toLowerCase();
				b[i+1]=String.valueOf(a.charAt(i+1)).toUpperCase();
				i++;
			}else {
				b[i]=String.valueOf(a.charAt(i)).toLowerCase();
			}	
		}
		for(int i=0; i<=a.length()-1;i++) {
			namef= namef+b[i];
		}
		this.name = namef;
    }
    
    public String getBirthDate() {
		SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		String birthDateFormat= df.format(birthDate);
    	return birthDateFormat;
	}

	public void setBirthDate(String strBirthDate) {
		try {
			birthDate = new SimpleDateFormat("ddMMyyyy").parse(strBirthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal= Calendar.getInstance();
		Calendar birthDay= new GregorianCalendar();
		birthDay.setTime(birthDate);
		cal.set(birthDay.get(Calendar.YEAR), birthDay.get(Calendar.MONTH), birthDay.get(Calendar.DATE));
		this.birthDate = cal.getTime();
	}

	public int getAge() {
        return age;
    }
 
    public void setAge() {
    	Calendar today = Calendar.getInstance();
		Calendar birthDay= new GregorianCalendar();
		birthDay.setTime(birthDate);
		age = today.get(Calendar.YEAR)- birthDay.get(Calendar.YEAR);
    }
    
    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		if (sex.equalsIgnoreCase("1")) {
			sex="Male";
		}else if (sex.equalsIgnoreCase("0")) {
			sex="Female";
		}else  {
			sex= "Unknown";
		}
		this.sex = sex;
	}

	public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
    	String a= address;
		String[] b =new String[a.length()];
		String addressf="";
		for(int i=1; i<=a.length()-1;i++) {
			b[0]=String.valueOf(a.charAt(0)).toUpperCase();
			
			
			if(a.charAt(i)==' ' && a.charAt(i+1)!=' ') {
				b[i]=String.valueOf(a.charAt(i)).toLowerCase();
				b[i+1]=String.valueOf(a.charAt(i+1)).toUpperCase();
				i++;
			}else {
				b[i]=String.valueOf(a.charAt(i)).toLowerCase();
			}	
		}
		for(int i=0; i<=a.length()-1;i++) {
			addressf= addressf+b[i];
		}
    	this.address = addressf;
    }
 
    public float getGpa() {
        return gpa;
    }
 
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}