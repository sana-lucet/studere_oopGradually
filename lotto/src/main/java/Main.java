import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Lotto winningBox = new Lotto();
        winningBox.draw();
        printer.printBalls(winningBox, "=====drawBox======");

        Lotto ticket = new Lotto();
        ticket.draw();
        printer.printBalls(ticket, "=====ticketBox=====");

        System.out.println("======result=======");
        System.out.println(ticket.countMatch(winningBox));
    }
}

class Lotto{
    ArrayList<Ball> balls = new ArrayList<Ball>();
    public void draw() {
        while (balls.size() < 6) {
            Ball newBall = Ball.GET();
            if (balls.contains(newBall)){
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
}

class Ball{
    int num;
    static Random random = new Random();
    Ball(int num){
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

class Printer{
    public void printBalls(Lotto lotto, String string){
        System.out.println(string);
        for (Ball ball : lotto.balls){
            System.out.println(ball.toString());
        }
        System.out.println("\n");
    }
}