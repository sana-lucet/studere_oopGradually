package view.output;

import model.card.Card;
import model.player.Player;
import java.util.ArrayList;

public interface GameEventListener {
    void gameStarted();
    void gameEnded();
    void roundStarted(int round);
    void roundEnded(int round, Player player);
    void updatePoints(Player actor);
    void updateMessage(String userMsg, String dealerMsg);
    void updateTable(ArrayList<Card> userHand, ArrayList<Card> dealerHand);
}
