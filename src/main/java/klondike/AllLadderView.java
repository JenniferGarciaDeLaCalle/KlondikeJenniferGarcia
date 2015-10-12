package klondike;

import java.util.ArrayList;

public class AllLadderView {

	private AllLadder allLadder;
	private ArrayList<String> textLadder;

	protected AllLadderView(ArrayList<Ladder> allLadder) {
		super();
		this.allLadder = new AllLadder(allLadder);
		textLadder = new ArrayList<String>();
		textLadder.add("Baraja");
		textLadder.add("Descarte");
		textLadder.add("Palo oros");
		textLadder.add("Palo copas");
		textLadder.add("Palo espadas");
		textLadder.add("Palo bastos");
	}

	protected void print() {
		IO io = new IO();
		io.writeln("===========================");
		for (int i = 0; i < this.allLadder.getAllLadder().size(); i++) {
			nameLadder(this.allLadder.getAllLadder().get(i), i);
			new LadderView(this.allLadder.getAllLadder().get(i)).print();
		}
		io.writeln("---------------------------");
	}

	private void nameLadder(Ladder ladder, int position) {
		if (position < textLadder.size()) {
			ladder.setText(textLadder.get(position));
		} else {

			ladder.setText("Escalera " + (position - (StarAllLadder.NUM_LIST_LADDER - StarAllLadder.NUM_LIST_DECK_DISCARD)));
		}
		ladder.setText(ladder.getText() + ": ");
	}

	protected AllLadder getAllLadder() {
		return allLadder;
	}

}
