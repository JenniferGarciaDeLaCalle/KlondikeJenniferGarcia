package klondike;

public class CardView {

	private Card card;

	protected CardView(Card card) {
		super();
		this.card = card;
	}

	protected void print() {
		IO io = new IO();
		if (card.isVisible()) {
			io.write("[" + card.getNumber().getValue() + "," + card.getStick().getValue() + "]");
		} else {
			io.write("[X,X]");
		}
	}
}
