package nyc.c4q.RusiLi;

import java.util.ArrayList;

/**
 * Created by rusili on 8/31/16.
 */
public class Deck {
    ArrayList<Cards> cardsArrayList = new ArrayList<Cards>();
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
            Cards tempCard = new Cards(cardsArrayList.get(i).getCardSuit(), cardsArrayList.get(i).getInputValue());

            Print.pln(String.format("%s of %s", cardsArrayList.get(i).getInputValue(), cardsArrayList.get(i).getCardSuit()));
        }
    }

}
