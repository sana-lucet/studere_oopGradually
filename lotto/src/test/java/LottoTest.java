import lotto.Lotto;
import lotto.view.Viewer;
import lotto.model.Ball;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto box;
    private Lotto ticket;
    private Viewer dummy;

    @Before public void
    setUp(){
        box = new Lotto(dummy);
        ticket = new Lotto(dummy);
    }

    @Test public void
    drawSixBalls(){
        box.draw();
        assertThat(box.balls).hasSize(6);
    }

    @Test public void
    countMatchingBallsBetweenWinningBoxAndTicket(){
        box = new Lotto(dummy){
            @Override
            public void draw(){
//                1, 3, 5, 7, 9, 11
                for (int i = 0; i < 6; i++){
                    balls.add(new Ball(2 * i + 1));
                }
            }
        };
        box.draw();

        ticket = new Lotto(dummy){
            @Override
            public void draw() {
//                3, 6, 9, 12, 15, 18
                for (int i = 0; i < 6; i++) {
                    balls.add(new Ball(3 * (i + 1)));
                }
            }
        };
        ticket.draw();

        assertThat(ticket.countMatch(box)).isEqualTo(2);
    }

}