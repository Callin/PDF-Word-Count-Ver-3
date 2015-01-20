import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TextProcessingUnit {
    /**
     * The class provides the means to process the text extracted from the PDF documents
     * It uses Stanford CoreNLP to process the text
     */

    private ArrayList<Integer> results = new ArrayList<Integer>();

    void setResults(ArrayList<Integer> results){
        this.results = results;
    }
    ArrayList<Integer> getResults(){
        return results;
    }

    ArrayList<Integer> processTheText(ArrayList<String> textToBeSplit, ArrayList<DictionaryWord> words){
        /**
         * It will process the text and return the results
         *
         * It will take:
         *      - the text (from the entire PDF)
         *      - the words from the dictionary (String or DictionaryWord)
         *
         * It should return and ArrayList with
         *          - the number of words in the document
         *          - the number of sentences in the document
         *          - the number of words/sentence
         *          - the frequency of each word from the dictionary
         */
        int numberOfSentences = 0;
        int numberOfWords = 0;

        if(textToBeSplit == null)
            // if there was a problem while reading the PDF, the textToBeSplit will be null
            // and therefore there is no point in going forward
            System.out.println("There was a problem with the PDF document");
        else {
            for(String onePage:textToBeSplit){
                    // breaks the text into sentences
                Reader reader = new StringReader(onePage);
                DocumentPreprocessor dp = new DocumentPreprocessor(reader);
                for (List sentence : dp) {
                        // counts the number of sentences
                    numberOfSentences++;
                }

                    // breaks the text into words
                Reader reader2 = new StringReader(onePage);
                PTBTokenizer ptbt = new PTBTokenizer(reader2, new CoreLabelTokenFactory(), "");
                for (CoreLabel label; ptbt.hasNext(); ) {
                    label = (CoreLabel) ptbt.next();
                        // if the word is more than one character long, count them, else do not
                        // alternatively an ArrayList could be used of non-words (e.g. ; ' " , . :)
                    if((label.toString().length()>1))
                        numberOfWords++;
                    for(DictionaryWord word:words){
                        if(word.getWord().equals(label.toString())){
                            word.incrementFrequency();
                        }
                    }
                }

                try {
                    reader.close();
                    reader2.close();
                } catch (IOException e) {
                    System.out.println("Reader will not close.");
                    e.printStackTrace();
                }
            }
                // the number of words are added to the results ArrayList
            results.add(numberOfWords);
                // the number of sentences are added to the results ArrayList
            results.add(numberOfSentences);
                // the number of words per sentence
            results.add(numberOfWords/numberOfSentences);
                // adds the frequency of each word from the dictionary to the results ArrayList
                // it will be added in the order in which the word was read from the dictionary
            for(DictionaryWord word:words){
                results.add(word.getFrequency());
            }
        }
        return getResults();
    }
}
