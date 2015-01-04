import java.io.*;
import java.util.ArrayList;

/**
 * Created to extract the words from the dictionary
 */
public class Dictionary {
    public static ArrayList<CuvantDictionar> getTheWords(String dictionaryPath){
        /**
         *      The method will read the Dictionary and will
         *      return the words from the file as an ArrayList of CuvantDictionar
         */
        ArrayList<CuvantDictionar> theWords = new ArrayList<CuvantDictionar>();
        try{
            FileReader fileReader = new FileReader(dictionaryPath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                    // a new CuvantDictionar object is created which will hold the word from the dictionary and
                    // its frequency which initially is zero
                CuvantDictionar cuvant = new CuvantDictionar();
                    // the word from the dictionary is added to the object
                cuvant.setCuvant(line);
                    // the object which holds the word and its frequency is then added to
                    // an ArrayList of CuvantDictionar objects
                theWords.add(cuvant);
            }
            reader.close();
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
    public static ArrayList<String> getTheWordsAsStrings(String dictionaryPath){
        /**
         *      The method will read the Dictionary and will
         *      return the words from the file as an ArrayList of Strings
         */
        ArrayList<String> theWords = new ArrayList<String>();
        try{
            FileReader fileReader = new FileReader(dictionaryPath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                    // the word is added to the ArrayList of dictionary words
                theWords.add(line);
            }
            reader.close();
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
