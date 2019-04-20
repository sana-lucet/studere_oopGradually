import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====drawBox======");

        Box box = new Box();
        box.draw();

        for (Ball ball : box.balls){
            System.out.println(ball);
        }

        Box ticket = new Box();
        ticket.draw();

        System.out.println("\n=====ticketBox=====");

        for (Ball ball : ticket.balls){
            System.out.println(ball);
        }
        System.out.println("\n======result=======");

        ArrayList<Ball> intersection = ticket.intersect(box);

        for (Ball ball : intersection) {
            System.out.println(ball);
        }
    }
}

class Box{
    private int counter = 0;
    ArrayList<Ball> balls = new ArrayList<Ball>();
    Ball newBall = null;
    public void draw() {
        while (counter < 6) {
            newBall = Ball.GET();
            if (!isDuplicate(newBall)){
                balls.add(newBall);
                counter++;
            } else {
                continue;
            };
        }
    }

    private boolean isDuplicate(Ball newBall) {
        boolean result = false;
        for (int i = 0; i < counter; i++){
            if (balls.get(i).number == newBall.number){
                result = true;
            }
        }
        return result;
    }

    public ArrayList<Ball> intersect(Box box) {
        ArrayList<Ball> result = (ArrayList<Ball>) balls.clone();
        for (int i = result.size() - 1; i >= 0; i--) {
            if (box.balls.contains(result.get(i))) {
                continue;
            } else {
                result.remove(result.get(i));
            }
        }
        return result;
    }
}

class Ball{
    int number;
    static Random random = new Random();
    Ball(int number){
        this.number = number;
    }

    public static Ball GET(){
        int rnum;
        rnum = random.nextInt(45) + 1;
        return new Ball(rnum);
    }

    @Override
    public String toString() {
        return "ball number: " + this.number;
    }

    public boolean equals(Object obj) {
        Ball ball = (Ball) obj;
        if (this.number == ball.number) {
            return true;
        }
        return false;
    }
}
