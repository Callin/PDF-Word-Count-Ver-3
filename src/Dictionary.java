import java.io.*;
import java.util.ArrayList;

/**
 * Provides two methods to extract the words from the dictionary file
 */
public class Dictionary {
    /**
     * Reads the Dictionary and returns the words from the file as an ArrayList of DictionaryWord objects
     *
     * @param dictionaryPath    The location of the dictionary file (the path)
     * @return                  The words from the dictionary. Each word will be enclosed in DictionaryWord object along with a variable for it's frequency.
     */
    public static ArrayList<DictionaryWord> getTheWords(String dictionaryPath){

        ArrayList<DictionaryWord> theWords = new ArrayList<DictionaryWord>();

        try (FileReader fileReader = new FileReader(dictionaryPath);
             BufferedReader reader = new BufferedReader(fileReader)){

            String line;
            while ((line = reader.readLine()) != null){
                    // a new DictionaryWord object is created which will hold the word from the dictionary and
                    // its frequency which initially is zero
                DictionaryWord dictionaryWord = new DictionaryWord();
                    // the word from the dictionary is added to the object
                dictionaryWord.setWord(line);
                    // the object which holds the word and its frequency is then added to
                    // an ArrayList of DictionaryWord objects
                theWords.add(dictionaryWord);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The dictionary does not exist or is inaccessible");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("There was a failed or interrupted I/O operation " +
                    "while reading the Dictionary file");
            e.printStackTrace();
        }
        return theWords;
    }

    /**
     * Reads the Dictionary and returns the words from the file as an ArrayList of Strings
     * @param dictionaryPath    The location of the dictionary file (the path)
     * @return                  The words from the dictionary as String objects
     */
    public static ArrayList<String> getTheWordsAsStrings(String dictionaryPath){
        ArrayList<String> theWords = new ArrayList<String>();

        try(FileReader fileReader = new FileReader(dictionaryPath);
            BufferedReader reader = new BufferedReader(fileReader)){

            String line;
            while ((line = reader.readLine()) != null){
                    // the word is added to the ArrayList of dictionary words
                theWords.add(line);
            }
        } catch (FileNotFoundException e) {
                // the error message should be displayed in the JTextArea
            System.out.println("The dictionary does not exist or is inaccessible");
            e.printStackTrace();
        } catch (IOException e) {
                // the error message should be displayed in the JTextArea
            System.out.println("There was a failed or interrupted I/O operation " +
                    "while reading the Dictionary file");
            e.printStackTrace();
        }
        return theWords;
    }
}
