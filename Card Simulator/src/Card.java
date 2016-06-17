import java.util.ArrayList;
import java.util.Random;


public class Card {
	
	private int value; // 0 is joker
	private int suit; // 0 = diamonds, 1 = clubs, 2 = hearts, 3 = spades
	
	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public int getValue() {return value;}
	public int getSuit() {return suit;}
	
	public static boolean isAllRed(ArrayList<Card> deck, int numChosen) {
		Card[] cards = new Card[numChosen];
		for (int i = 0; i < cards.length; i++)
			cards[i] = deck.remove(new Random().nextInt(deck.size()));
		
		for (int i = 0; i < cards.length; i++)
			if (cards[i].getSuit() == 1 || cards[i].getSuit() == 3 || cards[i].getSuit() == 4)
				return false;
		return true;
	}
	
	public static boolean isAllBlack(ArrayList<Card> deck, int numChosen) {
		Card[] cards = new Card[numChosen];
		for (int i = 0; i < cards.length; i++)
			cards[i] = deck.remove(new Random().nextInt(deck.size()));
		
		for (int i = 0; i < cards.length; i++)
			if (cards[i].getSuit() == 0 || cards[i].getSuit() == 2 || cards[i].getSuit() == 4)
				return false;
		return true;
	}
	
	public static boolean isAllNumbers(ArrayList<Card> deck, int numChosen) {
		Card[] cards = new Card[numChosen];
		for (int i = 0; i < cards.length; i++)
			cards[i] = deck.remove(new Random().nextInt(deck.size()));
		
		for (int i = 0; i < cards.length; i++)
			if (cards[i].getValue() < 2 || cards[i].getValue() > 10)
				return false;
		return true;
	}
	
	public static boolean isAllSuit(ArrayList<Card> deck, int numChosen) {
		Card[] cards = new Card[numChosen];
		for (int i = 0; i < cards.length; i++)
			cards[i] = deck.remove(new Random().nextInt(deck.size()));
		
		int providedSuit = cards[0].getSuit();
		if (providedSuit == 4) return false; 
		for (int i = 1; i < cards.length; i++)
			if (providedSuit != cards[i].getSuit())
				return false;
		return true;
	}
	
	public static boolean isAllChosenSuit(ArrayList<Card> deck, int numChosen, int suit) {
		Card[] cards = new Card[numChosen];
		for (int i = 0; i < cards.length; i++)
			cards[i] = deck.remove(new Random().nextInt(deck.size()));
		
		for (int i = 0; i < cards.length; i++)
			if (suit != cards[i].getSuit())
				return false;
		return true;
	}
	
	public static boolean isJokerFound(ArrayList<Card> deck, int numChosen) {
		Card[] cards = new Card[numChosen];
		for (int i = 0; i < cards.length; i++)
			cards[i] = deck.remove(new Random().nextInt(deck.size()));
		
		for (int i = 0; i < cards.length; i++)
			if (4 == cards[i].getSuit())
				return true;
		return false;
	}
	
	public static boolean isCardOfThreeSuits(ArrayList<Card> deck, int suit1, int suit2, int suit3) {
		Card card = deck.remove(new Random().nextInt(deck.size()));
		return card.getSuit() == suit1 || card.getSuit() == suit2 || card.getSuit() == suit3;
	}
}
