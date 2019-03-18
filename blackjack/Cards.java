import java.util.Random;
import java.util.ArrayList;

class Cards{
	enum Suit{
		SPADE(0,"♠"),
		HEART(1,"♥"),
		DIAMOND(2,"♦"),
		CLOVER(3,"♣");

		private final int _value;
		private final String _symbol;
		
		Suit(int value, String symbol){
			this._value = value;
			this._symbol = symbol;
		}
		String getSymbol(){
			return this._symbol;
		}
		int getValue(){
			return this._value;
		}
	}
	
	enum Rank{
		ACE(1,"A"),
		TWO(2,"2"),
		THREE(3,"3"),
		FOUR(4,"4"),
		FIVE(5,"5"),
		SIX(6,"6"),
		SEVEN(7,"7"),
		EIGHT(8,"8"),
		NINE(9,"9"),
		TEN(10,"10"),
		JACK(11,"J"),
		QUEEN(12,"Q"),
		KING(13,"K");		

		private final int _value;		
		private final String _symbol;
		
		Rank(int value, String symbol){
			this._value = value;
			this._symbol = symbol;
		}
		String getSymbol(){
			return this._symbol;
		}
		int getValue(){
			return this._value;
		}
	}

	class Card{
		private Rank _rank;
		private Suit _suit;
		// private int _suit;

		private Card(Rank rank, Suit suit){
			this._rank = rank;
			this._suit = suit;			
		}
		
		// private Card(int rank, int suit){
		// 	this._rank = rank;
		// 	this._suit = suit;
		// }
		
		String getSuitSymbol(){
			return this._suit.getSymbol();
		}
		
		// int getSuit(){
		// 	return this._suit.getValue();
		// }
		
		String getRankSymbol(){
			return this._rank.getSymbol();
		}
		
		// int getRank(){
		// 	return this._rank.getValue();
		// }

	}
	
	private ArrayList<Card> _cardSet = new ArrayList<>(52);	
	// private int[][] cards = new int[52][2];

	Cards(){
		for (Suit suit : Suit.values()){
			for (Rank rank : Rank.values()){
				_cardSet.add(new Card(rank, suit));
			}		
			
		}
	}


	// Cards(){
	// 	for (int j = 0; j < 4; j++){
	// 		for (int i = 1; i <= 13; i++){
	// 			cardSet.add(new Card(i, j));
	// 		}
	// 	}
	// }
	
	// public void init(){
	// 	for (int i = 1; i <= 13; i++){
	// 		for (int j = 0; j < 4; j++){
	// 			cards[i - 1 + 13 * j][0] = i;
	// 			cards[i - 1 + 13 * j][1] = j;
	// 		}
	// 	}
	// }
	
	public void shuffle(){
		// Random random = new Random();
		// for (int i = 0; i < 52; i++){
		// 	int r = random.nextInt(52 - i);
		// 	int[] temp = cards[r];
		// 	cards[r] = cards[i];
		// 	cards[i] = temp;
		// }

		Random random = new Random();
		for (int i = 0; i < 52; i++){
			int r = random.nextInt(52 - i);
			// System.out.println(r);
			
			Card temp = _cardSet.get(r);
			this._cardSet.remove(r);
			this._cardSet.add(temp);
		}
	}
	public void printAll(){
		// for (int i = 0; i < 52; i++){
		// 	System.out.println(_num2rank(cards[i][0]) + " : " + _num2suit(cards[i][1]));
		// 	if (i % 13 == 12) System.out.println("");
		// }
		
		for (int i = 0; i < 52; i++){
			System.out.println(this._cardSet.get(i).getRankSymbol() + " : " + this._cardSet.get(i).getSuitSymbol());
			// System.out.println(_num2rank(this._cardSet.get(i).getRank()) + " : " + _num2suit(this._cardSet.get(i).getSuit()));
			if (i % 13 == 12) System.out.println("");
		}

		// cardSet.forEach(
		//  	(card) -> {
		// 		System.out.println( _num2rank(card.getRank()) + " : " + _num2suit(card.getSuit()) );
		// 	}
		// );		
	}

	// private String _num2suit(int j){
	// 	if (j == 0) return Suit.SPADE.getSymbol();
	// 	if (j == 1) return Suit.HEART.getSymbol();
	// 	if (j == 2) return Suit.DIAMOND.getSymbol();
	// 	return Suit.CLOVER.getSymbol();
	// };
	//
	// private String _num2rank(int i){
	// 	if (i == 1) return "A";
	// 	if (i == 2) return "2";
	// 	if (i == 3) return "3";
	// 	if (i == 4) return "4";
	// 	if (i == 5) return "5";
	// 	if (i == 6) return "6";
	// 	if (i == 7) return "7";
	// 	if (i == 8) return "8";
	// 	if (i == 9) return "9";
	// 	if (i == 10) return "10";
	// 	if (i == 11) return "J";
	// 	if (i == 12) return "Q";
	// 	return "K";
	// }
}