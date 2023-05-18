package org.example;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }
    public int calculatedValue(){
        //variable to count number of aces, and current total value
        int value = 0;
        int aceCount = 0;
        //For each card in this hand
        for(Card card: hand){
            //Add the card value to the hand
            value += card.getValueValues();
            //Count how many aces have been added
            if (card.getValueValues() == 11){
                aceCount ++;
            }
        }
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }
        return value;
    }
    public Card getCard(int idx){
        return hand.get(idx);
    }
    public void discardHandToDeck(Deck discardDeck){
        //copy cards from hand to discardDeck
        discardDeck.addCards(hand);
        hand.clear();
    }
}
