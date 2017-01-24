package MainOptions;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class MenuPosition{
	private String _name;
	private int _position;
	private double _price;
	public MenuPosition(){
		//do nothing
	}
	public MenuPosition(int position, String name, double price){
		_name = name;
		_position = position;
		_price = price;
	}
	DecimalFormat df = new DecimalFormat("##.##", new DecimalFormatSymbols(Locale.US));
	public String getClassName(){
		return getClass().toString();
	}
	public void setName(String value){
		_name = value;
	}
	public String getName(){
		return _name;
	}
	public void  setPosition(int value){
		 _position = value;
	}
	public int getPosition(){
		return _position;
	}
	public void setPrice(double value){
		_price = value;
	}
	public double getPrice(){
		return _price;
	}
	
	
	public String toString(){
		return String.format("%s Position: %d\tName: %s\tPrice: %s\t" 
							, getClass()
							, getPosition()
							, getName()
							, df.format(getPrice()));
	}
	public String toDataString(){
	   return String.format("position=%d;name=%s;price=%s"
	    							, getPosition()
	    							, getName()
	    							, df.format(getPrice()));			
	    }
}
