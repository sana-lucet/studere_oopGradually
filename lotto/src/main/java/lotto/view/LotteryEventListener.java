package lotto.view;

import java.util.ArrayList;

public interface LotteryEventListener {
    void lottoDrawnAnnounced(ArrayList<String> strArr, String type);
    void lottoResultAnnounced(int matchCount);
}
