package lotto;

import lotto.controller.Lotto;
import lotto.view.LotteryEventListener;
import lotto.model.Ball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LottoTest {
    private Lotto box;
    private Lotto ticket;
    private LotteryEventListener listener = Mockito.mock(LotteryEventListener.class);

    @BeforeEach public void
    setUp(){
        box = new Lotto("winningBox", listener);
        ticket = new Lotto("winningBox", listener);
    }

    @Test
    public void
    drawSixBalls(){
        box.draw();
        assertThat(box.getBalls()).hasSize(6);
    }

    @Test public void
    countMatchingBallsBetweenWinningBoxAndTicket(){
        box = new Lotto("winningBox", listener){
            @Override
            public void draw(){
//                1, 3, 5, 7, 9, 11
                for (int i = 0; i < 6; i++){
                    this.addBall(new Ball(2 * i + 1));
                }
            }
        };
        box.draw();

        ticket = new Lotto("winningBox", listener){
            @Override
            public void draw() {
//                3, 6, 9, 12, 15, 18
                for (int i = 0; i < 6; i++) {
                    this.addBall(new Ball(3 * (i + 1)));
                }
            }
        };
        ticket.draw();

        assertThat(ticket.countMatch(box)).isEqualTo(2);
    }
    @Test public void
    lottoResultAnnouncedAfterBoxDrawn(){
        box.draw();
        verify(listener, times(1)).lottoDrawnAnnounced(any(), anyString());
    }

}