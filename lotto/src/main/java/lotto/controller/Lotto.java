package lotto.controller;

import lotto.view.LotteryEventListener;
import lotto.model.Ball;

import java.util.ArrayList;

public class Lotto{
    private final LotteryEventListener viewer;
    private final String lottoType;
    ArrayList<Ball> balls = new ArrayList<Ball>();

    public Lotto(String lottoType, LotteryEventListener viewer) {
        this.viewer = viewer;
        this.lottoType = lottoType;
    }

    public void draw() {
        while (this.balls.size() < 6) {
            Ball newBall = Ball.GET();
            if (this.balls.contains(newBall)){
                continue;
            }
            this.addBall(newBall);
        }
        printLotto();
    }

    public int countMatch(Lotto lotto) {
        ArrayList<Ball> result = (ArrayList<Ball>) balls.clone();
        result.retainAll(lotto.balls);
        return result.size();
    }

    public void printMatchResult(Lotto box) {
        int matchCount = this.countMatch(box);
        this.viewer.lottoResultAnnounced(matchCount);
    }

    public ArrayList<Ball> getBalls() {
        return this.balls;
    }

    public void addBall(Ball newBall) {
        this.balls.add(newBall);
    }

    public void printLotto() {
        ArrayList<String> str = new ArrayList<String>();
        for (Ball ball : this.balls) {
            str.add(ball.toString());
        }
        this.viewer.lottoDrawnAnnounced(str, this.lottoType);
    }
}
