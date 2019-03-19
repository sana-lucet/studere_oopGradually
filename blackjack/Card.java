class Card{
	private Rank _rank;
	private Suit _suit;
	// private int _suit;

	public Card(Rank rank, Suit suit){
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