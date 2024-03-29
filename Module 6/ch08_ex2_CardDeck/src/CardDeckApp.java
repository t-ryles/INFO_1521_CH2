import java.util.ArrayList;

public class CardDeckApp {

    public static void main(String[] args) {
        System.out.println("DECK");
        String[] deck = getDeck();
        displayCards(deck);

        System.out.println("SHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);

        int count = 2;
        System.out.println("HAND OF " + count + " CARDS");
        String[] hand = dealCards(deck, count);
        displayCards(hand);
    }

    private static String[] getDeck() {
        String[] deck = new String[52];
        // add code that creates deck here
        String[] suites = {"Diamonds", "Clubs", "Hearts", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        int index = 0;

        for (String suite : suites) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suite;
                index++;
            }
        }
        return deck;
    }

    private static void displayCards(String[] cards) {
        // add code that displays cards here
        for(String card : cards) {
            System.out.print(card + " |");
        }
        System.out.println();
    }

    private static void shuffleDeck(String[] deck) {
        //int randomIndex = (int) (Math.random() * deck.length-1);
        
        // add code that shuffles the deck here
        for( int i = deck.length - 1; i >= 0; i-- ) {
            int randomIndex = (int) (Math.random() * deck.length-1);

            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    private static String[] dealCards(String[] deck, int count) {
        String[] hand = new String[count];

        for(int i = 0; i < count; i++) {
            hand[i] = deck[i];
        }
        return hand;
    }
}