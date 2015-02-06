import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

 /**
 * Uses Apache PDFBox library to operate on the PDF file
 */
public class Pdf {
     /** stores the text from a PDF */
    private ArrayList<String> textFromPDF = new ArrayList<String>();

     /** Setter - no function yet, could be used later
      *  @param s the reference to the object holding the text from the PDF
      * */
    public void setTextFromPDF(ArrayList<String> s){
        // to be used at a later date
    }

     /** Getter - returns the reference to the object that holds the text from the PDF. Could return a null.
      *  @return    a reference to the object that holds the text from the PDF
      * */
    public ArrayList<String> getTextFromPDF(){
        return textFromPDF;
    }

     /** Getter - extracts the text from a PDF document and returns it as an ArrayList of String objects
      *  @param document    path to the PDF document
      *  @return            a reference to the object that holds the text from the PDF
      **/
    public ArrayList<String> getTextFromPDF(File document){
        // extracts the text from a PDF document and returns it as an ArrayList<String>
        try {
                // loads the document from an input stream
            PDDocument pdf = PDDocument.load(document);

            PDFTextStripper stripper = new PDFTextStripper();
            int pageToBeExtracted = 1;

            while (pageToBeExtracted <= pdf.getNumberOfPages()){
                    // the text is being extracted one page at a time
                stripper.setStartPage(pageToBeExtracted);
                stripper.setEndPage(pageToBeExtracted);
                    // text from one page is being extracted and added to the ArrayList
                    // which contains the text from all the pages
                textFromPDF.add(stripper.getText(pdf));
                pageToBeExtracted++;
            }
            pdf.close();
        } catch (IOException e) {
            System.out.println("There was a failed or interrupted I/O operation " +
                    "while reading the PDF file. The document " + document +
                    " might be encrypted.");
            textFromPDF = null;
        }
        return getTextFromPDF();
    }
}