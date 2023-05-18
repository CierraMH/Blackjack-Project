package org.example;

public class Card {
    private Suits suit;
    private Values value;

    public Card(Card card) {
        this.value = card.getValues();
        this.suit = card.getSuits();
    }

    public Card(Suits suit, Values value) {
        this.value = value;
        this.suit =suit;
    }

    public int getValueValues(){
        return value.valueValues;
    }
    public Values getValues() {
        return this.value;
    }
    public Suits getSuits() {
        return this.suit;
    }

    public String toString() {
        return ("[" + this.value + " of " + this.suit + "](" + this.getValueValues() + ")");
    }
}
