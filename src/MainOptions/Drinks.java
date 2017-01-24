package MainOptions;

public class Drinks extends MenuPosition{
	boolean _temperature;
	
	public Drinks(){
		
	}
	public Drinks(int position, String name, double price, boolean temp){
		super(position, name, price);
		_temperature = temp;
	}
	
	public boolean checkTemp(){
		return _temperature;
	}
	public String setTemp(){
		if  (_temperature) return "hot";
		else return "cold";
	}
	public String setTemperature(String temp){
		if  (temp.equals("hot")){
			_temperature = true;
			return "hot";
		}
		else{
			_temperature = false;
			return "cold";
		}
	}
	
	public String toString(){
		return String.format("%s %s %s]" 
							, super.toString()
							, getClass()
							, setTemp());
	}
	public String toDataString(){
		   return String.format("DRINKS|%s;temperature=%s"
				   						, super.toDataString()
				   						, setTemp());	
		    }
}

