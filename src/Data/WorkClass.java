package Data;

import java.io.IOException;
import java.util.*;

import MainOptions.Drinks;
import MainOptions.Etceteras;
import MainOptions.MainDish;
import MainOptions.MenuOperations;
import MainOptions.MenuPosition;
import MainOptions.Soups;
public class WorkClass {

	private static Scanner input;
	private static MenuOperations _meOp;
	
	
	 public static void main(String[] args) throws IOException {
	 input = new Scanner(System.in);
	 boolean completed = false;
	 System.out.println("Welcome to 'Restaurant Menu Writer'!\nPlease follow the instructions below\n");
	 while (!completed){	
	 int choice = printMenu();
		
	 switch(choice){
	 
		case 1: //stworzenie nowego menu
			_meOp = new MenuOperations();
			System.out.println("New menu created");
			break;
			
		case 2: //dodanie pozycji do menu
			if (checkMenuCreated()){
				System.out.println("What is the name of the menu position You want to add?");
				String n = input.nextLine();
				System.out.println("How much You want it to cost?");
				double c = Double.parseDouble(input.nextLine());
				System.out.println("What kind of menu position it is going to be?\n Soup = s; Main Dish = md; Etceteras = e; Drink = d");
				String k = input.nextLine();
				MenuPosition mp = null;
				if (k.equalsIgnoreCase("s")){
					mp = new Soups(0, n, c);
				}
				else if (k.equalsIgnoreCase("md")){
					
					System.out.println("Choose the spicy level of this dish: 1 - spicy; 0 - medium; -1 - mild");
					int spicy = Integer.parseInt(input.nextLine());
					mp = new MainDish(0, n, c, spicy);
				}
				else if (k.equalsIgnoreCase("d")){
					System.out.println("Is your drink cold or hot? c = cold; h = hot");
					String temp = input.nextLine();
					boolean temperature;
					if (temp.charAt(0) == 'h' || temp.charAt(0) == 'H' ){ 
						temperature = true;
																		}
					else temperature = false;
					mp = new Drinks(0, n, c, temperature);
				}
				else{
					mp = new Etceteras(0, n, c);
				}
					boolean addMenuPosition = _meOp.addMenuPosition(mp);
					if (addMenuPosition){
						printMenuPosition("Successfully added position", mp);
					}
					else System.out.println("Position could not be added");
				
			}
		else
		{
			System.out.println("You must create the menu first.");
		}
			break;
		case 3: //usuniêcie pozycji z menu
			if (checkMenuCreated()){
				System.out.println("Enter index position you want to remove from the menu");
				int nu = Integer.parseInt(input.nextLine());
				boolean removed = _meOp.removeMenuPosition(nu);
				if (removed){
					System.out.println("Successfully removed position "+nu);
				}
				else{
				System.out.println("Could not remove position " + nu);
			}
		}
		else
		{
			System.out.println("You must create the menu first.");
		}
			break;
		case 4: //wyœwietlenie menu
			if (checkMenuCreated()){
				MenuPosition[] menu = (MenuPosition[])_meOp.getMenuPositions();
				if (menu != null && menu.length > 0){
					for (MenuPosition mp : menu){
						printMenuPosition("Next position: ", mp);
					}
				}
					else {
						System.out.println("Please add any position first");
					}
			}
					else {
						System.out.println("You must create menu first!");
						}
					break;
		case 5: //zapis do pliku
			if (checkMenuCreated())
			{
				boolean succed = MenuSaveLoadOptions.saveMenuToFile(FileDir.SaveFile, _meOp.getMenuList());
				if (succed){
					System.out.println("Successfully added positions to data file");
				}
				else{
					System.out.println("Could not add data to file, please check if there is any position to add");
				}
			}
			else{
				System.out.println("You must create menu first");
			}
			break;
		case 6: //odczyt z pliku
			if (checkMenuCreated()){
				_meOp.setMenuList(MenuSaveLoadOptions.loadMenuFromFile(FileDir.SaveFile));
				System.out.println("Succesfully loaded data from file");
			}
			else System.out.println("You must create menu first!");
			break;
		case 7: //quit
			System.out.println("Thank you for using 'Restaurant Menu Writer' by Adam Skimina");
			completed = true;
		}
		}
	 }
		public static boolean checkMenuCreated(){
			return _meOp != null;
		}
		public static void printMenuPosition(String message, MenuPosition mp){
			String outputDetails = "%s] %d Name: %s Cost: %.2f %s";
			String t = null;
			String extra = null;
			if (mp instanceof MainDish){
				t = "Main Dish";
				MainDish md = (MainDish) mp;
				extra = "Spicy:" + md.setSpicy();
			}
			else if (mp instanceof Soups){
				t = "Soup";
				extra = "";
			}
			else if (mp instanceof Drinks){
				t = "Drink";
				Drinks dr = (Drinks) mp;
				extra = "Temperature " + dr.setTemp();
			}
			else if (mp instanceof Etceteras){
				t = "Etceteras";
				extra = "";
			}
			System.out.println(String.format(outputDetails
											, t
											, mp.getPosition()
											, mp.getName()
											, mp.getPrice()
											, extra));
		}
		
		
	
	
	public static int printMenu(){
		System.out.println();
		System.out.println("Enter 1 to create new menu");
		System.out.println("Enter 2 to add position to menu");
		System.out.println("Enter 3 to remove position from menu");
		System.out.println("Enter 4 to view the menu");
		System.out.println("Enter 5 to save the menu to file");
		System.out.println("Enter 6 to load the menu from file");
		System.out.println("Enter 7 to quit");
		return Integer.parseInt(input.nextLine());
	}
		
	}


