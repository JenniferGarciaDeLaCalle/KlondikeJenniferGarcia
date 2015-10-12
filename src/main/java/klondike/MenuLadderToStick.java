package klondike;

public class MenuLadderToStick extends Menu {

	protected MenuLadderToStick() {
		option = 5;
		text = "Mover de escalera a palo";
		listRemoveCard = -1;
		listAddCard = -1;
		numberCard = 1;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		listRemoveCard = new MenuView().ladderSelected("¿De qué escalera?");
		if (!isListEmpty(listRemoveCard)) {
			listAddCard = getLastCard(listRemoveCard).getStick().ordinal() + StarAllLadder.NUM_LIST_DECK_DISCARD;
			if ((isListEmpty(listAddCard) && getOrdinalLastCard(listRemoveCard) == 0) || (listSize(listAddCard) > 0
					&& getOrdinalLastCard(listRemoveCard) - 1 == getOrdinalLastCard(listAddCard))) {
				return true;
			} else {
				mensageError = "Error!!! No es posible mover la carta";
			}
		}
		mensageError = "Error!!! La escalera " + listRemoveCard + " no puede estar vacia";
		return false;
	}
}
