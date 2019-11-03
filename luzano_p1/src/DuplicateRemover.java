import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

// This class removes any duplicate of a word
public class DuplicateRemover {
    // set of strings
    private Set<String> uniqueWords;

    //uses a set of strings to eliminate duplicate words
    public void remove(String dataFile) {
        File userFile = null;
        Scanner scnr = null;
        String wordInput;
        uniqueWords = new HashSet<String>();

        try {
            userFile = new File(dataFile);
            scnr = new Scanner(userFile);

            while(scnr.hasNext()) {
                wordInput = scnr.next();
                uniqueWords.add(wordInput);
            }
            scnr.close();
        } catch (FileNotFoundException excpt) {
            System.out.println("ERROR FileNotFoundException: " + excpt.getMessage());
        }
    }

    // Writes the words in uniqueWords to the file pointed by outputFile
    public void write(String outputFile) {
        File fileOut = null;

        try {
            fileOut = new File(outputFile);
            PrintWriter printWriter = new PrintWriter(fileOut);

            for (String str : uniqueWords) {
                printWriter.println(str);
            }

            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException excpt) {
            System.out.println("ERROR FileNotFoundException: " + excpt.getMessage());
        }
    }
}
