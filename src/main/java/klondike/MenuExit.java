package klondike;

public class MenuExit extends Menu{

	protected MenuExit() {
		option = 9;
		text = "Salir";
		listRemoveCard = -1;
		listAddCard = -1;
		numberCard = -1;
		visibility = false;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		new IO().write("Adios!!!");
		return false;
	}
}