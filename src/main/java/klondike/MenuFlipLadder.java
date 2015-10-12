package klondike;

public class MenuFlipLadder extends Menu {

	protected MenuFlipLadder() {
		option = 8;
		text = "Voltear en escalera";
		listRemoveCard = -1;
		listAddCard = -1;
		numberCard = 1;
		visibility = true;
		mensageError = "";
	}

	@Override
	protected boolean precondition() {
		listRemoveCard = new MenuView().ladderSelected("¿En qué escalera?");
		if (!isListEmpty(listRemoveCard)) {
			if (!isVisibleLastCard(listRemoveCard)) {
				listAddCard = listRemoveCard;
				return true;
			}
			mensageError = "Error!!! No se puede voltear una carta descubierta";
			return false;
		}
		mensageError = "Error!!! La escalera no puede estar vacia";
		return false;
	}

}