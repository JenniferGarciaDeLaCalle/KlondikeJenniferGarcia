package klondike;

public enum Stick {

	O('o'),
	C('c'),
	E('e'),
	B('b');

	private char value;

	private Stick(char value) {
		this.value = value;
	}

	protected char getValue() {
		return value;
	}
}
