package klondike;

import java.util.ArrayList;

public class AllLadder {

	private ArrayList<Ladder> allLadderList;

	protected AllLadder(ArrayList<Ladder> allLadder) {
		super();
		allLadderList = allLadder;
	}

	protected ArrayList<Ladder> getAllLadder() {
		return allLadderList;
	}

	protected void setAllLadder(ArrayList<Ladder> allLadder) {
		allLadderList = allLadder;
	}

	protected void move(int listRemoveNumber, int listAddNumber, int numberCard, boolean visibility) {
		ArrayList<Card> listCardMove = cardOfListToRemove(listRemoveNumber, numberCard);
		changeVisibilityOfList(listCardMove, visibility);
		cardOfListToAdd(listAddNumber, listCardMove);
	}

	private ArrayList<Card> cardOfListToRemove(int listNumber, int numberCard) {
		ArrayList<Card> listRemoveCard = allLadderList.get(listNumber).getList();
		ArrayList<Card> listCardMove = new ArrayList<Card>();
		for (int i = 0; i < numberCard && listRemoveCard.isEmpty() == false; i++) {
			listCardMove.add(listRemoveCard.remove(listRemoveCard.size() - 1));
		}
		return listCardMove;
	}

	private void changeVisibilityOfList(ArrayList<Card> listCardMove, boolean visibility) {
		for (int i = 0; i < listCardMove.size(); i++) {
			listCardMove.get(i).setVisible(visibility);
		}
	}

	private void cardOfListToAdd(int listNumber, ArrayList<Card> listWithCard) {
		ArrayList<Card> listAddCard = allLadderList.get(listNumber).getList();
		while (listWithCard.isEmpty() == false) {
			Card card = listWithCard.remove(listWithCard.size() - 1);
			listAddCard.add(card);
		}
	}

	protected boolean finishGame() {
		for (int i = StarAllLadder.NUM_LIST_DECK_DISCARD; i < StarAllLadder.NUM_LIST_DECK_DISCARD
				+ StarAllLadder.NUM_LIST_STICK; i++) {
			Card card = getAllLadder().get(i).getLastCard();
			if (card == null || card.getNumber().ordinal() != Number.values().length - 1) {
				return false;
			}
		}
		return true;
	}
}
