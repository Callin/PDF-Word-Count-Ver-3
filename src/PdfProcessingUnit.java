import java.io.File;
import java.util.ArrayList;

/**
 * The class provides the functionality to process a single PDF document:
 *      - extract de text
 *      - count the number of words and sentences
 *      - output the results into the xls file
 * */
public class PdfProcessingUnit {
        public void  processTheFile(File pdfDocPath, ArrayList<DictionaryWord> wordsFromDictionary,
                                    String xlsPath, String companyName){
            /**
             *  Will take the path to the PDF file as parameter
             * */

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
