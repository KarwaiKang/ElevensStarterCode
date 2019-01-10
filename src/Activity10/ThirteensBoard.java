package Activity10;

import Activity9.Board;

import java.util.List;

/**
 * The ThirteensBoard class represents the board in a game of Thirteens.
 */
public class ThirteensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 10;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ThirteensBoard</code> instance.
     */
    public ThirteensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Thirteens, the legal groups are (1) a pair of cards
     * whose values add to 13, and (2) a king.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        return (selectedCards.size() == 2 && containsPairSum13(selectedCards)) ||
                (selectedCards.size() == 1 && containsK(selectedCards));
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Thirteens, there is a legal play if the board contains
     * (1) a pair of cards whose values add to 13, or (2) a king.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        return containsPairSum13(cardIndexes()) || containsK(cardIndexes());
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum13(List<Integer> selectedCards) {
        for (int i = 0; i < selectedCards.size(); i++) {
            for (int j = 0; j < selectedCards.size(); j++) {
                if (i != j && cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 13)
                    return true;
            }
        }
        return false;
    }

    /**
     * Check for a K in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a K.
     * @return true if the board entries in selectedCards
     *              includes a king; false otherwise.
     */
    private boolean containsK(List<Integer> selectedCards) {
        for (int i : selectedCards) {
            if (cardAt(i).rank().equals("king"))
                return true;
        }
        return false;
    }
}
