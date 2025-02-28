package queue;

import java.util.LinkedList;
import java.util.Queue;

public class patienthealth {
    private String name;
    private int age;
    private String gender;
    private int heartrate;
    private int glucoselevel;
    private String symptoms;
    
	public patienthealth(String name, int age, String gender, int heartrate, int glucoselevel, String symptoms) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.heartrate = heartrate;
		this.glucoselevel = glucoselevel;
		this.symptoms = symptoms;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
	}
	public int getGlucoselevel() {
		return glucoselevel;
	}
	public void setGlucoselevel(int glucoselevel) {
		this.glucoselevel = glucoselevel;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	@Override
	public String toString() {
		return "patienthealth [name=" + name + ", age=" + age + ", gender=" + gender + ", heartrate=" + heartrate
				+ ", glucoselevel=" + glucoselevel + ", symptoms=" + symptoms + "]";
	}
	public static void main(String[] args) {
		Patientmonitor p=new Patientmonitor ();
		p.addPatient(new patienthealth("guna",22,"female",70, 80, "fever"));
		p.addPatient(new patienthealth("manasa",21,"female",72,78,"normal"));
		p.addPatient(new patienthealth("surya",22,"male",77,82,"fever"));
		p.addPatient(new patienthealth("vinay",21,"male",79,84,"Dengue"));
		p.addPatient(new patienthealth("keerthi",99,"female",97,110,"cold"));
		
		System.out.println("__________");
		
		p.visitingpatient();
	}
}
	
  class Patientmonitor{
	  private Queue<patienthealth> queue=new LinkedList<patienthealth>();
	  final int assignPatient=5;
	  
	  
	  public void addPatient(patienthealth patient) {
		 if(queue.size()<assignPatient) {
			 queue.add(patient);
			 System.out.println(patient.toString());
		 }else {
			 System.out.println("no slots available");
		 }
	  }
	  
	  
	  public void visitingpatient() {
		  while(!queue.isEmpty()) {
			  patienthealth patient=queue.poll();
			  
			  System.out.println("name:"+patient.getName());
			  System.out.println("age:"+patient.getAge());
			  System.out.println("gender:"+patient.getGender());
			  System.out.println("heartrate:"+analyzeheartrate(patient.getHeartrate()));
			  System.out.println("glucoselevel:"+analyzeglucoselevel(patient.getGlucoselevel()));
			  System.out.println("symptoms:"+patient.getSymptoms());
			  System.out.println("____");
		  }
		  System.out.println("all patient completed the visits");
	  }
	  public String analyzeheartrate(int heartrate) {
		  if(heartrate<60 || heartrate>100){
		  return "alert: abnormal heart rate";
	  }
		  else {
			  return "normal heart rate";
		  }
	  }
	  public String analyzeglucoselevel(int glucoserate) {
		  if(glucoserate<70 || glucoserate>100) {
			  return "alert:abnormal glucoselevel";
		  }else {
			  return "normal glucose level";
		  }	  
	  }
  }
 
