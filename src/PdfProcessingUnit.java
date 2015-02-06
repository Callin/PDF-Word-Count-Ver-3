import java.io.File;
import java.util.ArrayList;

/**
 * Provides the functionality to process a single PDF document.
 * */
public class PdfProcessingUnit {

        /** It extracts de text, counts the number of words and sentences, and outputs the result into the xls file
         * @param pdfDocPath            the location of the PDF document
         * @param wordsFromDictionary   the words from the dictionary
         * @param xlsPath               the location of the results.xls file
         * @param companyName           the company name
         */
        public void  processTheFile(File pdfDocPath, ArrayList<DictionaryWord> wordsFromDictionary,
                                    String xlsPath, String companyName){

             // get the text from the PDF document
            ArrayList<String> textFromThePdf;
            Pdf pdfDoc = new Pdf();
            textFromThePdf = pdfDoc.getTextFromPDF(pdfDocPath);

            // process the text
            ArrayList<Integer> results;
            TextProcessingUnit textUnit = new TextProcessingUnit();
            results = textUnit.processTheText(textFromThePdf, wordsFromDictionary);

            // write the results into the xls file
            Excel xlsFile = new Excel();
            xlsFile.addRecord(xlsPath, companyName, results);
        }
}
