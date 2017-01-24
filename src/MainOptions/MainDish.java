package MainOptions;

public class MainDish extends MenuPosition{
	int _spicy;
	
	public MainDish(){
		
	}
	
	public MainDish(int position, String name, double price, int spicy){
		super(position, name, price);
		_spicy = spicy;
	}
	public String setSpicy(){
		if (_spicy > 0) return "very_spicy";
		else if (_spicy == 0) return "medium_spicy";
		else return "low_spicy";
	}
	public String setSpicyLevel(String spicy){
		if (spicy.equals("very_spicy")){
			_spicy = 1; 
			return "very_spicy";
		}
		else if (spicy.equals("medium_spicy")){
			_spicy = 0;
			return "medium_spicy";
		}
		else{
			_spicy = -1;
			return "low_spicy";
		}
	}
	
	
	public String toString(){
		return String.format("%s %s %s]" 
							, super.toString()
							, getClass()
							, setSpicy());
	}
	public String toDataString(){
		   return String.format("MAINDISH|%s;spicy=%s"
		    							, super.toDataString()
		    							, setSpicy());			
		    }
}


