package lotto;

import lotto.controller.Lotto;
import lotto.view.Viewer;

public class Main {

    public static void main(String[] args) {
        Viewer viewer = new Viewer();

        Lotto winningBox = new Lotto(viewer);
        winningBox.draw();
        winningBox.printLotto("winningBox");

        Lotto ticket = new Lotto(viewer);
        ticket.draw();
        ticket.printLotto("ticket");

        ticket.printMatchResult(winningBox);
    }
}

