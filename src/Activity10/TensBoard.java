package Activity10;

import Activity9.Board;

import java.util.List;

/**
 * The ThirteensBoard class represents the board in a game of Thirteens.
 */
public class TensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 13;

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
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ThirteensBoard</code> instance.
     */
    public TensBoard() {
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
        return (selectedCards.size() == 2 && containsPairSum10(selectedCards)) ||
                (selectedCards.size() == 4 && containsQuartet(selectedCards));
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
        return containsPairSum10(cardIndexes()) || containsQuartet(cardIndexes());
    }

    /**
     * Check for an 10-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 10-pair.
     * @return true if the board entries in selectedCards
     *              contain an 10-pair; false otherwise.
     */
    private boolean containsPairSum10(List<Integer> selectedCards) {
        for (int i = 0; i < selectedCards.size(); i++) {
            for (int j = 0; j < selectedCards.size(); j++) {
                if (i != j && cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 10)
                    return true;
            }
        }
        return false;
    }

    /**
     * Check for a quartets of kings, queens, jacks, and tens in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a quartet.
     * @return true if the board entries in selectedCards
     *              includes a quartet; false otherwise.
     */
    private boolean containsQuartet(List<Integer> selectedCards) {
        int k = 0, q = 0, j = 0, t = 0;
        for (int i : selectedCards) {
            switch (cardAt(i).rank()) {
                case "jack":
                    j++;
                    break;
                case "queen":
                    q++;
                    break;
                case "king":
                    k++;
                    break;
                case "10":
                    t++;
                    break;
            }
        }
        return k > 3 || q > 3 || j > 3 || t > 3;
    }
}
