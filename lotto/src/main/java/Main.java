import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Ball[] balls = new Ball[6];
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            balls[i] = new Ball(random.nextInt(45) + 1);
        }
        for (Ball ball : balls){
            System.out.println(ball);
        }

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
}
