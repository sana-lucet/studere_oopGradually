import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        for (int i = 0; i < 6; i++){
            box.draw();
        }
        for (Ball ball : box.balls){
            System.out.println(ball);
        }
    }
}

class Box{
    private int counter = 0;
    Ball[] balls = new Ball[6];
    Random random = new Random();

    public void draw() {
        balls[counter] = new Ball(random.nextInt(45) + 1);
        counter++;
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
