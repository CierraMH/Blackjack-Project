package org.example;

public class Dealer extends Person{
    public Dealer(){
        //Name the dealer "Dealer"
        super.setName("Dealer");
    }
    //prints the dealer first card while the other is face down
    public void printFirstHand(){
        System.out.println("The dealer's hand:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The dealer's second card is face down.");
    }
}
