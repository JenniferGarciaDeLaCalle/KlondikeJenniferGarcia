package klondike;

public class MenuDeckCardToDiscard extends Menu {

	protected MenuDeckCardToDiscard() {
		option = 1;
		text = "Mover de baraja a descarte";
		listRemoveCard = 0;
		listAddCard = 1;
		numberCard = 3;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		if (!isListEmpty(listRemoveCard) && isListEmpty(listAddCard)) {
			return true;
		}
		mensageError = "Error!!! Baraja tiene que tener cartas y Descarte estar vacio";
		return false;
	}
}
