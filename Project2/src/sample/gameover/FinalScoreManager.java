package sample.gameover;

import java.io.*;
import java.util.ArrayList;

public class FinalScoreManager {
    private File scores = new File("scores.txt");

    //Requires: nothing
    //Modifies: this, scores
    //Effects: scores.txt file content is deleted
    public void deleteScores() {
        scores.delete();
    }

    //Requires: int score
    //Modifies: this, scores
    //Effects: Adds a score into scores.txt
    public void addScore(int score) throws IOException {
        FileWriter fw = new FileWriter(scores, true);
        fw.write("score: " + score + "\n");
        fw.close();
    }

    //Requires: nothing
    //Modifies: this, allScores
    //Effects: Returns the scores from scores.txt as a list of strings
    public ArrayList<String> getAllScores() throws IOException {
        ArrayList<String> allScores = new ArrayList<>();
        if(!scores.exists()){
            return allScores;
        }
        BufferedReader br = new BufferedReader(new FileReader(scores));
        String line;
        while ((line = br.readLine()) != null){
            allScores.add(0, line);
        }
        br.close();
        return allScores;
    }
}