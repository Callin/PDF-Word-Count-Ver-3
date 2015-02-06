import java.io.File;
import java.util.ArrayList;

/**
 * Will process the entire directory looking for PDF files and then call the PdfProcessingUnit object to process each individual case
 * */
public class DirectoryProcessingUnit {

    /** holds the path to the main directory of the PDF files*/
    private File mainDirectory;
    /** holds the words from the dictionary and their frequency*/
    private ArrayList<DictionaryWord> wordsFromDictionary;
    /** holds the words from the dictionary*/
    private ArrayList<String> wordsFromDictionary2;
    /** holds the path to the results file*/
    private Excel xlsFile;

    /**
     * Initializes the instance variables
     * @param mainDirectoryPath the path to the main directory
     * */
    DirectoryProcessingUnit(String mainDirectoryPath){
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

        /** Setter - has no function, could be used later */
    public void setMainDirectory(){}
        /** Setter - has no function, could be used later */
    public void setWordsFromDictionary(){}
        /** Setter - has no function, could be used later */
    public void setWordsFromDictionary2(){}
        /** Setter - has no function, could be used later */
    public void setXlsFile(){}

        /** Getter - returns the main directory path
         *  @return the path to the main directory
         * */
    public File getMainDirectory(){
        return mainDirectory;
    }
        /** Getter - returns the words from the dictionary and their frequency, both enclosed in a DictionaryWord object
         *  @return an ArrayList of DictionaryWord objects
         * */
    public ArrayList<DictionaryWord> getWordsFromDictionary(){
        return wordsFromDictionary;
    }
        /** Getter - returns the words from the dictionary
         *  @return an ArrayList of String objects (the words)
         * */
    public ArrayList<String> getWordsFromDictionary2(){
        return wordsFromDictionary2;
    }
        /** Getter - returns the path to the results file
         *  @return the path to the results file
         * */
    public Excel getXlsFile(){
        return xlsFile;
    }

    /**
     *  Searches the directory for PDF files and calls a PDFProcessingUnit object when it finds a file
     *  @param directoryPath        the path to the main directory
     *  @param wordsFromDictionary  the words from the dictionary
     *  @param xlsFile              the results file
     *  @param companyName          the company name
     * */
    void searchAndProcessTheDirectory(File directoryPath, ArrayList<DictionaryWord> wordsFromDictionary,
                                             String xlsFile, String companyName) {
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

    /**
     * Extracts the company name from a given path. CompanyName = the parent directory of the file
     * @param directoryPath the path which contains the company name
     * @return              the company name (the last element of the array)
     */
    String getCompanyName(File directoryPath){
        String[] company = directoryPath.getParent().split("/");
        return company[company.length-1];
    }
}
