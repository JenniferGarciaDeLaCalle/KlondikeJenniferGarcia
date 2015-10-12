package klondike;

import java.util.ArrayList;

public class StarAllLadder {

	public static final int NUM_LIST_DECK_DISCARD = 2;
	public static final int NUM_LIST_STICK = Klondike.NUM_DECK_CARD * Stick.values().length;
	public static final int NUM_LIST_LADDER = 7;
	private ArrayList<Card> allCard;
	private ArrayList<Ladder> allLadder;

	protected StarAllLadder() {
		allCard = new ArrayList<Card>();
		allLadder = new ArrayList<Ladder>();
		deckCard();
		for (int i = 0; i < (NUM_LIST_DECK_DISCARD + NUM_LIST_STICK + NUM_LIST_LADDER); i++) {
			allLadder.add(new Ladder());
		}
		distributeCard();
		new AllLadder(allLadder);
	}

	private void deckCard() {
		for (int i = 0; i < Klondike.NUM_DECK_CARD; i++) {
			oneDeckCard();
		}
	}

	private void oneDeckCard() {
		for (Number n : Number.values()) {
			for (Stick s : Stick.values()) {
				Card card = new Card(n, s, false);
				this.allCard.add(card);
			}
		}
	}

	private void distributeCard() {
		for (int i = 1; i <= NUM_LIST_LADDER; i++) {
			distributeCardInList(allLadder.get(allLadder.size() - i), i, false);
			spinLader(allLadder.get(allLadder.size() - i));
		}
		distributeCardInList(allLadder.get(0),
				Number.values().length * Stick.values().length * Klondike.NUM_DECK_CARD - 28, true);
	}

	private void distributeCardInList(Ladder ladder, int number, boolean deckCard) {
		for (int i = 0; i < number; i++) {
			ladder.getList().add(randomCard());
		}
		ladder.setDeckCard(deckCard);
	}

	private Card randomCard() {
		if (!allCard.isEmpty()) {
			int numberRandom = (int) (Math.random() * this.allCard.size());
			return this.allCard.remove(numberRandom);
		}
		return null;
	}

	private void spinLader(Ladder ladder) {
		ladder.getLastCard().setVisible(true);
	}

	protected ArrayList<Ladder> getAllLadder() {
		return allLadder;
	}

}
