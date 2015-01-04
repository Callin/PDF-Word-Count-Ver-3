PDF-Word-Count-Ver-3
====================

Short Description:
An app designed to search a directory and its subdirectories for PDF documents. The app then counts the number of words in each document, the number of sentences and the number of times each word from a given dictionary is found in each PDF document. The results are then saved in a results.xls file

Frameworks used in the app:
  - Apache PDFBox to process the PDF documents (pdfbox-1.8.7.jar)
  - Apache POI to operate on the excel file (poi-3.10.1-20140818.jar) 
  - Stanford CoreNLP to analyze the text from the PDF documents  (stanford-corenlp-3.5.0.jar)
  
JDK version
  - the version needed to run the app is 1.8 or higher
