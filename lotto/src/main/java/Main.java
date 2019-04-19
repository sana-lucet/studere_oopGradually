import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====drawBox======");
        Box box = new Box();
        for (int i = 0; i < 6; i++){
            box.draw();
        }
        int count = 0;
        for (Ball ball : box.balls){
            count++;
            System.out.println("counter:" + count + "\t" + ball);
        }
//        System.out.println("\n=====ticketBox=====");
//        Box ticket = new Box();
//        for (int i = 0; i < 6; i++){
//            ticket.draw();
//        }
//
//        for (Ball ball : ticket.balls){
//            System.out.println(ball);
//        }
    }
}

class Box{
    private int counter = 0;
    Ball[] balls = new Ball[6];
    Random random = new Random();

    public void draw() {
        Ball ball;
        if (!isDuplicate(ball = new Ball(random.nextInt(45) + 1))) {
            balls[counter] = ball;
            counter++;
        }
    }

    private boolean isDuplicate(Ball newBall) {
        boolean result = false;
        for (int i = 0; i < counter; i++){
            if (balls[i].equals(newBall)){
                result = true;
            }
        }
        return result;
    }
}

class Ball{
    int number;
    Ball(int number){
        this.number = number;
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
