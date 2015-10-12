package klondike;

public class MenuStickToLadder extends Menu {

	protected MenuStickToLadder() {
		option = 7;
		text = "Mover de palo a escalera";
		listRemoveCard = -1;
		listAddCard = -1;
		numberCard = 1;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		listRemoveCard = new MenuView().stickSelected("¿De qué palo?") + StarAllLadder.NUM_LIST_DECK_DISCARD;
		if (!isListEmpty(listRemoveCard)) {
			listAddCard = new MenuView().ladderSelected("¿A qué escalera?");
			if ((isListEmpty(listAddCard) && isLastCardTheLast(listRemoveCard))
					|| (getOrdinalLastCard(listAddCard) - 1 == getOrdinalLastCard(listRemoveCard))) {
				return true;
			} else {
				mensageError = "Error!!! No se puede moverde ese palo a esa escalera";
				return false;
			}
		}
		mensageError = "Error!!! El palo no puede estar vacio";
		return false;
	}

}