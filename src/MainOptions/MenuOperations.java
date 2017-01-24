package MainOptions;

import java.util.ArrayList;

public class MenuOperations {
	ArrayList<MenuPosition> _menu;
	public static int nextPosition = 1;
	
	public MenuOperations(){
		_menu = new ArrayList<MenuPosition>();
		
	}
	private int findPosition(int position){
		if (position < 0 || position > 100) return -1;
		for (int i = 0; i < _menu.size(); i++){
			MenuPosition m = _menu.get(i);
			if (m.getPosition() == position){
				return i;
			}
		}
		return -1;
	}
	public MenuPosition getMenuPosition(int position){
		int index = findPosition(position);
		if (index < 0) return null;
		return _menu.get(index);
	}
	public boolean addMenuPosition(MenuPosition m){
		if (m == null) return false;
		if (m.getPosition() < 0) return false;
		int positionIndex = findPosition(m.getPosition());
		if (positionIndex >= 0) return false;
		_menu.add(m);
		m.setPosition(nextPosition++);
		return true;
	}
	public boolean removeMenuPosition(int position){
		if (position < 0) return false;
		int menuPosition = findPosition(position);
		if (menuPosition < 0) return false;
		_menu.remove(menuPosition);
		return true;
	}
	public MenuPosition[] getMenuPositions(){
		if (_menu.size() > 0){
			MenuPosition[] menu = new MenuPosition[_menu.size()];
			for (int i = 0; i < _menu.size(); i++){
				menu[i] = (MenuPosition)_menu.get(i);
			}
			return menu;
			}
		else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<MenuPosition> getMenuList(){
		return (ArrayList<MenuPosition>)_menu.clone();
	}
	public void setMenuList(ArrayList<MenuPosition> menu){
		_menu = menu;
	}
}
