package PkgGestion;

/*
 * Class for the boxer of the gym, keep track of name, level of boxing, fee payed
 * and total fee.
 */

public class boxer {
	private int id;
	private String strName;
	private String strLevel;
	private int iFeeTotal;
	private int iFeePayed;
	
	//Constructor to create a new boxer object by initializing the values//
	public boxer(int id, String strName, String strLevel) {
		//Calculation of the fee total based on the level of the boxer
		if(strLevel == "Begginer" || strLevel == "Intermediate") {
		iFeeTotal = 100;
		}
		else if(strLevel == "Professional") {
		iFeeTotal = 200;
		}
		iFeePayed = iFeeTotal/2;
		this.id = id;
		this.strName = strName;
		this.strLevel = strLevel;
	}
	
	//setter and getter//
		//set the level of the boxer//
	public void setLevel(String strNewLevel) {
		strLevel = strNewLevel;
	}
		//set the name of the boxer//
	public void setName(String strNewName) {
		strName = strNewName;
	}
		//update the fee that the boxer as payed//
	public void setFee(int iFee) {
		iFeePayed =+ iFee;
	}
		//get the id
	public int getId() {
		return id;
	}
		//get the name
	public String getName() {
		return strName;
	}
		//get the level
	public String getLevel() {
		return strLevel;
	}
		//get the feePayed
	public int getFeePayed() {
		return iFeePayed;
	}
		//get the feeTotal
	public int getFeeTotal() {
		return iFeeTotal;
	}
	
	
	
	
}
