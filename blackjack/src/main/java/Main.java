//import controller.Game;
//import view.output.ConsoleRenderer;

import controller.Game;
import model.card.Card;
import model.card.CardDeck;
import model.player.Dealer;
import model.player.Player;
import model.player.User;
import view.output.ConsoleRenderer;
import view.output.Renderer;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

//        CardDeck deck = CardDeck.getDeck();
//        Player dealer = new Dealer(deck);
//        dealer.hit();

//        Player user = new User(deck);
//        user.emptyHands();

//        Card card = deck.popCard();
//        System.out.println(card.getRankSymbol());

//        card.getRankSymbol();
//        System.out.println(cardSet);

//        System.out.println(cardSet.rank());
//        System.out.println(cardSet.suit());

        Renderer renderer = new ConsoleRenderer();
        Game game = new Game(renderer);
        game.startGame();



//        System.out.println("   │  ︎   userMsg     │".replace("userMsg", String.format("%15s", "userMsg")));

//        String str;
//        str =  String.format("   │ │ total:  %2s         │ │", "userTotal");
//        str += String.format("   │ │ total:  %2s         │ │\n", "dealerTotal");
//        System.out.println(str.replace("userTotal", "21").replace("dealerTotal", "20"));

//        String top = "│ │ total:  21         │ │  │ │ total:  20         │ │\n";

//        System.out.println(top);

//        System.out.println(topf.contains("total:  %2s"));
//        System.out.printf(topf, String.valueOf(1), String.valueOf(22));

//        Formatter f = new Formatter(System.out);
//        f.format("│ │ total:  %2s         │ │  │ │ total:  %2s         │ │\n", String.valueOf(31), String.valueOf(1));
//        f.format("│ │ total:  %2s         │ │  │ │ total:  %2s         │ │\n", String.valueOf(31), String.valueOf(1));


//        game.startRound();
//        game._userHitReponded();
//        game._dealerHitResponded();
//        game._userHitReponded();
//        game._dealerHitResponded();
//        game.promptHitOrStand();
//        String input = scanner.next();
//        System.out.println(input + "을 입력하셨습니다");
    }
}
