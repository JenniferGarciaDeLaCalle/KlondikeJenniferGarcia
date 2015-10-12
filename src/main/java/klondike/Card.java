package klondike;

public class Card {

	private Number number;
	private Stick stick;
	private boolean visible;

	protected Card() {
	}

	protected Card(Number number, Stick stick, boolean visible) {
		super();
		this.number = number;
		this.stick = stick;
		this.visible = visible;
	}

	protected Number getNumber() {
		return number;
	}

	protected Stick getStick() {
		return stick;
	}

	protected boolean isVisible() {
		return visible;
	}

	protected void setVisible(boolean visible) {
		this.visible = visible;
	}

	protected Card getCard() {
		return new Card(number, stick, visible);
	}

}
