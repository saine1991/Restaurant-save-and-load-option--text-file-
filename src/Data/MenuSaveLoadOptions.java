package Data;

import java.io.*;
import java.util.ArrayList;

import MainOptions.*;

public class MenuSaveLoadOptions {
	public static boolean saveMenuToFile(String SaveFile, ArrayList<MenuPosition> menuPositions) throws IOException
	{
		FileWriter fw = new FileWriter(SaveFile);
		BufferedWriter bw = new BufferedWriter(fw);
		boolean anyPositionAdded = false;
		for (MenuPosition mp : menuPositions){
			bw.write(mp.toDataString());
			bw.newLine();
			anyPositionAdded = true;
											 }
		bw.close();
		bw = null;
		fw.close();
		fw = null;
		
		return anyPositionAdded;
	}
	public static ArrayList<MenuPosition> loadMenuFromFile(String SaveFile) throws IOException{
		FileReader fr = new FileReader(SaveFile);
		BufferedReader br = new BufferedReader(fr);
		String nextLine = null;
		ArrayList<MenuPosition> menuPositions = new ArrayList<>();
		
		while ((nextLine = br.readLine()) != null){
			MenuPosition mpo = processMenuPosition(nextLine);
			if (mpo != null){
				menuPositions.add(mpo);
			}
		}
		br.close();
		br = null;
		fr.close();
		fr = null;
		
		return menuPositions;
		}
	
	private static MenuPosition processMenuPosition(String data){
		MenuPosition mpo = null;
		String[] dataValues = data.split("\\|");
		
		switch(dataValues[0]){
		case "DRINKS":
			mpo = new Drinks();
			break;
		case "ETCETERAS":
			mpo = new Etceteras();
			break;
		case "MAINDISH":
			mpo = new MainDish();
			break;
		case "SOUPS":
			mpo = new Soups();
			break;
			default:
				mpo = null;
				break;
		}
		if (mpo == null) return null;
		
		String[] properties = dataValues[1].split(";");
		for (String s : properties){
			String propValues[] = s.split("=");
			switch(propValues[0]){
			case "position":
				mpo.setPosition(Integer.parseInt(propValues[1]));
				MenuOperations.nextPosition = mpo.getPosition()+1;
				break;
			case "name":
				mpo.setName(propValues[1]);
				break;
			case "price":
				mpo.setPrice(Double.parseDouble(propValues[1]));
				break;
			case "temperature":
				((Drinks)mpo).setTemperature(propValues[1]);
				break;
			case "spicy":
				((MainDish)mpo).setSpicyLevel(propValues[1]);
				break;
				default:
					break;
			}
		}
		return mpo;
	}
}
