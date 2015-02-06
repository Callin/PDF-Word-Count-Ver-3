import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

/** It uses Apache POI to create the Excel file and add a new record
 */
public class Excel {
    /** the path to the results.xls file*/
    private File excelFileName;

    /** Creates the results file (if it does not exist)
     *  @param excelFileName            the path to the results.xls file
     *  @param wordsFromTheDictionary   the words from the dictionary
     *  @return                         a message which indicates whether the operation was a success or not
     * */
    public String createFile(String excelFileName, ArrayList<String> wordsFromTheDictionary){
            // creates the results.xls file
        this.excelFileName = new File(excelFileName);
        int i;
        ArrayList<String> excelHeader = new ArrayList<String>();
                    // it adds the known header elements
                    // it adds the words from the dictionary
                excelHeader.add(0, "Company");
                excelHeader.add(1, "No. of words in the document");
                excelHeader.add(2, "No. of sentences");
                excelHeader.add(3, "No. of words per sentence");
                for(String dictionaryWord:wordsFromTheDictionary){
                    excelHeader.add(dictionaryWord);
                }
        System.out.print("Creating the excel file ...");
        File file = new File(excelFileName);
        try {
            if(file.createNewFile()){
                    // the Results.xls file does not exist and is being created
                FileOutputStream outFile = new FileOutputStream(file);
                    // a new workbook is being created
                HSSFWorkbook workbook = new HSSFWorkbook();
                    // a new sheet is being created
                workbook.createSheet("Sheet 1");
                    // the sheet is assigned to a local variable
                HSSFSheet sheet = workbook.getSheet("Sheet 1");

                    // writes the header of the excel file
                HSSFRow row = sheet.createRow(0);
                    // creates a local variable for a given excel cell
                HSSFCell cell;
                for(i=0; i<excelHeader.size(); i++){
                    // the header elements are added (both the known and the dictionary elements)
                    if(i<=3){
                        cell = row.createCell(i);
                        cell.setCellValue(excelHeader.get(i));
                    }else{
                        cell = row.createCell(i);
                        cell.setCellValue("No. of times the word \"" + excelHeader.get(i) + "\" appears in the document");
                    }
                }
                workbook.write(outFile);
                outFile.close();

                System.out.print("The file Results.xls has been created!\n");
                return "The file Results.xls has been created!\n";
            }
            else
                return "The file already exists!\n";

        } catch (IOException e) {
            System.out.println("There was a failed or interrupted I/O operation " +
                    "while working with the Excel file");
            e.printStackTrace();
            return "There was a failed or interrupted I/O operation while working with the Excel file";
        }
    }

    /** Adds a new record to the excel file
     *  @param excelFilePath    the path to the results file
     *  @param companyName      the company name
     *  @param allTheCounts     all the frequencies (words, sentences a.s.o.) that will be added to the results file
     *  @return                 a message which indicates whether the operation was a success or not
     */
    public String addRecord(String excelFilePath, String companyName, ArrayList<Integer> allTheCounts){
        try {
            File file = new File(excelFilePath);
            FileInputStream inFile = new FileInputStream(excelFilePath);

            HSSFWorkbook workbook = new HSSFWorkbook(inFile); // a new HSSFWorkbook object
            HSSFSheet sheet = workbook.getSheet("Sheet 1"); // get Sheet 1 and assign it to sheet

                // create the row right after the name of the Directory/Company
            HSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);
            HSSFCell cell;
                // insert the company's name
            cell = row.createCell(0);
            cell.setCellValue(companyName);

            int i = 1; // 0 is for the company name
            for(Integer excelRecord:allTheCounts){
                cell = row.createCell(i);
                cell.setCellValue(excelRecord);
                i++;
            }

            // write the changes to the file
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.close();
            return "A new record was added to the results file";
        } catch (FileNotFoundException e) {
            System.out.println("The excel file does not exist or is inaccessible");
            e.printStackTrace();
            return "The excel file does not exist or is inaccessible";
        } catch (IOException e) {
            System.out.println("There was a failed or interrupted I/O operation " +
                    "while working with the Excel file");
            e.printStackTrace();
            return "There was a failed or interrupted I/O operation while working with the Excel file";
        }
    }

    @Override
    public String toString(){
        return excelFileName.getAbsolutePath();
    }
}