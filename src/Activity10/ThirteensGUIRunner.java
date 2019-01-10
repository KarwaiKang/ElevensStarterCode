package Activity10;

import Activity9.Board;
import Activity9.CardGameGUI;
import Activity9.ElevensBoard;

/**
 * This is a class that plays the GUI version of the Thirteens game.
 * See accompanying documents for a description of how Thirteens is played.
 */
public class ThirteensGUIRunner {

    /**
     * Plays the GUI version of Thirteens.
     * @param args is not used.
     */
    public static void main(String[] args) {
        Board board = new ThirteensBoard();
        Activity9.CardGameGUI gui = new CardGameGUI(board);
        gui.displayGame();
    }
}