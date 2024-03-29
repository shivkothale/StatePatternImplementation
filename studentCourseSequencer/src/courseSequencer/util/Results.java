package courseSequencer.util;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {

   FileProcessor fProcessor;
   FileProcessor errorProcessor;
   public Results(String filePath, String errorFilePath){
       fProcessor=new FileProcessor(filePath);
       errorProcessor=new FileProcessor(errorFilePath);
   }
    @Override
    public void writeResult(String s) {
         fProcessor.Write(s+"\n");
    }
    @Override
    public void writeError(String s) {
      errorProcessor.Write(s);
    }

    @Override
    public void colseFileWriter() {
       fProcessor.colseFileWriter();
       errorProcessor.colseFileWriter();
    }
    
}
