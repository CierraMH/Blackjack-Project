package org.example;

public class Game {
    // Create variables used by the Game class
    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    public Game(int wins, int losses, int pushes) {
        this.wins = 0;
        this.losses = 0;
        this.pushes = 0;
    }

    public Game() {

        // Create a new deck with 52 cards
        deck = new Deck(true);
        // Create a new empty deck
        discarded = new Deck();

        // Create the People
        dealer = new Dealer();
        player = new Player();

        // Shuffle the deck and start the first round
        deck.shuffleDeck();
        startRound();
    }

    // This method will handle the logic for each round
    private void startRound() {
        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }
        // Check to make sure the deck has at least 4 cards left
        if (deck.cardsLeft() < 4) {
            deck.reloadDeckFromDiscard(discarded);
        }

        // Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        // Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        // Print their hands
        dealer.printFirstHand();
        player.printHand();

        if (dealer.hasBlackjack()) {
            // Show the dealer has BlackJack
            dealer.printHand();

            if (player.hasBlackjack()) {
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            } else {
                System.out.println("Dealer has BlackJack... You lose!");
                dealer.printHand();
                losses++;
                startRound();
            }
        }
        // Check if player has blackjack to start
        // If we got to this point, we already know the dealer didn't have blackjack
        if (player.hasBlackjack()) {
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }
        player.makeDecision(deck, discarded);

        if (player.getHand().calculatedValue() > 21) {
            System.out.println("You have gone over 21! You Busts!");
            losses++;
            startRound();
        }

        // Now it's the dealer's turn
        dealer.printHand();
        while (dealer.getHand().calculatedValue() < 17) {
            dealer.hit(deck, discarded);
        }
        if (dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts!");
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You lose!");
            losses++;
        } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()) {
            System.out.println("You win!");
            wins++;
        } else {
            System.out.println("Push");
        }
        startRound();
    }
}
