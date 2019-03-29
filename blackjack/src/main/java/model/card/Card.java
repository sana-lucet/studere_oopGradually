package model.card;

public class Card{
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuitSymbol(){
        return this.suit.getSymbol();
    }

    public String getRankSymbol(){
        return this.rank.getSymbol();
    }

    public int getPoint() {
        return this.rank.value;
    }

    enum Suit{
        SPADE(0,"♠"),
        HEART(1,"♥"),
        DIAMOND(2,"♦"),
        CLOVER(3,"♣");

        private final int value;
        private final String symbol;

        Suit(int value, String symbol){
            this.value = value;
            this.symbol = symbol;
        }
        String getSymbol(){
            return this.symbol;
        }
        int getValue(){
            return this.value;
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
        JACK(10,"J"),
        QUEEN(10,"Q"),
        KING(10,"K");

        private final int value;
        private final String symbol;

        Rank(int value, String symbol){
            this.value = value;
            this.symbol = symbol;
        }
        String getSymbol(){
            return this.symbol;
        }
        int getValue(){
            return this.value;
        }
    }
}
