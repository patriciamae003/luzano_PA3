import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This class counts how many times each word occurs
public class DuplicateCounter {
    // stores the count
    private Map<String, Integer> wordCounter;

    // Uses map of strings to count how many times each word occurs
    public void count(String dataFile) {
        String word;
        Scanner scnr = null;
        File userFile = null;
        wordCounter = new HashMap<String, Integer>();

        try {
            userFile = new File(dataFile);
            scnr = new Scanner(userFile);
        } catch (FileNotFoundException excpt) {
            System.out.println("ERROR FileNotFoundException: " + excpt.getMessage());
        }

        while(scnr.hasNext()) {
            word = scnr.next().toLowerCase();
            Integer count = wordCounter.get(word);

            // if hashmap contains the key, increment by 1
            if(wordCounter.containsKey(word)) {
                wordCounter.put(word, count + 1);
            }
            // if not, count is 1
            else {
                wordCounter.put(word, 1);
            }
        }

        scnr.close();
    }

    // Writes contents of wordCounter to file pointed by outputFile
    public void write(String outputFile) {
        File fileOut = null;

        try {
            fileOut = new File(outputFile);
            PrintWriter printWriter = new PrintWriter(fileOut);

            for(String str : wordCounter.keySet()) {
                printWriter.println(str + " " + wordCounter.get(str));
            }

            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException excpt) {
            System.out.println("ERROR FileNotFoundException: " + excpt.getMessage());
        }
    }
}
