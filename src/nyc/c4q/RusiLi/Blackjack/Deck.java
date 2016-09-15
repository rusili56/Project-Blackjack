package nyc.c4q.RusiLi.Blackjack;

import nyc.c4q.RusiLi.Utility.Print;

import java.util.ArrayList;

public class Deck {
    ArrayList<Cards> cardsArrayList = new ArrayList<>();
    //public Cards[] cards = new Cards[53];
    int i = 1;
    int itimesDrawn = 0;

    public Deck() {
        this.cardsArrayList.add(new Cards(null, 0));

        for (Cards.Suit suit : Cards.Suit.values()) { //Enhanced "For" Loop
            for (int j = 1; j <= 13; j++) {
                this.cardsArrayList.add(new Cards(suit, j));
                i++;
            }
        }
    }

    public Cards drawCard(int input) {

        Cards tempCard = new Cards(cardsArrayList.get(input).getCardSuit(), cardsArrayList.get(input).getInputValue());
        this.cardsArrayList.remove(input); // third card, not third in input!!
        itimesDrawn++;

        return tempCard;
    }

    public int TimesDrawn() {
        return itimesDrawn;
    }

    public void printAll(Deck dInput) {
        for (int i = 0; i < dInput.cardsArrayList.size(); i++) {
            Print.pln(String.format("%s of %s", cardsArrayList.get(i).getInputValue(), cardsArrayList.get(i).getCardSuit()));
        }
    }

}
