package klondike;

public class MenuDiscardToLadder extends Menu {

	protected MenuDiscardToLadder() {
		option = 4;
		text = "Mover de descarte a escalera";
		listRemoveCard = 1;
		listAddCard = -1;
		numberCard = 1;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		if (!isListEmpty(listRemoveCard)) {
			listAddCard = new MenuView().ladderSelected("¿A qué escalera?");
			if (!isListEmpty(listAddCard)) {
				if (getOrdinalLastCard(listRemoveCard) + 1 == getOrdinalLastCard(listAddCard)) {
					return true;
				}
				mensageError = "Error!!! Las cartas tienen que ser consecutivas";
				return false;
			} else if (isListEmpty(listAddCard) && isLastCardTheLast(listRemoveCard)) {
				return true;

			} else {
				mensageError = "Error!!! La escalera tiene que tener cartas";
				return false;
			}
		}
		mensageError = "Error!!! Descarte tiene que tener cartas";
		return false;
	}
}