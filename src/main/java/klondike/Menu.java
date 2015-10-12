package klondike;

public abstract class Menu {

	private AllLadder allLadder;

	protected int option;
	protected String text;
	protected int listRemoveCard;
	protected int listAddCard;
	protected int numberCard;
	protected boolean visibility;
	protected String mensageError;

	protected void action(int option, AllLadder allLadder) {
		this.allLadder = allLadder;
		if (getOption() == option && precondition()){
			moveCard(allLadder);
		}
	}

	protected abstract boolean precondition();

	protected void moveCard(AllLadder classAllLadder) {
		classAllLadder.move(getListRemoveCard(), getListAddCard(), getNumberCard(), getVisibility());
	}

	protected boolean isListEmpty(int listNumber) {
		if (allLadder.getAllLadder().get(listNumber).getList().isEmpty()) {
			return true;
		}
		return false;
	}

	protected int listSize(int listNumber) {
		return allLadder.getAllLadder().get(listNumber).listSize();
	}

	protected Card getLastCard(int listNumber) {
		return allLadder.getAllLadder().get(listNumber).getLastCard();
	}

	protected int getOrdinalLastCard(int listNumber) {
		return getLastCard(listNumber).getNumber().ordinal();
	}

	protected int getOrdinal(Card card) {
		return card.getNumber().ordinal();
	}

	protected boolean isVisibleLastCard(int listnumber) {
		return getLastCard(listnumber).isVisible();
	}

	protected boolean isLastCardTheLast(int listNumber) {
		if (allLadder.getAllLadder().get(listNumber).getLastCard().getNumber().getValue() == 'K') {
			return true;
		}
		return false;
	}

	protected boolean isCardTheLast(Card card) {
		return card.getNumber().getValue() == 'K';
	}

	protected int getNumberVisibleCard(int listNumber) {
		return allLadder.getAllLadder().get(listNumber).getNumberVisibleCard();
	}

	protected Card firtsCardToMove(int listNumber) {
		return allLadder.getAllLadder().get(listNumber).getFirstCardToMove(numberCard);
	}

	protected int getOption() {
		return option;
	}

	protected int getListRemoveCard() {
		return listRemoveCard;
	}

	protected int getListAddCard() {
		return listAddCard;
	}

	protected int getNumberCard() {
		return numberCard;
	}

	protected boolean getVisibility() {
		return visibility;
	}

	protected String getText() {
		return text;
	}

	protected String getMensageError() {
		return mensageError;
	}

	protected void setMensageError(String mensageError) {
		this.mensageError = mensageError;
	}

}
