package lotto.model;

import java.util.Random;

public class Ball{
    int num;
    static Random random = new Random();
    public Ball(int num){
        this.num = num;
    }

    public static Ball GET(){
        int rnum;
        rnum = random.nextInt(45) + 1;
        return new Ball(rnum);
    }

    @Override
    public String toString() {
        return "ball number: " + this.num;
    }

    public boolean equals(Object obj) {
        Ball ball = (Ball) obj;
        if (this.num == ball.num) {
            return true;
        }
        return false;
    }
}
