/**Starts the application */
public class TesterClassAllPdfs {
    public static void main(String[] args){
        DirectoryProcessingUnit directory = new DirectoryProcessingUnit("D:\\javapdf\\");
        directory.searchAndProcessTheDirectory(directory.getMainDirectory(),
                directory.getWordsFromDictionary(), directory.getXlsFile().toString(), "Main Directory");
    }
}
