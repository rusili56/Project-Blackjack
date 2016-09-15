package nyc.c4q.RusiLi.Draw;

import nyc.c4q.RusiLi.Blackjack.Cards;
import nyc.c4q.RusiLi.Utility.Print;

import java.util.ArrayList;

public class Draw {

    public Draw() {
    }

    public void drawDealertop() {
        System.out.println("\n" + " Dealer ");
        Animation.stop(1);
    }

    public static void drawDealerbottom() {
        System.out.println("_________" + "\n");
    }

    public static void drawPlayertop() {
        System.out.println(" Player ");
        Animation.stop(1);
    }

    public static void drawPlayerbottom() {
        System.out.println("\n");
    }

    // Dealer Draw: Array
    public void printCard(int pnum, Cards[] inputCard) {

        this.drawDealertop();

        // Top Line
        for (int i = 0; i < pnum; i++) {
            Print.p('\u250F'); // Top Left
            for (int j = 0; j < 7; j++) {
                Print.p('\u2501');
            }
            Print.p('\u2513'); // Top Right
            Print.p("     ");
        }
        Print.p("\n");

        // Value Line 1
        for (int i = 1; i <= pnum; i++) {
            if (inputCard[i].getInputValue() == 0) {
                Print.p('\u2503');
                Print.p("       " + '\u2503');  // Down
            } else if (inputCard[i].getInputValue() != 10) {
                Print.p('\u2503');
                Print.p(inputCard[i].getCardValue() + "     " + inputCard[i].getCardValue() + '\u2503');  // Down
            } else if (inputCard[i].getInputValue() == 10) {
                Print.p('\u2503');
                Print.p(inputCard[i].getCardValue() + "   " + inputCard[i].getCardValue() + '\u2503');  // Down
            }
            Print.p("     ");
        }
        Print.p("\n");

        // Third Line
        for (int i = 1; i <= pnum; i++) {
            Print.p('\u2503' + "       " + '\u2503');  // Down
            Print.p("     ");
        }
        Print.p("\n");

        // Suit Line
        for (int i = 1; i <= pnum; i++) {
            Print.p('\u2503' + "   ");  // Down
            if (inputCard[i].getCardSuit() == Cards.Suit.Clubs) {
                Print.p('\u2663');
            } else if (inputCard[i].getCardSuit() == Cards.Suit.Diamonds) {
                Print.p('\u2666');
            } else if (inputCard[i].getCardSuit() == Cards.Suit.Hearts) {
                Print.p('\u2764');
            } else if (inputCard[i].getCardSuit() == Cards.Suit.Spades) {
                Print.p('\u2660');
            } else {
                Print.p(" ");
            }
            Print.p("   " + '\u2503');// Space
            Print.p("     ");
        }
        Print.p("\n");

        // Fifth Line
        for (int i = 1; i <= pnum; i++) {
            Print.p('\u2503' + "       " + '\u2503');  // Down
            Print.p("     ");
        }
        Print.p("\n");

        // Value Line 2
        for (int i = 1; i <= pnum; i++) {
            if (inputCard[i].getInputValue() == 0) {
                Print.p('\u2503');
                Print.p("       " + '\u2503');  // Down
            } else if (inputCard[i].getInputValue() != 10) {
                Print.p('\u2503');
                Print.p(inputCard[i].getCardValue() + "     " + inputCard[i].getCardValue() + '\u2503');  // Down
            } else if (inputCard[i].getInputValue() == 10) {
                Print.p('\u2503');
                Print.p(inputCard[i].getCardValue() + "   " + inputCard[i].getCardValue() + '\u2503');  // Down
            }
            Print.p("     ");
        }
        Print.p("\n");

        // Last Line
        for (int i = 1; i <= pnum; i++) {
            Print.p('\u2517'); // Bottom Left
            for (int j = 0; j < 7; j++) {
                Print.p('\u2501');
            }
            Print.p('\u251B'); // Bottom Right
            Print.p("     ");
        }
        Print.p("\n");

        drawDealerbottom();
    }

    // Player Draw: ArrayList
    public void printCard(int pnum, ArrayList<Cards> inputCard) {

        drawPlayertop();

        // Top Line
        for (int i = 0; i < pnum; i++) {
            Print.p('\u250F'); // Top Left
            for (int j = 0; j < 7; j++) {
                Print.p('\u2501');
            }
            Print.p('\u2513'); // Top Right
            Print.p("     ");
        }
        Print.p("\n");

        // Value Line 1
        for (int i = 0; i < pnum; i++) {
            if (inputCard.get(i).getInputValue() != 10) {
                Print.p('\u2503');
                Print.p(inputCard.get(i).getCardValue() + "     " + inputCard.get(i).getCardValue() + '\u2503');  // Down
            } else {
                Print.p('\u2503');
                Print.p(inputCard.get(i).getCardValue() + "   " + inputCard.get(i).getCardValue() + '\u2503');  // Down
            }
            Print.p("     ");
        }
        Print.p("\n");

        // Third Line
        for (int i = 0; i < pnum; i++) {
            Print.p('\u2503' + "       " + '\u2503');  // Down
            Print.p("     ");
        }
        Print.p("\n");

        // Suit Line
        for (int i = 0; i < pnum; i++) {
            Print.p('\u2503' + "   ");  // Down
            if (inputCard.get(i).getCardSuit() == Cards.Suit.Clubs) {
                Print.p('\u2663');
            } else if (inputCard.get(i).getCardSuit() == Cards.Suit.Diamonds) {
                Print.p('\u2666');
            } else if (inputCard.get(i).getCardSuit() == Cards.Suit.Hearts) {
                Print.p('\u2764');
            } else if (inputCard.get(i).getCardSuit() == Cards.Suit.Spades) {
                Print.p('\u2660');
            }
            Print.p("   " + '\u2503');// Space
            Print.p("     ");
        }
        Print.p("\n");

        // Fifth Line
        for (int i = 0; i < pnum; i++) {
            Print.p('\u2503' + "       " + '\u2503');  // Down
            Print.p("     ");
        }
        Print.p("\n");

        // Value Line 2
        for (int i = 0; i < pnum; i++) {
            if (inputCard.get(i).getInputValue() != 10) {
                Print.p('\u2503');
                Print.p(inputCard.get(i).getCardValue() + "     " + inputCard.get(i).getCardValue() + '\u2503');  // Down
            } else {
                Print.p('\u2503');
                Print.p(inputCard.get(i).getCardValue() + "   " + inputCard.get(i).getCardValue() + '\u2503');  // Down
            }
            Print.p("     ");
        }
        Print.p("\n");

        // Last Line
        for (int i = 0; i < pnum; i++) {
            Print.p('\u2517'); // Bottom Left
            for (int j = 0; j < 7; j++) {
                Print.p('\u2501');
            }
            Print.p('\u251B'); // Bottom Right
            Print.p("     ");
        }
        Print.p("\n" + "\n");

    }
}