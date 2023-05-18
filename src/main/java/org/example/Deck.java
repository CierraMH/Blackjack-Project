package org.example;
import java.util.ArrayList;

public class Deck {
    public ArrayList<Card> getCards() {
        return deck;
    }
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }
    public Card getCard(int i){
        return this.deck.get(i);
    }
    public Deck(boolean makeDeck){
            deck = new ArrayList<Card>();
            if(makeDeck){
                //Go through all the suits
                for(Suits suit : Suits.values()){
                    //Go through all the ranks
                    for(Values value : Values.values()){
                        //add a new card containing each iterations suit and rank
                        deck.add(new Card(suit, value));
                    }
                }
            }
        }
    public void shuffleDeck(){
        ArrayList<Card> shuffleDeck = new ArrayList<Card>();
        //iterate through the size of the deck, so each card can be pulled
        while(deck.size()>0){
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            //Add this random card to the new shuffled deck
            shuffleDeck.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffleDeck;
    }
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public void addCard(Card addCard) {
        this.deck.add(addCard);
    }
    //adds all card together
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }
    public Card takeCard(){
        //Take a copy of the first card from the deck
        Card cardToTake = new Card(deck.get(0));
        //Remove the card from the deck
        deck.remove(0);
        //Give the card back
        return cardToTake;
    }
    //clear the deck
    public void emptyDeck(){
        deck.clear();
    }
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffleDeck();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
        System.out.println("");
    }
    public String toString(){
        String output = "";
        for (Card card : deck) {
            output += card;
            output+= "\n";
        }
        return output;
    }
    public int cardsLeft(){
        return deck.size();
    }

}
