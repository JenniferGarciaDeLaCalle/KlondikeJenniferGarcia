package klondike;

public class MenuLadderToLadder extends Menu {

	protected MenuLadderToLadder() {
		option = 6;
		text = "Mover de escalera a escalera";
		listRemoveCard = -1;
		listAddCard = -1;
		numberCard = -1;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		listRemoveCard = new MenuView().ladderSelected("¿De qué escalera?");
		if (!isListEmpty(listRemoveCard)) {
			numberCard = new MenuView().numberCardSelected();
			if (numberCard <= getNumberVisibleCard(listRemoveCard)) {
				listAddCard = new MenuView().ladderSelected("¿A qué escalera?");
				if ((isListEmpty(listAddCard) && isCardTheLast(firtsCardToMove(listRemoveCard)))
						|| (listSize(listAddCard) > 0
						&& getOrdinal(firtsCardToMove(listRemoveCard)) + 1 == getOrdinalLastCard(listAddCard))) {
					return true;
				} else {
					mensageError = "Error!!! No es posible mover la carta";
				}
			} else {
				mensageError = "Error!!! No hay tantas cartas visibles en la escalera";
			}
		}
		mensageError = "Error!!! La escalera "
				+ (listRemoveCard - StarAllLadder.NUM_LIST_DECK_DISCARD - StarAllLadder.NUM_LIST_LADDER)
				+ " no puede estar vacia";
		return false;
	}

}
