package klondike;

public class MenuDiscardToDeckCard extends Menu {

	protected MenuDiscardToDeckCard() {
		option = 2;
		text = "Mover de descarte a baraja";
		listRemoveCard = 1;
		listAddCard = 0;
		numberCard = 3;
		visibility = false;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		if (!isListEmpty(listRemoveCard) && isListEmpty(listAddCard)) {
			return true;
		}
		mensageError = "Error!!! Baraja tiene que estar vacia y Descarte tener cartas";
		return false;
	}
}
