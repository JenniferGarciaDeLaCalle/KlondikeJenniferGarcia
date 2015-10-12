package klondike;

public class LadderView {

	private Ladder ladder;

	protected LadderView(Ladder list) {
		super();
		this.ladder = list;
	}

	protected void print() {
		printText();
		if (ladder.getList().isEmpty()) {
			printEmpty();
		} else {
			printLadder();
		}
		new IO().writeln("");
	}

	private void printText() {
		new IO().write(ladder.getText());
	}

	private void printEmpty() {
		new IO().write("<vacio>");
	}

	private void printLadder() {
		if (ladder.isDeckCard() == true) {
			new IO().write("[X,X]");
		} else {
			printCardLadder();
		}
	}

	private void printCardLadder() {
		IO io = new IO();
		for (int i = 0; i < ladder.listSize(); i++) {
			if (i == ladder.getLastCardPositionNumber() && ladder.getLastCard().isVisible() == false) {
				io.write("[X,X]");
			} else if (ladder.getListCard(i).isVisible() == false) {
				io.write("[");
			} else {
				new CardView(ladder.getListCard(i)).print();
			}
		}
	}
}
