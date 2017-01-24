package MainOptions;

public class Soups extends MenuPosition{
	public Soups(){
		//do nothing
	}
	
	public Soups(int position, String name, double price){
		super(position, name, price);
	}

	public String toString(){
		return String.format("%s %s" 
							, super.toString()
							, getClass());
	}
	public String toDataString(){
		   return String.format("SOUPS|%s"
		    							, super.toDataString());			
		    }
}

