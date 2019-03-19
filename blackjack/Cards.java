import java.util.Random;
import java.util.ArrayList;

class Cards{		
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