package klondike;

public class MenuDiscardToStick extends Menu {

	protected MenuDiscardToStick() {
		option = 3;
		text = "Mover de descarte a palo";
		listRemoveCard = 1;
		listAddCard = -1;
		numberCard = 1;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		if (!isListEmpty(listRemoveCard)) {
			listAddCard = getLastCard(listRemoveCard).getStick().ordinal() + StarAllLadder.NUM_LIST_DECK_DISCARD;
			if ((isListEmpty(listAddCard) && getOrdinalLastCard(listRemoveCard) == 0) || (listSize(listAddCard) > 0
					&& getOrdinalLastCard(listRemoveCard) - 1 == getOrdinalLastCard(listAddCard))) {
				return true;
			} else {
				mensageError = "Error!!! No es posible mover la primera carta de descartes";
			}
		} else {
			mensageError = "Error!!! No hay ninguna carta en descartes";
		}
		return false;
	}

}
