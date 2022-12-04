package PkgGestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class main {

	public static void main(String[] args) {
		//Declaration
		int iCtr = 0;
		int i = 0;
		int iChoiceId;
		String strName;
		int id = 0;
		int iSalary = 0;
				
		//Declaration of menus
		int iMenu = 0;
		String strMenu[] = {"Boxers", "Trainers", "Finance", "Close"};
		int iRetour=0;
		//String strRetour[] = {"OUI", "NON"};
		//Boxer menus
			int iBoxerMenu = 0;
			String strBoxerMenu[] = {"Display", "Modify", "Update fees", "Return"};
			int iModifyBoxerMenu = 0;
			String strModifyBoxerMenu[] = {"Add boxer", "Delete boxer", "Modify", "Return"};
			int iModifyModifyBoxerMenu = 0;
			String strModifyModifyBoxerMenu[] = {"Name", "Level", "Return"};
		//trainer menus
			int iTrainerMenu = 0;
			String strTrainerMenu[] = {"Display", "Modify", "Return"};
			int iTrainerModify = 0;
			String strTrainerModify[] = {"Add trainer", "Delete trainer", "Modify", "Return"};
			int iModifyModifyTrainerMenu = 0;
			String strModifyModifyTrainerMenu[] = {"Name","Seniority", "Return"};
		//finance menus
			int iFinanceMenu = 0;
			String strFinanceMenu[] = {"Display", "Modify Cost" , "Return"};
		
		//Declaration of the list
		List<trainer> trainerList = new ArrayList<>();
		List<boxer> boxerList = new ArrayList<>();
		
		//Initialization of the baseGym
		Gym gym = new Gym(trainerList, boxerList);
		//Uncomment the next line if you need some data already set.
		gym.setTr(trainerList, boxerList);
		System.out.println(boxerList);
		
		//Start of application
		do {
			//Initialization of the list of boxer for JOptionPane
			Object[] boxerCols = {"Id", "name", "Level"};
			Object[][] boxerRows = new Object [30][boxerCols.length];
			JTable boxerTable = new JTable(boxerRows,boxerCols);
			JScrollPane boxersTable = new JScrollPane(boxerTable);
			
			//Initialization of the list of trainer for JOptionPane
			Object[] trainerCols = {"Id", "name", "seniority"};
			Object[][] trainerRows = new Object [30][trainerCols.length];
			JTable trainerTable = new JTable(trainerRows, trainerCols);
			
			iMenu= JOptionPane.showOptionDialog(null, "Welcome to your management system." +"\nPlease choose an option.", "Management", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strMenu, strMenu[0]);
			switch (iMenu) {
//-------------------------------------------------------Boxers-------------------------------------------------------//			
			case 0:
				do { 
				iBoxerMenu= JOptionPane.showOptionDialog(null, "Choose an option.", "Management/Boxers", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strBoxerMenu, strBoxerMenu[0]);
				switch (iBoxerMenu) {
				//----------------------------------------Display----------------------------------------//
				case 0:
					System.out.println(boxerList.size());
					gym.getDisplayBoxers(boxerRows, boxerList, gym, boxerTable);
					break;
				//----------------------------------------Modify-----------------------------------------//
				case 1:
					do {
						iModifyBoxerMenu = JOptionPane.showOptionDialog(null, "Where do you whant to go?", "Management/Boxers/Modify", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strModifyBoxerMenu, strModifyBoxerMenu[0]);
						switch (iModifyBoxerMenu) {
						//----------Add boxer----------//
						case 0:
							strName = JOptionPane.showInputDialog("Enter the name of the boxer");
							//Setting the new id(+1 of the biggest id)
							int iPlace = 0;
							for(iCtr = 0; iCtr < gym.getSizeListBoxer(); iCtr++) {
								if(iPlace < gym.getBoxers().get(iCtr).getId()) {
									iPlace = gym.getBoxers().get(iCtr).getId();
								}
							}
							id = iPlace + 1;
							//Setting the level of the boxer
							try {
							String strLevel;
							String strChoiceLevel = JOptionPane.showInputDialog("Enter the level of the boxer(1-Begginer, 2-Intermediate, 3-Professional");
							switch (strChoiceLevel) {
							case "1":
								strLevel = "Begginer";
								break;
							case "2":
								strLevel = "Intermediate";
								break;
							case "3":
								strLevel = "Professional";
								break;
							default:
								strLevel = "Begginer";
								break;
							}
							//creating the new boxer
							boxer boxer = new boxer(id, strName , strLevel );
							gym.addBoxer(boxer);
							System.out.println(boxerList);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Please enter the information asked.");
							}
							break;
						//--------Delete boxer---------//
						case 1:
							try {
							iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the boxer you whant to delete"));
							} catch (Exception e ){
								JOptionPane.showMessageDialog(null, "Enter an Id.");
								break;
							}
							iCtr=0;
							i=0;
							do {
								if(iChoiceId == gym.getBoxers().get(iCtr).getId()) {
									gym.deleteBoxer(iCtr);
									JOptionPane.showMessageDialog(null, "Boxer " + gym.getBoxers().get(iCtr).getName() + " was deleted." );
									i = 1;
								}
								iCtr++;
							}while(iCtr < boxerList.size());
							if(i != 1) {
							JOptionPane.showMessageDialog(null, "Id not available");
							}
							break;
						//----------Modify-------------//	
						case 2:
							do {
							iModifyModifyBoxerMenu = JOptionPane.showOptionDialog(null,"Choose an option.", "Management/Boxers/Modify", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strModifyModifyBoxerMenu, strModifyModifyBoxerMenu[0]);
							switch (iModifyModifyBoxerMenu) {
							//-----Name-----//
							case 0:
							try {
							iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the boxer you whant to change."));
							iCtr=0;
							do {
								if(iChoiceId == gym.getBoxers().get(iCtr).getId()) {
									String strNewName = JOptionPane.showInputDialog("Enter the new name.");
									gym.getBoxers().get(iChoiceId).setName(strNewName);
								}
								iCtr++;
							}while(iCtr < boxerList.size());
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Enter an Id.");
							}
								break;
							//-----Level----//
							case 1:
							try {
							iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id number you whant to change the name."));
							iCtr=0;
							do {
								if(iChoiceId == gym.getBoxers().get(iCtr).getId()) {
									String strNewLevel = JOptionPane.showInputDialog("Enter the new level.");
									gym.getBoxers().get(iChoiceId).setLevel(strNewLevel);
								}
								iCtr++;
							}while(iCtr < boxerList.size());
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Enter an Id.");
							}
								break;
							//-----Return---//	
							case 2:
								break;
							}
							}while (iModifyModifyBoxerMenu !=2);
							break;
						//----------Return-------------//	
						case 3:
							break;
						}
					}while(iModifyBoxerMenu != 3);
					break;
				//--------------------------------------Update fees--------------------------------------//
				case 2:
					try {
					iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id number you whant to update the fee payed."));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Enter a id.");
						break;
					}
					iCtr=0;
					i = 0;
					do {
						if(iChoiceId == gym.getBoxers().get(iCtr).getId()) {
							//set the update of the fee
							if ( gym.getBoxers().get(iCtr).getFeeTotal() == gym.getBoxers().get(iCtr).getFeePayed()) {
								JOptionPane.showMessageDialog(null, "Fees already payed");
							}
							else {
								do {
								int iFeePayed =Integer.parseInt(JOptionPane.showInputDialog("fees paid: " + gym.getBoxers().get(iCtr).getFeePayed() + " $" + "\nfee total: " + gym.getBoxers().get(iCtr).getFeeTotal() + " $"));
								if (iFeePayed > gym.getBoxers().get(iCtr).getFeeTotal()) {
								JOptionPane.showMessageDialog(null, "The amount you have enter exced the amount of the fee.");
								}
								else if (iFeePayed == gym.getBoxers().get(iCtr).getFeeTotal()) { 
									gym.getBoxers().get(iCtr).setFee(iFeePayed);
									JOptionPane.showMessageDialog(null, "The boxer " + gym.getBoxers().get(iCtr).getId() + " has payed the total.");
									i = 1;
									break;
								}
								else if (iFeePayed != gym.getBoxers().get(iCtr).getFeeTotal()) {
									gym.getBoxers().get(iCtr).setFee(iFeePayed);
									break;
								}
								}while(i != 1);
							}
						}
						iCtr++;
					}while(iCtr < boxerList.size());
					if(i != 1) {
						JOptionPane.showMessageDialog(null, "Enter a valid id.");
					}
					break;
				//----------------------------------------Return-----------------------------------------//
				case 3:
					break;
				}
				} while(iBoxerMenu != 3);
				break;
//-------------------------------------------------------Trainers-------------------------------------------------------//				
			case 1:
				do {
				iTrainerMenu = JOptionPane.showOptionDialog(null, "Where do you whant to go?", "Management/Trainers", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strTrainerMenu, strTrainerMenu[0]);
				switch (iTrainerMenu) {
				//----------------------------------------Display----------------------------------------//	
				case 0:
					System.out.println(trainerList.size());
				gym.getDisplayTrainers(trainerRows, trainerList, gym, trainerTable);
					break;
				//----------------------------------------Modify-----------------------------------------//
				case 1:
					do {
					iTrainerModify = JOptionPane.showOptionDialog(null, "Where do you whant to go?", "Management/Trainers/Modify", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strTrainerModify, strTrainerModify[0]);	
					switch (iTrainerModify) {
					//----------Add trainer----------//
					case 0:
						strName = JOptionPane.showInputDialog("Enter the name of the trainer");
						int iSeniority;
						int iHours;
						//Setting the new id(+1 of the biggest id)
						int iPlace = 0;
						for(iCtr = 0; iCtr < gym.getSizeListTrainer(); iCtr++) {
							if(iPlace < gym.getTrainers().get(iCtr).getId()) {
								iPlace = gym.getTrainers().get(iCtr).getId();
							}
						}
						id = iPlace + 1;
						try {
						iSeniority = Integer.parseInt(JOptionPane.showInputDialog("Enter the seniority of the trainer."));
						iHours = Integer.parseInt(JOptionPane.showInputDialog("Enter the number hours the trainer will work."));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Please enter the informations needed.");
							break;
						}
						//Creating the trainer object
						trainer trainer = new trainer(id, strName, iSeniority, iHours);
						gym.addTrainers(trainer);
						System.out.println(trainerList);
						break;
					//----------Delete trainer----------//
					case 1:
						try {
						iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the trainer you whant to delete."));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Enter an id.");
							break;
						}
						i = 0;
						iCtr=0;
						do {
							if(iChoiceId == gym.getTrainers().get(iCtr).getId()) {
								gym.deleteTrainer(iCtr);
								JOptionPane.showMessageDialog(null, "You delete " + gym.getTrainers().get(iCtr).getName());
								i = 1;
							}
							iCtr++;
						}while(iCtr < trainerList.size());
						if( i != 1) {
							JOptionPane.showMessageDialog(null, "Id not available.");
						}
						break;
					//----------Modify----------//
					case 2:
						do {
						iModifyModifyTrainerMenu = JOptionPane.showOptionDialog(null, "Where do you whant to go?", "Management/Trainers/Modify/Modify", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strModifyModifyTrainerMenu, strModifyModifyTrainerMenu[0]);	
						switch (iModifyModifyTrainerMenu) {
						//-----Name-----//
						case 0:
						try {
						iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the trainer you whant to change the name."));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Enter an id.");
							break;
						}
						iCtr=0;
						i = 0;
						do {
							if(iChoiceId == gym.getTrainers().get(iCtr).getId()) {
								strName = JOptionPane.showInputDialog("Enter the name,");
								gym.getTrainers().get(iChoiceId).setName(strName);
								i = 1;
							}
							iCtr++;
						}while(iCtr < trainerList.size());
						if (i != 1) {
							JOptionPane.showMessageDialog(null, "Enter a valid id.");
						}
						break;
						//-----Seniority-----//	
						case 1:
						try {
						iChoiceId = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the trainer you whant to delete."));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Enter an id.");
							break;
						}
						i = 0;
						iCtr=0;
						do {
							if(iChoiceId == gym.getTrainers().get(iCtr).getId()) {
								iSeniority = Integer.parseInt(JOptionPane.showInputDialog("Enter the seniority."));
								gym.getTrainers().get(iChoiceId).setSeniority(iSeniority);
								i = 1;
							}
							iCtr++;
						}while(iCtr < trainerList.size());
						if(i != 1) {
							JOptionPane.showMessageDialog(null, "Enter a valid id.");
						}
							break;
						//-----Return-----//	
						case 2:
							break;
						}	
						}while(iModifyModifyTrainerMenu != 2);
						break;
					//----------Return----------//	
					case 3:
						break;
					}	
					}while(iTrainerModify != 3);
					break;
				//----------------------------------------Return-----------------------------------------//	
				case 2:
					break;
				}	
				}while(iTrainerMenu != 2);
				break;
