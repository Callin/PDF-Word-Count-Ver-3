/**
 * Holds the words from the dictionary and and their frequency
 */
public class DictionaryWord {
    /** holds a word from the dictionary*/
    private String word;
    /** holds the frequency of the word from the dictionary*/
    private int frequency;

    /** Constructor - sets the default values for the two instance variables */
    DictionaryWord(){
        word = null;
        frequency = 0;
    }

    /** Setter - sets the value for the word variable
     *  @param word the word from the dictionary
     * */
    public void setWord(String word){
        this.word = word;
    }
    /** Setter - sets the frequency of the word
     *  @param frequency the frequency of the word
     * */
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    /** Getter - returns the the word
     *  @return the word
     * */
    public String getWord(){
        return word;
    }

    /** Getter - returns the the frequency of the word
     *  @return the frequency
     * */
    public int getFrequency(){
        return frequency;
    }

    /** Increments the frequency of the dictionary word by one*/
    public void incrementFrequency(){
        frequency++;
    }
}
