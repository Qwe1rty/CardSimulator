import java.util.ArrayList;


public class Sim {

	private static final int NUM_SIMULATIONS = 1000000;
	private static ArrayList<Card> deck;
	private static int win, lose;

	public static void main(String[] args) {
				testAll();
		//		testRed();
		//		testBlack();
		//		testNumbers();
		//		testSuits();
		//		testChosenSuit(0);
		//		testJoker();
	}

	private static ArrayList<Card> generateDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int i = 1; i <= 13; i++)
			for (int j = 0; j < 4; j++)
				deck.add(new Card(i, j));
		deck.add(new Card(0, 4));
		return deck;
	}

	private static void testAll() {
		testRed();
		//		testBlack();
		testNumbers();
		testSuits();
		testChosenSuit(0);
		testJoker();
		testCardOfThreeSuits(0, 1, 2);
	}

	private static void testRed() {
		for (int n = 1; n <= 5; n++) {
			win = 0; 
			lose = 0;
			for (int i = 0; i < NUM_SIMULATIONS; i++) {
				deck = generateDeck();
				if (Card.isAllRed(deck, n)) win++;
				else lose++;
			}
			System.out.println("All red - " + n + " cards");
			System.out.println("Wins: " + win + " Loses: " + lose);
			System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
			System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
			System.out.println();
		}
	}

	private static void testBlack() {
		for (int n = 1; n <= 5; n++) {
			win = 0; 
			lose = 0;
			for (int i = 0; i < NUM_SIMULATIONS; i++) {
				deck = generateDeck();
				if (Card.isAllBlack(deck, n)) win++;
				else lose++;
			}
			System.out.println("All black - " + n + " cards");
			System.out.println("Wins: " + win + " Loses: " + lose);
			System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
			System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
			System.out.println();
		}
	}

	private static void testNumbers() {
		ArrayList<Card> deck;
		int win, lose;

		for (int n = 1; n <= 5; n++) {
			win = 0; 
			lose = 0;
			for (int i = 0; i < NUM_SIMULATIONS; i++) {
				deck = generateDeck();
				if (Card.isAllNumbers(deck, n)) win++;
				else lose++;
			}
			System.out.println("All numbers - " + n + " cards");
			System.out.println("Wins: " + win + " Loses: " + lose);
			System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
			System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
			System.out.println();
		}
	}

	private static void testSuits() {
		ArrayList<Card> deck;
		int win, lose;

		for (int n = 1; n <= 5; n++) {
			win = 0; 
			lose = 0;
			for (int i = 0; i < NUM_SIMULATIONS; i++) {
				deck = generateDeck();
				if (Card.isAllSuit(deck, n)) win++;
				else lose++;
			}
			System.out.println("All matching suits - " + n + " cards");
			System.out.println("Wins: " + win + " Loses: " + lose);
			System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
			System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
			System.out.println();
		}
	}

	private static void testChosenSuit(int suit) {
		ArrayList<Card> deck;
		int win, lose;

		for (int n = 1; n <= 5; n++) {
			win = 0; 
			lose = 0;
			for (int i = 0; i < NUM_SIMULATIONS; i++) {
				deck = generateDeck();
				if (Card.isAllChosenSuit(deck, n, suit)) win++;
				else lose++;
			}
			switch (suit) {
				case 0: System.out.println("All diamonds - " + n + " cards");
				break;
				case 1: System.out.println("All clubs - " + n + " cards");
				break;
				case 2: System.out.println("All hearts - " + n + " cards");
				break;
				case 3: System.out.println("All spades - " + n + " cards");
			}
			System.out.println("Wins: " + win + " Loses: " + lose);
			System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
			System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
			System.out.println();
		}
	}

	private static void testJoker() {
		ArrayList<Card> deck;
		int win, lose;

		for (int n = 1; n <= 5; n++) {
			win = 0; 
			lose = 0;
			for (int i = 0; i < NUM_SIMULATIONS; i++) {
				deck = generateDeck();
				if (Card.isJokerFound(deck, n)) win++;
				else lose++;
			}
			System.out.println("Joker found - " + n + " cards");
			System.out.println("Wins: " + win + " Loses: " + lose);
			System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
			System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
			System.out.println();
		}
	}

	private static void testCardOfThreeSuits(int suit1, int suit2, int suit3) {
		ArrayList<Card> deck;
		int win, lose;

		win = 0; 
		lose = 0;
		for (int i = 0; i < NUM_SIMULATIONS; i++) {
			deck = generateDeck();
			if (Card.isCardOfThreeSuits(deck, suit1, suit2, suit3)) win++;
			else lose++;
		}
		System.out.println("Is of Three Suits");
		System.out.println("Wins: " + win + " Loses: " + lose);
		System.out.println("Win%: " + win / (win + lose + 0.0f) * 100);
		System.out.println("Lose%: " + lose / (win + lose + 0.0f) * 100);
		System.out.println();
	}

}
