package klondike;

public class MenuView {

	private MenuController menuController;

	protected MenuView() {
		super();
		this.menuController = new MenuController();
	}

	protected void printMenu() {
		IO io = new IO();
		for (int i = 0; i < menuController.getMenu().size(); i++) {
			io.writeln(menuController.getMenu().get(i).getOption() + ". " + menuController.getMenu().get(i).getText());
		}
	}

	protected int optionSelected() {
		IO io = new IO();
		io.write("Opción? [" + menuController.getMenu().get(0).getOption() + "-"
				+ menuController.getMenu().get(menuController.getMenu().size() - 1).getOption() + "]:");
		int option = Integer.parseInt(io.readString(""));
		if (option >= menuController.getMenu().get(0).getOption()
				&& option <= menuController.getMenu().get(menuController.getMenu().size() - 1).getOption()) {
			return option;
		} else {
			io.writeln("ERROR!!! La opción debe ser entre " + menuController.getMenu().get(0).getOption() + " y "
					+ menuController.getMenu().get(menuController.getMenu().size() - 1).getOption() + " inclusives");
			option = optionSelected();
			return option;
		}
	}

	protected int ladderSelected(String mensage) {
		IO io = new IO();
		io.write(mensage + " [1-" + StarAllLadder.NUM_LIST_LADDER + "]: ");
		int ladder = Integer.parseInt(io.readString(""));
		if (ladder >= 1 && ladder <= StarAllLadder.NUM_LIST_LADDER) {
			return ladder - 1 + StarAllLadder.NUM_LIST_DECK_DISCARD + StarAllLadder.NUM_LIST_STICK;
		} else {
			io.writeln("ERROR!!! La opción debe ser entre 1 y " + StarAllLadder.NUM_LIST_LADDER + " inclusives");
			ladderSelected(mensage);
		}
		return 0;
	}

	protected int numberCardSelected() {
		IO io = new IO();
		io.write("¿Cuántas cartas?: ");
		return Integer.parseInt(io.readString(""));
	}

	protected int stickSelected(String mensage) {
		IO io = new IO();
		io.write(mensage + " [1-" + StarAllLadder.NUM_LIST_STICK + "]: ");
		int stick = Integer.parseInt(io.readString(""));
		if (stick >= 1 && stick <= StarAllLadder.NUM_LIST_STICK) {
			return stick - 1;
		} else {
			io.writeln("ERROR!!! La opción debe ser entre 1 y " + StarAllLadder.NUM_LIST_STICK + " inclusives");
			stickSelected(mensage);
		}
		return 0;
	}

	protected void printError() {
		for (int i = 0; i < menuController.getMenu().size(); i++) {
			if (!"".equals(menuController.getMenu().get(i).getMensageError())) {
				new IO().writeln(menuController.getMenu().get(i).getMensageError());
				menuController.getMenu().get(i).setMensageError("");
			}
		}
	}

	protected void winGame() {
		new IO().writeln("¡¡¡Enhorabuena has ganado la partida!!!");
	}

	protected MenuController getMenuController() {
		return menuController;
	}

}
