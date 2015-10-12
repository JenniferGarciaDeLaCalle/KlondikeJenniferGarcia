package klondike;

import java.util.ArrayList;

public class Ladder {

	private ArrayList<Card> list;
	private String text;
	private boolean deckCard;

	protected Ladder() {
		this.list = new ArrayList<Card>();
		this.text = "";
		this.deckCard = false;
	}

	protected int listSize() {
		return list.size();
	}

	protected Card getLastCard() {
		if (!list.isEmpty()){
			return list.get(list.size() - 1);
		}
		return null;
	}

	protected boolean isLastCardVisible() {
		return getLastCard().isVisible();
	}

	protected int getLastCardPositionNumber() {
		return list.size() - 1;
	}

	protected Card getFirstCardToMove(int numberOfCard) {
		return list.get(list.size() - numberOfCard);
	}

	protected int getNumberVisibleCard() {
		int numCard = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isVisible() == true) {
				numCard++;
			}
		}
		return numCard;
	}

	protected String getText() {
		return text;
	}

	protected void setText(String text) {
		this.text = text;
	}

	protected ArrayList<Card> getList() {
		return list;
	}

	protected Card getListCard(int position) {
		return list.get(position);
	}

	protected boolean isDeckCard() {
		return deckCard;
	}

	protected void setDeckCard(boolean deckCard) {
		this.deckCard = deckCard;
	}

}