//-------------------------------------------------------Finance-------------------------------------------------------//	
			case 2:
				do {
					iFinanceMenu = JOptionPane.showOptionDialog(null, "Where do you whant to go?", "Management/Finance", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, strFinanceMenu, strFinanceMenu[0]);	
					switch(iFinanceMenu)
					{
					//----------------------------------------Display-----------------------------------------//	
					case 0:
						JOptionPane.showMessageDialog(null, "FINANCE"
						+ "\nIncome: " + gym.getFees(boxerList) 
						+"\nSalary: " + gym.getSalary(trainerList)
						+"\nCost: " + gym.getCost()
						+"\nTotal: " + gym.getTotal());
						break;
					//----------------------------------------Modify Cost-----------------------------------------//	
					case 1:
						int iCost;
						try {
						iCost = Integer.parseInt(JOptionPane.showInputDialog("Enter the cost for the months."));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Enter a valid amount.");
							break;
						}
						gym.setCost(iCost);
						break;
					//----------------------------------------Return-----------------------------------------//	
					case 2:
						break;
					}

				}while(iFinanceMenu != 2);
				break;
//-------------------------------------------------------Close-------------------------------------------------------//
			case 3:
				JOptionPane.showMessageDialog(null,"Management system closed.");
				break;
			}
		}while(iMenu != 3);
	}

}
