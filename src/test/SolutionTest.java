package test;
import main.Solution;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp(){
        solution = new Solution();
    }

    @Test
    public void grandTodayTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "me", "one", "grand", "today"};

        //Call the method you are testing
        solution.checkMagazine(magazine, note);

        //Now you have to validate the output
        String expectedOutput = "Yes\r\n";

        //Do the actual assertion
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void twoTimesThreeNoMultipleWordsTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};

        //Call the method you are testing
        solution.checkMagazine(magazine, note);

        //Now you have to validate the output
        String expectedOutput = "No\r\n";

        //Do the actual assertion
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void missingWordTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        String[] magazine = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        String[] note = {"ive", "got", "some", "coconuts"};

        //Call the method you are testing
        solution.checkMagazine(magazine, note);

        //Now you have to validate the output
        String expectedOutput = "No\r\n";

        //Do the actual assertion
        assertEquals(expectedOutput, outContent.toString());
    }
}
