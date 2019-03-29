package controller;

import model.card.CardDeck;
import model.player.Dealer;
import model.player.Player;
import model.player.User;
import view.input.UserPromptListener;
import view.input.UserConsoleInput;
import view.output.Renderer;

import java.io.IOException;

public class Game implements UserInputListener {
    private CardDeck deck = CardDeck.getDeck();
    private Player dealer = new Dealer(deck), user = new User(deck);
    private int round = 1;
    private final UserPromptListener userinput = new UserConsoleInput(this);
    private final Renderer renderer;

    public Game(Renderer renderer){
        this.renderer = renderer;
    }

    public void startGame() {
        this.renderer.gameStarted();
        this.startRound();
    }
    public void startRound(){
        this.renderer.roundStarted(this.round);

        this.user.emptyHands();
        this.dealer.emptyHands();

        drawCard(user);
        drawCard(dealer);

        drawCard(user);
        drawCard(dealer);

        this.promptHitOrStand();
    }

    private void drawCard(Player player) {
        if (player instanceof User){
            this.renderer._clearScreen();
            this.renderer.updateMessage("drawing new card", "");
            this.user.hit();
            this.renderer.updateTable(user.getHand(), dealer.getHand());
            this.renderer.updatePoints(user);
        } else if (player instanceof Dealer){
            this.renderer._clearScreen();
            this.renderer.updateMessage("", "drawing new card");
            this.dealer.hit();
            this.renderer.updateTable(user.getHand(), dealer.getHand());
            this.renderer.updatePoints(dealer);
        }
    }

    public void endRound(){
        this.renderer.roundEnded(this.round, this.user);
        this.round++;
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.startRound();
    }
    public void endGame(){
        this.renderer.gameEnded();
    }
    public void promptHitOrStand(){
        this.userinput.hitOrStandPrompted();
    }

    public void _userHitReponded(){
        drawCard(user);
    }
    public void _dealerHitResponded() {
        this.dealer.hit();
    }
    public void userStandResponded() {
//        if (this.user.totalPoints() >= this.dealer.totalPoints()){
//            System.out.println("유저가 이겼습니다");
//        }
//        this.endRound();
    }

}
