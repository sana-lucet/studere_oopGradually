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
