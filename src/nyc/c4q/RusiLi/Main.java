package nyc.c4q.RusiLi;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scInput = new Scanner(System.in);
        Random randomGenerator = new Random();
        boolean loop = true;
        int iDealerWins = 0;
        int iPlayerWins = 0;
        int iTies = 0;

        while (loop) {

            Deck deck1 = new Deck();

            // Dealer draw:
            Cards[] dealerCards = new Cards[4];
            Cards temp = new Cards(null, 0);
            String sUserInput;
            int iDealerTotal;
            int iPlayerCards;

            dealerCards[0] = deck1.drawCard(0);
            dealerCards[1] = deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn()));
            dealerCards[2] = deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn()));
            iDealerTotal = dealerCards[1].getFinalValue() + dealerCards[2].getFinalValue();

            Draw draw = new Draw();
            draw.printCard(1, dealerCards);

            if (iDealerTotal == 21) {
                Print.pln("Dealer got Blackjack!");
            }

            // Player draw:
            ArrayList<Cards> pCard = new ArrayList<>();

            pCard.add(deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn())));
            pCard.add(deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn())));
            int iPlayerTotal = pCard.get(0).getFinalValue() + pCard.get(1).getFinalValue();
            iPlayerCards = 2;

            draw.printCard(1, pCard);

            Print.pln("Please press Enter:");
            scInput.nextLine();

            temp = dealerCards[2];
            dealerCards[2] = dealerCards[0];
            draw.printCard(2, dealerCards); // hole Card is face down
            draw.printCard(2, pCard);
            dealerCards[2] = temp;

            // while loop
            while (iPlayerTotal < 21 && iDealerTotal < 21) {

                Print.pln("What do you want to do? Stand or Hit?:" + "\n");
                sUserInput = scInput.nextLine();
                if (sUserInput.equalsIgnoreCase("stand")) {
                    if (iDealerTotal < 16) {
                        dealerCards[3] = deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn()));
                        draw.printCard(3, dealerCards);
                        iDealerTotal += dealerCards[3].getFinalValue();
                    } else {
                        draw.printCard(2, dealerCards);
                    }
                    draw.printCard(iPlayerCards, pCard);
                    break;
                } else if (sUserInput.equalsIgnoreCase("hit")) {
                    pCard.add(deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn())));
                    iPlayerCards++;
                    iPlayerTotal += pCard.get(iPlayerCards - 1).getFinalValue();
                    if (iDealerTotal < 16) {
                        dealerCards[3] = deck1.drawCard(randomGenerator.nextInt(52 - deck1.TimesDrawn()));
                        draw.printCard(3, dealerCards);
                        iDealerTotal += dealerCards[3].getFinalValue();
                    } else {
                        draw.printCard(2, dealerCards);
                    }
                    draw.printCard(iPlayerCards, pCard);
                } else {
                    Print.pln("Please choose Stand or Hit" + "\n");
                }

            }

            if (iDealerTotal > 21 || iPlayerTotal == 21) {
                Print.pln("Player wins!" + "\n");
                iPlayerWins++;

            } else if (iPlayerTotal > 21 || iDealerTotal == 21) {
                Print.pln("Dealer wins!" + "\n");
                iDealerWins++;
            } else {
                if (iPlayerTotal > iDealerTotal) {
                    Print.pln("Player wins!" + "\n");
                    iPlayerWins++;
                } else if (iPlayerTotal < iDealerTotal) {
                    Print.pln("Dealer wins!" + "\n");
                    iDealerWins++;
                } else {
                    Print.pln("Tie!" + "\n");
                    iTies++;
                }
            }

            Print.pln("Would you like to play again? (y/n:)");
            sUserInput = scInput.nextLine();
            Print.pln("\n");

            if (sUserInput.equalsIgnoreCase("y") || sUserInput.equalsIgnoreCase("yes")) {
                Print.pln("Player: " + iPlayerWins + " || Dealer: " + iDealerWins + " || Ties: " + iTies + "\n");
                loop = true;
            } else if ((sUserInput.equalsIgnoreCase("n") || sUserInput.equalsIgnoreCase("no"))) {
                Print.pln("Thanks for playing!");
                loop = false;
            }
        }

    }
}
