package nyc.c4q.RusiLi.Blackjack;

import java.util.ArrayList;

public class Cards extends ArrayList<Cards> {
    public final String[] Value = {"J", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    Suit cardSuit;
    enumValue cardenumValue;
    String cardValue;
    int inputValue;

    public Cards(Suit inputSuit, int input){
        this.cardSuit = inputSuit;

        this.cardValue = Value[input];
        inputValue = input;
    }

    public enumValue getCardenumValue() { return this.cardenumValue; }

    public String getCardValue() { return this.cardValue; }

    public Suit getCardSuit() { return cardSuit; }

    public int getBlackJackValue(){
        if (inputValue > 10){
            return 10;
        } else {
            return inputValue;
        }
    }

    public int getInputValue() {
        return inputValue;
    }

    public enum Suit{ //Get ascii characters
        Clubs, Diamonds, Hearts, Spades
    }

    public enum enumValue{
        Joker, Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

}
