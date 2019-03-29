package view.output;


import model.card.Card;
import model.player.Dealer;
import model.player.Player;
import model.player.User;

import java.util.ArrayList;

public class ConsoleRenderer implements Renderer, GameEventListener {
    private String[] strArr = new String[10];
    private String bnr;
    ArrayList<String> userArr, dealerArr;

    public ConsoleRenderer() {
        this.bnr = "";
        this.strArr[0] =  "   ┌────────────────────────┐";
        this.strArr[0] += "   ┌────────────────────────┐\n";
        this.strArr[0] += "   │ ┌────── player ──────┐ │";
        this.strArr[0] += "   │ ┌────── dealer ──────┐ │\n";
        this.strArr[1] =  "   │ │ total:  userTotal  │ │".replace("userTotal", String.format("%2s", "userTotal"));
        this.strArr[2] =  "   │ │ total:  dealerTotal│ │\n".replace("dealerTotal", String.format("%2s", "dealerTotal"));
        this.strArr[3] =  "   │ └────────────────────┘ │";
        this.strArr[3] += "   │ └────────────────────┘ │\n";
        this.strArr[3] += "   │                        │";
        this.strArr[3] += "   │                        │\n";
        this.strArr[4] =  String.format("   │        no cards        │");
        this.strArr[5] =  String.format("   │        no cards        │\n");
        this.strArr[6] =  "   │                        │";
        this.strArr[6] += "   │                        │\n";
        this.strArr[6] += "   │                        │";
        this.strArr[6] += "   │                        │\n";
        this.strArr[7] =  "   │     userMsg    │".replace("userMsg", String.format("%15s", ""));
        this.strArr[8] =  "   │     dealerMsg    │\n".replace("dealerMsg", String.format("%15s", ""));
        this.strArr[9] =  "   │                        │";
        this.strArr[9] += "   │                        │\n";
        this.strArr[9] += "   └────────────────────────┘";
        this.strArr[9] += "   └────────────────────────┘\n";
    }

    @Override
    public void updatePoints(Player player) {
        if (player instanceof User){
            this.strArr[1] = "   │ │ total:  userTotal  │ │".replace("userTotal", String.format("%2d       ", player.totalPoints()));
            this._render();
        } else if (player instanceof Dealer) {
            this.strArr[2] = "   │ │ total:  dealerTotal│ │\n".replace("dealerTotal", String.format("%2d         ", player.totalPoints()));
            this._render();
        }
    }

    public void updateTable(ArrayList<Card> userArr, ArrayList<Card> dealerArr) {
        String str = "   │ ";
        str += userArr
                .stream()
                .map((card) -> String.format("%4s", card.getRankSymbol() + card.getSuitSymbol() + " "))
                .reduce("", (a,b) -> a + b);
        str += "    ".repeat(5 - userArr.size()) +  "   │";

        this.strArr[4] = str;

        str = "   │ ";
        str += dealerArr
                .stream()
                .map((card) -> String.format("%4s", card.getRankSymbol() + card.getSuitSymbol() + " "))
                .reduce("", (a,b) -> a + b);
        str += "    ".repeat(5 - dealerArr.size()) + "   │\n";;

        this.strArr[5] = str;
    }

    public void updateMessage(String userMsg, String dealerMsg) {
        if (userMsg != ""){
            this.strArr[6] =  "   │                        │";
            this.strArr[6] += "   │                        │\n";
            this.strArr[6] += "   │  ===================   │";
            this.strArr[6] += "   │                        │\n";
            this.strArr[7]  = "   │    userMsg    │".replace("userMsg", String.format("%16s", userMsg));
            this.strArr[8] =  "   │     dealerMsg    │\n".replace("dealerMsg", String.format("%15s", ""));
            this.strArr[9]  = "   │  ===================   │";
            this.strArr[9] += "   │                        │\n";
            this.strArr[9] += "   └────────────────────────┘";
            this.strArr[9] += "   └────────────────────────┘\n";
        } else if (dealerMsg != ""){
            this.strArr[6] =  "   │                        │";
            this.strArr[6] += "   │                        │\n";
            this.strArr[6] += "   │                        │";
            this.strArr[6] += "   │  ===================   │\n";
            this.strArr[7] =  "   │     userMsg    │".replace("userMsg", String.format("%15s", ""));
            this.strArr[8]  = "   │    dealerMsg    │\n".replace("dealerMsg", String.format("%16s", dealerMsg));
            this.strArr[9]  = "   │                        │";
            this.strArr[9] += "   │  ===================   │\n";
            this.strArr[9] += "   └────────────────────────┘";
            this.strArr[9] += "   └────────────────────────┘\n";
        }

    }


    @Override
    public void gameStarted(){}

    @Override
    public void gameEnded(){}

    @Override
    public void roundStarted(int round) {
        ArrayList<Integer> arr = new ArrayList<Integer>(48);
        this.bnr  = new String(new char[54]).replace('\0', '■') + "\n";
        this.bnr += String.format("                    (Round :  %d  )                    \n", round);
        this.bnr += new String(new char[54]).replace('\0', '■') + "\n";

        for (int i = 0; i < 5; i++){
            System.out.println("");
        }

        System.out.println(this.bnr);

        for (int i = 0; i < 5; i++){
            System.out.println("");
        }

    }
    @Override
    public void roundEnded(int round, Player player) {}

    public void standRequested(Player actor) {
        this._render();
    }

    @Override
    public void _render() {
        for (String str : strArr){
            System.out.print(str);
        }
    }

    @Override
    public void _clearScreen(){
        for (int i = 0; i < 10; i++){
            System.out.println("");
        }
    }
//    private void _newRoundMessage(int round){
//        ArrayList<Integer> arr = new ArrayList<Integer>(48);
//        this.bnr += new String(new char[54]).replace('\0', '■') + "\n";
//        this.bnr += String.format("                    (Round :  %d  )                    \n", round);
//        this.bnr += new String(new char[54]).replace('\0', '■') + "\n";
//    }
//
//    private void _endRoundMessage(int round, Player player) {
//        this.bnr += String.format("(round :  %d  ) 라운드의 승자는 %s입니다.\n", round, player.toString());
//    }
}
