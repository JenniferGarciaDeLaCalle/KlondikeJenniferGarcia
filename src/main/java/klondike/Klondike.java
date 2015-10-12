package klondike;

import java.util.ArrayList;

public class Klondike {

	protected static final int NUM_DECK_CARD = 1;
	private AllLadderView allLadderView;
	private MenuView menuView;
	private static final int OPTION_EXIT_MENU = 9;

	protected Klondike() {
		ArrayList<Ladder> allLadder = new StarAllLadder().getAllLadder();
		allLadderView = new AllLadderView(allLadder);
		menuView = new MenuView();
	}

	protected void play() {
		int exit = 0;
		while (!allLadderView.getAllLadder().finishGame() && exit == 0) {
			exit = oneRound();
		}
		if (exit != -1) {
			menuView.winGame();
		}
	}

	protected int oneRound() {
		allLadderView.print();
		menuView.printMenu();
		int option = menuView.optionSelected();
		for (int i = 0; i < menuView.getMenuController().getMenu().size(); i++) {
			menuView.getMenuController().getMenu().get(i).action(option, allLadderView.getAllLadder());
		}
		menuView.printError();
		if (option == OPTION_EXIT_MENU){
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		new Klondike().play();
	}
}
