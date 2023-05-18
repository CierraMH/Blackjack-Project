package org.example;
import java.util.Scanner;

public class Player extends Person{
    Scanner input = new Scanner(System.in);
    public Player() {
       super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discard){

        int  decision = 0;
        boolean getNum = true;

        //while were getting a number...
        while(getNum){
            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                if (decision == 1 || decision == 2){
                    getNum = false;
                } else {
                    throw new Exception("Error");
                }
            }
            catch(Exception e){
                System.out.println("Invalid...");
                if (e.getMessage() != "Error")
                input.next();
            }
        }
        //if they decide to hit
        if (decision == 1) {
            //hit the deck using the deck and discard deck
            this.hit(deck, discard);
            //return (exit the method) if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }else{
                this.makeDecision(deck, discard);
            }
        } else {
            System.out.println("You stand!");
        }
 }
}
