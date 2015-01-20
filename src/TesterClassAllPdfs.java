
public class TesterClassAllPdfs {
    public static void main(String[] args){
        DirectoryProcessingUnit directory = new DirectoryProcessingUnit("/home/dragos/javadev/Companies DB/");
        directory.searchAndProcessTheDirectory(directory.getMainDirectory(),
                directory.getWordsFromDictionary(), directory.getXlsFile().toString(), "Main Directory");
    }
}
