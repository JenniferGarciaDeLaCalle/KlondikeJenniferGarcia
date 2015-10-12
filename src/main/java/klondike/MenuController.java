package klondike;

import java.util.LinkedList;

public class MenuController {

	private LinkedList<Menu> menu;
	
	protected MenuController(){
		menu = new LinkedList<Menu>();
		menu.add(new MenuDeckCardToDiscard());
		menu.add(new MenuDiscardToDeckCard());
		menu.add(new MenuDiscardToStick());
		menu.add(new MenuDiscardToLadder());
		menu.add(new MenuLadderToStick());
		menu.add(new MenuLadderToLadder());
		menu.add(new MenuStickToLadder());
		menu.add(new MenuFlipLadder());
		menu.add(new MenuExit());
	}

	protected LinkedList<Menu> getMenu() {
		return menu;
	}
}
