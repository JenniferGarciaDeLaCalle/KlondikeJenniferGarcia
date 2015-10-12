package klondike;

public enum Number {

	A('A'),
	B('2'),
	C('3'),
	D('4'),
	E('5'),
	F('6'),
	G('7'),
	H('J'),
	I('Q'),
	J('K');

	private char value;

	private Number(char value) {
		this.value = value;
	}

	protected char getValue() {
		return value;
	}
}
