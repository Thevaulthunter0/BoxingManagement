package PkgGestion;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Class for the creation of a gym object
 * @author Math
 *
 */
public class Gym {
	private List<trainer> listTrainers;
	private int iSalary;
	private List<boxer> listBoxers;
	private int iFees;
	private int iCost;
	private int iTotal;
	
	//Constructor of the gym object
	public Gym(List<trainer> trainers, List<boxer> boxers) {
	this.listTrainers = trainers;
	this.listBoxers = boxers;
	this.iCost = 200;
	this.iFees = 0;
	this.iSalary = 0;
	}
	
	//Setter and getter//
		//get the list of trainers
	public  List<trainer> getTrainers() {
		return listTrainers;
	}
		//add a trainers to the list
	public void addTrainers(trainer trainer){
		listTrainers.add(trainer);
	}
		//get the list of boxers
	public List<boxer> getBoxers() {
		return listBoxers;
	}
	
		//display the list of boxers
	public void getDisplayBoxers(Object Rows[][], List<boxer> boxers, Gym gym, JTable Table) {
		int iCtr=0;
		for(iCtr = 0; iCtr < boxers.size(); iCtr++) {
			Rows[iCtr][0] = gym.getBoxers().get(iCtr).getId();
			Rows[iCtr][1] = gym.getBoxers().get(iCtr).getName();
			Rows[iCtr][2] = gym.getBoxers().get(iCtr).getLevel();
			Rows[iCtr][3] = gym.getBoxers().get(iCtr).getFeePayed();
			Rows[iCtr][4] = gym.getBoxers().get(iCtr).getFeeTotal();
		}
		JOptionPane.showMessageDialog(null, new JScrollPane(Table));
		for(iCtr = 0;iCtr < boxers.size(); iCtr++) {
			Rows[iCtr][0] = null;
			Rows[iCtr][1] = null;
			Rows[iCtr][2] = null;
			Rows[iCtr][3] = null;
			Rows[iCtr][4] = null;
		}
	}
	
		//display the list of trainer
	public void getDisplayTrainers(Object Rows[][], List<trainer> trainers, Gym gym, JTable Table) {
		int iCtr=0;
		for(iCtr = 0; iCtr < trainers.size(); iCtr++) {
			Rows[iCtr][0] = gym.getTrainers().get(iCtr).getId();
			Rows[iCtr][1] = gym.getTrainers().get(iCtr).getName();
			Rows[iCtr][2] = gym.getTrainers().get(iCtr).getSeniority();
			Rows[iCtr][3] = gym.getTrainers().get(iCtr).getHours();
			Rows[iCtr][4] = gym.getTrainers().get(iCtr).getSalary();
		}
		JOptionPane.showMessageDialog(null, new JScrollPane(Table) );
		for(iCtr = 0;iCtr < trainers.size(); iCtr++) {
			Rows[iCtr][0] = null;
			Rows[iCtr][1] = null;
			Rows[iCtr][2] = null;
			Rows[iCtr][3] = null;
			Rows[iCtr][4] = null;
		}
	}
		//get the size of the list of boxers
	public int getSizeListBoxer() {
		return listBoxers.size();
	}
		
		//get the size of the list of trainers
	public int getSizeListTrainer() {
		return listTrainers.size();
	}
	
		//add a boxer to the list
	public void addBoxer(boxer boxer) {
		listBoxers.add(boxer);
	}
	
		//delete a boxer from the list
	public void deleteBoxer(int id) {
		listBoxers.remove(id);
	}
	
		//delete a trainer from the list
	public void deleteTrainer(int id) {
		listTrainers.remove(id);
	}
	
		//get the total salary
	public int getSalary(List<trainer> trainers) {
		//Calculation of the salary based on addition of all the salary for the week.
		iSalary = 0;
		for (int iCtr=0; iCtr < trainers.size(); iCtr++) {
		iSalary += trainers.get(iCtr).getSalary();
		}
		return iSalary;
	}

		//get the total fees
	public int getFees(List<boxer> boxers) {
			//Calculation of the fees based on addition of all the fees payed until this point.
			iFees = 0;
		for (int iCtr=0; iCtr < boxers.size(); iCtr++) {
			iFees += boxers.get(iCtr).getFeePayed();
	}
		return iFees;
	}
	
		//get the total 
	public int getTotal() {
		//Calculation of the total of money at one point 
		iTotal = iFees - (iSalary + iCost);
		return iTotal;
	}	
	
		//get the cost
	public int getCost() {
		return iCost;
	}
	
		//set the cost
	public void setCost(int iTotalCost) {
		iCost = iTotalCost;
	}
	
		//set the baseGym
	public void setTr(List<trainer> trainers, List<boxer> boxers) {
		this.listTrainers = trainers;
		trainer Lydia = new trainer(1,"Lydia", 1, 35);
		trainer Bob = new trainer(2,"Bob", 5, 40);
		trainer Floyd = new trainer(3,"Floyd", 20, 40);
		trainers.add(Lydia);
		trainers.add(Bob);
		trainers.add(Floyd);
		
		this.listBoxers = boxers;
		boxer Mathieu = new boxer(1, "Mathieu", "Begginer");
		boxer Ryan = new boxer(2, "Ryan", "Professional");
		boxer Furry = new boxer(3, "Furry", "Professional");
		boxers.add(Mathieu);
		boxers.add(Ryan);
		boxers.add(Furry);
		
	}
	
}
	

