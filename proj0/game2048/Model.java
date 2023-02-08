git clone https://github.com/Berkeley-CS61B/library-fa22
        git clone https://github.com/Berkeley-CS61B/library-fa22
        package game2048;

import javax.swing.*;
import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /**
     * Current contents of the board.
     */
    private final Board _board;
    /**
     * Current score.
     */
    private int _score;
    /**
     * Maximum score so far.  Updated when game ends.
     */
    private int _maxScore;
    /**
     * True iff game is ended.
     */
    private boolean _gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /**
     * Largest piece value.
     */
    public static final int MAX_PIECE = 2048;

    /**
     * A new 2048 game on a board of size SIZE with no pieces
     * and score 0.
     */
    public Model(int size) {
        _board = new Board(size);
        _score = _maxScore = 0;
        _gameOver = false;
    }

    /**
     * A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes.
     */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        _board = new Board(rawValues);
        this._score = score;
        this._maxScore = maxScore;
        this._gameOver = gameOver;
    }

    /**
     * Same as above, but gameOver is false. Used for testing purposes.
     */
    public Model(int[][] rawValues, int score, int maxScore) {
        this(rawValues, score, maxScore, false);
    }

    /**
     * Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     * 0 <= COL < size(). Returns null if there is no tile there.
     * Used for testing. Should be deprecated and removed.
     */
    public Tile tile(int col, int row) {
        return _board.tile(col, row);
    }

    /**
     * Return the number of squares on one side of the board.
     * Used for testing. Should be deprecated and removed.
     */
    public int size() {
        return _board.size();
    }

    /**
     * Return true iff the game is over (there are no moves, or
     * there is a tile with value 2048 on the board).
     */
    public boolean gameOver() {
        checkGameOver();
        if (_gameOver) {
            _maxScore = Math.max(_score, _maxScore);
        }
        return _gameOver;
    }

    /**
     * Return the current score.
     */
    public int score() {
        return _score;
    }

    /**
     * Return the current maximum game score (updated at end of game).
     */
    public int maxScore() {
        return _maxScore;
    }

    /**
     * Clear the board to empty and reset the score.
     */
    public void clear() {
        _score = 0;
        _gameOver = false;
        _board.clear();
        setChanged();
    }

    /**
     * Allow initial game board to announce a hot start to the GUI.
     */
    public void hotStartAnnounce() {
        setChanged();
    }

    /**
     * Add TILE to the board. There must be no Tile currently at the
     * same position.
     */
    public void addTile(Tile tile) {
        _board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /**
     * Tilt the board toward SIDE.
     * <p>
     * 1. If two Tile objects are adjacent in the direction of motion and have
     * the same value, they are merged into one Tile of twice the original
     * value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     * tilt. So each move, every tile will only ever be part of at most one
     * merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     * value, then the leading two tiles in the direction of motion merge,
     * and the trailing tile does not.
     */
    /* Not sure how to implement this. The tiles need to be checked top down but also check the tile that is above. I get that I need to do some sort of loop but I have an infinite loop */
    public void tilt(Side side) {
        if (emptySpaceExists(_board) || atLeastOneMoveExists(_board)) {
            if (atLeastOneMoveExists(_board)) {
                if (side != Side.NORTH) {
                    _board.setViewingPerspective(side);
                }
                int s = _board.size();
                for (int i = 0; i < s; i++) {
                    for (int j = s - 1; j > 0; j--) {
                        tilthelper1(_board);
                        Tile t = _board.tile(i, j);
                        if (t != null) {
                            Tile next = _board.tile(i, j - 1);
                            if (_board.tile(i, j - 1) != null) {
                                if (t.value() == next.value()) {
                                    _score += t.value()*2;
                                    _board.move(i, j, next);
                                }
                            }
                        }
                    }
                }
            }
            if (side != Side.NORTH) {
                _board.setViewingPerspective(Side.NORTH);
            }
            checkGameOver();
        }
    }
    public void tilthelper1(Board _board) {
        int s = _board.size();
        for (int i = 0; i < s; i++) {
            int count = 0;
            for (int j = s - 1; j >= 0; j--) {
                Tile t = _board.tile(i, j);
                if(t == null){
                    count++;
                }
                else if(t!= null) {
                    if (_board.tile(i, j + count) == null) {
                        _board.move(i, j + count, t);
                    }
                }
            }
        }
    }
        /* Notes: use a third for loop to check and go infinitely many if necessary.
        Maybe consider checking if the top tile and then doing nothing.
        set a condition for that maybe?
        */
   /* lab TA Note: start from the top and check if the bottom has a value and if it is the same and continue downward, figure out the index errors
    can use helper function to check
            use if(merge/move) to check whether or not the merge has happened so you can avoid double merges
    start from top left and go downwards then to the right
    key problem right now: only moves once, never more than that. can see in main and in testup only
    isolate a test case to move it upward once
    move each tile then merge the numbers, know if you are going to merge it, start top down, write a rule that says that it cannot merge if the numbers are the same

    ta notes: create a counter so that the function knows how far to move, if x spot is null then count++
    super helpful. keep this in mind
   current issue: merges downwards and also does not move tricky merge upwards
   could maybe use another for structure?
   maybe have conditions for edge cases?
   moving upwards by i amount does not work bc of bounds and just issues

   potential suggestions from csua: maybe considering separating everything out more and write separate functions instead of shoving in if clauses
   try checking downwards and moving upwards like originally?

   still have error of one space in between
   how can i fix this:
   _board.move again? but you can only call it once per tile
   while loop? always out of bounds issues
   what would the conditions be for that while loop though?
   while(i+j<3) never worked, infinite loop do not try

   i want to iterate multiple times. how???
   ta notes: use a loop, figure out the conditions
   for loop again?
   shove the for structure into the for loop? quadruple for structure? too messy
   write separate helper to just shove into for loop
   */
    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        _gameOver = checkGameOver(_board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
        for(int i = 0; i <b.size(); i++){
            for(int j = 0; j<=i; j++){
                if(b.tile(i,j) == null)
                    return true;
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by this.MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        for(int i = 0; i<b.size(); i++){
            for(int j = 0; j<b.size(); j++){
                if(b.tile(i,j) == null) continue;
                if(b.tile(i,j).value() == MAX_PIECE)
                    return true;
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        for(int i = 0; i< 3; i++){
            for(int j = 0; j< 3; j++){
                if(emptySpaceExists(b) != true) {
                    if(b.tile(i,j).value() == b.tile(i+1,j).value() || b.tile(i,j).value()  == b.tile(i, j+1).value()) {
                        return true;
                    }
                    if(b.tile(i,3).value() == b.tile(i+1,3).value() || b.tile(3,j).value() == b.tile(3,j+1).value()){
                        return true;
                    }
                }
                else
                    return true;
                    }
                }
        return false;
            }



    /** Returns the model as a string, used for debugging. */
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    /** Returns whether two models are equal. */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    /** Returns hash code of Model’s string. */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
