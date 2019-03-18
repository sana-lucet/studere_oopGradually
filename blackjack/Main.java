import java.util.Random;

class Main {			
	private static String SPADE = "♠";
	private static String HEART = "♥";
	private static String DIAMOND = "♦";
	private static String CLOVER = "♣";
	private static int[][] cards = new int[52][2];

	public static void main(String[] args){
		init();
		// printlnAll();
		shuffle();
		printAll();
	}
	static String num2suit(int j){
		if (j == 0) return SPADE;
		if (j == 1) return HEART;
		if (j == 2) return DIAMOND;
		return CLOVER;
	};
	static String num2rank(int i){
		if (i == 0) return "ACE";
		if (i == 1) return "TWO";
		if (i == 2) return "THREE";
		if (i == 3) return "FOUR";
		if (i == 4) return "FIVE";
		if (i == 5) return "SIX";
		if (i == 6) return "SEVEN";
		if (i == 7) return "EIGHT";
		if (i == 8) return "NINE";
		if (i == 9) return "TEN";
		if (i == 10) return "JACK";
		if (i == 11) return "QUEEN";
		return "KING";
	}
	static void init(){
		for (int i = 0; i < 13; i++){
			for (int j = 0; j < 4; j++){
				cards[i + 13 * j][0] = i;
				cards[i + 13 * j][1] = j;
			}
		}
	}	
	static void shuffle(){
		Random random = new Random();
		for (int i = 0; i < 52; i++){
			int r = i + random.nextInt(52 - i);
			int[] temp = cards[r];
			cards[r] = cards[i];
			cards[i] = temp;
		}
	}
	static void printAll(){
		for (int i = 0; i < 52; i++){
			System.out.println(num2rank(cards[i][0]) + " : " + num2suit(cards[i][1]));
			if (i % 13 == 12) System.out.println("");
		}
	}
}