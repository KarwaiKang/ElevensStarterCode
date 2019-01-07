package Activity2;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};

        String[] fullRanks = new String[52];
        String[] fullSuits = new String[52];
        int[] fullValues = new int[52];

        int i = 0;
        for (String s : suits) {
            for (String r : ranks) {
                fullRanks[i] = r;
                fullSuits[i] = s;
                fullValues[i] = (i % 13) + 1;
                i++;
            }
        }

        Deck deck = new Deck(fullRanks, fullSuits, fullValues);

        System.out.println(deck);
        deck.shuffle();
        System.out.println("Shuffled:");
        System.out.println(deck);

        for (int j = 1; !deck.isEmpty(); j++) {
            System.out.println("Dealt card #" + j + ": " + deck.deal());
        }
    }
}

