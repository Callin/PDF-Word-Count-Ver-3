import java.io.File;
import java.util.ArrayList;

public class DirectoryProcessingUnit {
    /**
     *
     * Will process the entire directory looking for PDF files and
     * then call the PdfProcessingUnit object to process each individual case
     *
     * */

    private File mainDirectory;
    private ArrayList<DictionaryWord> wordsFromDictionary;
    private ArrayList<String> wordsFromDictionary2;
    private Excel xlsFile;

    DirectoryProcessingUnit(String mainDirectoryPath){
        /**
         * Will initialize the instance variables
         * */
        // get the words from the dictionary as ArrayList<DictionaryWord>
        wordsFromDictionary = Dictionary.getTheWords(mainDirectoryPath + "/dictionary.txt");

        // get the words from the dictionary as ArrayList<String>
        wordsFromDictionary2 = Dictionary.getTheWordsAsStrings(mainDirectoryPath + "/dictionary.txt");

        // create the results.xls file
        xlsFile = new Excel();
        xlsFile.createFile(mainDirectoryPath + "/results.xls", wordsFromDictionary2);

        //create the file leading to the main directory. Will be used later
        mainDirectory = new File(mainDirectoryPath);
    }

        /** Setters - could be used later */
    public void setMainDirectory(){}
    public void setWordsFromDictionary(){}
    public void setWordsFromDictionary2(){}
    public void setXlsFile(){}

        /** Getters */
    public File getMainDirectory(){
        return mainDirectory;
    }
    public ArrayList<DictionaryWord> getWordsFromDictionary(){
        return wordsFromDictionary;
    }
    public ArrayList<String> getWordsFromDictionary2(){
        return wordsFromDictionary2;
    }
    public Excel getXlsFile(){
        return xlsFile;
    }

    void searchAndProcessTheDirectory(File directoryPath, ArrayList<DictionaryWord> wordsFromDictionary,
                                             String xlsFile, String companyName) {
        /**
         *  Will search the directory for PDF files and call
         *  the PDFProcessingUnit object when it finds one
         * */
        File[] fList = directoryPath.listFiles();
        for (File file : fList) {

            // get the file extension
            String fileName = file.getAbsolutePath();
            String subString = fileName.substring(fileName.length() - 3);

            // test whether the file is a pdf document
            if (file.isFile() && subString.equals("pdf")) {
                // if it's a file and has a pdf extension it will be processed
                companyName = getCompanyName(file);
                PdfProcessingUnit pdfUnit = new PdfProcessingUnit();
                pdfUnit.processTheFile(file, wordsFromDictionary, xlsFile, companyName);
            } else if (file.isDirectory()) {
                // if it's not a file and and is a directory, then it will check it out for PDF files
                searchAndProcessTheDirectory(file, wordsFromDictionary, xlsFile, companyName);
            }
        }
    }

    String getCompanyName(File directoryPath){
        /**
         * CompanyName = the parent directory of the file
         * Returns the last element of the arraylist
         */
        String[] company = directoryPath.getParent().split("/");
        return company[company.length-1];
    }
}
