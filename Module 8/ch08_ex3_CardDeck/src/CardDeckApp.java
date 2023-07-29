import java.util.ArrayList;

public class CardDeckApp {

    public static void main(String[] args) {
        System.out.println("DECK");
        ArrayList<String> deck = getDeck();
        displayCards(deck);

        System.out.println("SHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);

        int count = 2;
        int capacity = 4;
        ArrayList<ArrayList<String>> hands = new ArrayList<>(capacity);

        System.out.println("FOUR HANDS OF " + count + " CARDS");

        for (int i = 0; i < capacity; i++){

            ArrayList<String> hand = dealCards(deck, count);
            hands.add(hand);
            displayCards(hand);
            shuffleDeck(deck);
        }

        int cardLeft = deck.size() - (hands.size()*2);
        System.out.println("CARDS LEFT IN DECK: " + cardLeft);
    }

    private static ArrayList<String> getDeck() {

        ArrayList<String> deck = new ArrayList<>(52);

        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King"};

        int i = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add( rank + " of " + suit);
                i++;
            }
        }
        return deck;
    }

    private static void displayCards(ArrayList<String> cards) {
        System.out.print("|");        
        for (String card : cards) {
            System.out.print(card + "|");
        }
        System.out.println();        
    }

    private static void shuffleDeck(ArrayList<String> deck) {
        for (int i = 0; i < deck.size(); i++) {
            String savedCard = deck.get(i);
            int randomIndex = (int) (Math.random() * deck.size()-1);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, savedCard);
        }
    }

    private static ArrayList<String> dealCards(ArrayList<String> deck, int count) {
        //String[] hand = Arrays.copyOfRange(deck.toArray(new String[0]), 0, count);
        return new ArrayList<>(deck.subList(0, count));
    }
}