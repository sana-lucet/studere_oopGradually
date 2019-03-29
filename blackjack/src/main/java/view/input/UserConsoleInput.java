package view.input;

import controller.Game;

import java.util.Scanner;

public class UserConsoleInput implements UserPromptListener {
    private static final Scanner scanner = new Scanner(System.in);
    private final Game game;

    public UserConsoleInput(Game game) {
        this.game = game;
    }

    @Override
    public void promptBetting() {
        System.out.println("베팅 금액을 입력하시기 바랍니다");
        String input = scanner.next();
        System.out.println(input + "을 베팅하였습니다.");
    }

    @Override
    public void hitOrStandPrompted() {
        System.out.println("카드를 더 받습니까?");
        String input = scanner.next();
        if (input.toLowerCase().equals("y")) {
            this.game._userHitReponded();
            this.hitOrStandPrompted();
        } else if (input.toLowerCase().equals("n")){
            this.game.userStandResponded();
        }
//        System.out.println("┏━━━━━━━┓");
//        System.out.println("┃          ┃");
//        System.out.println("┗━━━━━━━┛");
    }
}
