import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "ProgrammingHistory.txt";
        String word = "programs";
        //word we are looking for in the txt file

        ArrayList<String> line = fileConvert(fileName);
        ArrayList<ArrayList<Integer>> wordLocation = findLocation(line, word);
        printResult(word, wordLocation);
    }

    public static ArrayList<String> fileConvert(String fileName) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        int readLine;
        String lineStorage = "";

        while((readLine = bufferedReader.read()) != -1) {
            char character = (char) readLine;
            String line = Character.toString(character);
            lineStorage += line;

            if (readLine == '\n') {
                lines.add(lineStorage);
                lineStorage = null;
            }
        }
        bufferedReader.close();
        return lines;
    }

    public static ArrayList<ArrayList<Integer>> findLocation(ArrayList<String> lines, String word){
        ArrayList<ArrayList<Integer>> locations = new ArrayList<>();

        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            // search for word in line
            int startPosition = 0;
            int linePosition;
            //if a match is found
            while ((linePosition = line.indexOf(word, startPosition)) != -1) {
                ArrayList<Integer> location = new ArrayList<>();
                location.add(lineIndex+1);
                // the line number of match
                location.add(linePosition+1);
                // position in the line
                locations.add(location);
                // records the location of match
                startPosition = linePosition + 1;
            }
        }

        return locations;
    }

    public static void printResult(String word, ArrayList<ArrayList<Integer>> wordLocations){
        for(ArrayList<Integer> location: wordLocations){
            System.out.println("\nline number =\t" + location.get(0));
            System.out.println("line position =\t" + location.get(1));
            System.out.println("\n***************************************");
        }
    }
}