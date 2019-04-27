package lotto;

import lotto.controller.Lotto;
import lotto.view.Viewer;

public class Main {

    public static void main(String[] args) {
        Viewer viewer = new Viewer();

        Lotto winningBox = new Lotto("winningBox", viewer);
        winningBox.draw();
        winningBox.printLotto();

        Lotto ticket = new Lotto("ticket", viewer);
        ticket.draw();
        ticket.printLotto();

        ticket.printMatchResult(winningBox);
    }
}

