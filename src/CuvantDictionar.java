/**
 * Created to hold the words from the dictionary and and their frequency
 */
public class CuvantDictionar {
    private String cuvant; // hold a word from the dictionary
    private int frecventa; // holds the frequency of the word from the dictionary

    CuvantDictionar(){
        // Constructor - sets the default values for the two instance variables
        cuvant = null;
        frecventa = 0;
    }

    public void setCuvant(String cuvant){
        this.cuvant = cuvant;
    }
    public String getCuvant(){
        return cuvant;
    }
    public void setFrecventa(int frecventa){
        this.frecventa = frecventa;
    }
    public int getFrecventa(){
        return frecventa;
    }

    public void incrementFrequency(){
        // it increments the frequency of the dictionary word
        frecventa++;
    }
}
