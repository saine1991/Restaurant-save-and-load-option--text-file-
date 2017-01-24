package MainOptions;

public class Etceteras extends MenuPosition{
	
	public Etceteras(){
		
	}
	
	public Etceteras(int position, String name, double price){
		super(position, name, price);
	}
	
	
	public String toString(){
		return String.format("%s %s]" 
							, super.toString()
							, getClass());
	}
	public String toDataString(){
		   return String.format("ETCETERAS|%s"
		    							, super.toDataString());			
		    }
}

