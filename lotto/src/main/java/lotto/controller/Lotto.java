package lotto.controller;

import lotto.view.Viewer;
import lotto.model.Ball;

import java.util.ArrayList;

public class Lotto{
    private final Viewer viewer;
    ArrayList<Ball> balls = new ArrayList<Ball>();

    public Lotto(Viewer viewer) {
        this.viewer = viewer;
    }

    public void draw() {
        while (this.balls.size() < 6) {
            Ball newBall = Ball.GET();
            if (this.balls.contains(newBall)){
                continue;
            }
            balls.add(newBall);
        }
    }

    public int countMatch(Lotto lotto) {
        ArrayList<Ball> result = (ArrayList<Ball>) balls.clone();
        result.retainAll(lotto.balls);
        return result.size();
    }

    public void printLotto(String type){
        ArrayList<String> str = new ArrayList<String>();
        for (Ball ball : this.balls) {
            str.add(ball.toString());
        }
        this.viewer.printBalls(str, type);
    }

    public void printMatchResult(Lotto box) {
        int matchCount = this.countMatch(box);
        this.viewer.printResult(matchCount);
    }
}
