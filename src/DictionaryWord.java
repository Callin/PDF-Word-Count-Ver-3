/**
 * Created to hold the words from the dictionary and and their frequency
 */
public class DictionaryWord {
    private String word; // holds a word from the dictionary
    private int frequency; // holds the frequency of the word from the dictionary

    DictionaryWord(){
        // Constructor - sets the default values for the two instance variables
        word = null;
        frequency = 0;
    }

        /** Setters */
    public void setWord(String word){
        this.word = word;
    }
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

        /** Getters */
    public String getWord(){
        return word;
    }
    public int getFrequency(){
        return frequency;
    }

    public void incrementFrequency(){
        // it increments the frequency of the dictionary word
        frequency++;
    }
}
