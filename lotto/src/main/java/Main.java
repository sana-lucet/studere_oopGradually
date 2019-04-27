import java.util.ArrayList;
import java.util.Random;

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

class Lotto{
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

class Viewer{
    public void printBalls(ArrayList<String> strArr, String type) {
        if (type == "winningBox") System.out.println("=====drawBox======");
        if (type == "ticket") System.out.println("=====ticketBox=====");
        for (String str : strArr){
            System.out.println(str);
        }
        System.out.print("\n");
    }

    public void printResult(int matchCount) {
        System.out.println("======result=======");
        System.out.println(matchCount);
    }
}