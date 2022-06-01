

import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppTest {
    private Game g;

    public void init() throws FileNotFoundException {
        g = new Game();
        g.startGame();
    }

    public void testLongGuess() throws FileNotFoundException {
        boolean val = g.isValidWord("this is too long of a guess");
        assertFalse(val);
    }

    public void testShortGuess() throws FileNotFoundException {
        boolean val = g.isValidWord("s");
        assertFalse(val);
    }

    public void testValidGuess() throws FileNotFoundException {
        boolean val = g.isValidWord(HelperMethods.makeRandomGuess());
        assertTrue(val);
    }

//    TODO
    public void testMarking() {

    }
}
