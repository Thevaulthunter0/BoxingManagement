package PkgGestion;

/**
 * Classe for the trainer of the gym, will keep track of name, seniority, hours worked and the salary. 
 * @author Mathieu
 *
 */

public class trainer {
	private int id;
	private String strName;
	private int iSeniority;
	private int iHours;
	private int iSalary;
	
	//Constructor for the trainer//
	public trainer(int id,String strName, int iSeniority, int iHours){
		this.id = id;
		this.strName = strName;
		this.iSeniority = iSeniority;
		this.iHours = iHours;
		//Calculation of the salary based on the seniority and hours for the week
		if(iSeniority <= 2) {
			iSalary=iHours * 2; 
		}
		else if(iSeniority >= 3) {
			iSalary=iHours * 4;
		}
	}
	
	//setter and getter/
		//set the seniority of the trainer
	public void setSeniority(int iNewSeniority) {
		iSeniority=iNewSeniority;
	}
		//set the hours of work of the trainer
	public void setHours(int iNewHours) {
		iHours=iNewHours;
	}
		//get the id
	public int getId() {
		return id;
	}
		//set the name
	public void setName(String StrName) {
		this.strName = StrName;
	}
	
		//get the name
	public String getName() {
		return strName;
	}
		//get the seniority
	public int getSeniority() {
		return iSeniority;
	}
		//get the hours
	public int getHours() {
		return iHours;
	}
		//get salary of the trainer
	public int getSalary() {
		return iSalary;
	}
	
}
