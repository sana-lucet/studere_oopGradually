package lotto.view;

import java.util.ArrayList;

public class Viewer{
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
