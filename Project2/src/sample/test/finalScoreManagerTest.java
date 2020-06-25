package sample.test;

import org.junit.Test;
import sample.gameover.FinalScoreManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class finalScoreManagerTest {
    FinalScoreManager finalScoreManager;
    private File scores = new File("scores.txt");

    @Test
    public void testDeleteScores() throws IOException {
        //tests if finalScoreManager is empty after deleting scores
        finalScoreManager = new FinalScoreManager();
        finalScoreManager.deleteScores();

        ArrayList<String> allScores = finalScoreManager.getAllScores();
        assertEquals(0, allScores.size());
    }

    @Test
    public void testAddScore() throws IOException {
        //tests if adding a new score to an empty fileScoreManager has the size of 1 and if it contains the same score
        finalScoreManager = new FinalScoreManager();
        finalScoreManager.deleteScores();

        finalScoreManager.addScore(572);
        ArrayList<String> allScores = finalScoreManager.getAllScores();
        assertEquals(1, allScores.size());
        assertTrue(allScores.get(0).equals("score: 572"));
    }

    @Test
    public void testGetAllScores() throws IOException {
        //tests if adding new scores to an empty filesScoreManager has the size is the number of scores and if it contains the same scores but in reverse order.
        finalScoreManager = new FinalScoreManager();
        finalScoreManager.deleteScores();

        finalScoreManager.addScore(743);
        finalScoreManager.addScore(922);
        finalScoreManager.addScore(658);

        ArrayList<String> allScores = finalScoreManager.getAllScores();
        assertEquals(3, allScores.size());
        // Scores are reversed; most recent at top
        assertTrue(allScores.get(0).equals("score: 658"));
        assertTrue(allScores.get(1).equals("score: 922"));
        assertTrue(allScores.get(2).equals("score: 743"));
        finalScoreManager.deleteScores();
        //deletes scores to prevent the test scores from showing up after test
    }
}