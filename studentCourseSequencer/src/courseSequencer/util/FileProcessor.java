package courseSequencer.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileProcessor {
	
    private String filePath;
    FileWriter myFileWriter;
    /**
     * @param filePath
     */
    public FileProcessor(String filePath){
        this.filePath=filePath;
    }
    
    /**
     * @return Scanner Object
     */
    public Scanner getFileReader(){
        Scanner sc=null;
        try {
            sc=new Scanner(new File(filePath));
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Please enter a file to process on");
            e.printStackTrace();
            System.exit(0);
        }catch(FileNotFoundException e){
            System.err.println("PLease give the correct input file");
            e.printStackTrace();
            System.exit(0);
        }catch (NoSuchElementException e){
            System.err.println("Input File is Empty");
            e.printStackTrace();
            System.exit(0);
        }
        return sc;
    }
    public void closeScanner(Scanner sc){
        sc.close();
    }
     /**
     * @param scanner
     * @return String- return the line on which scanner has requested
     */
    public String[] readLine(Scanner scanner){
            String[]temp=scanner.nextLine().split(" ");
            return temp;
    }
    /**
     * @param string
     */
    public void Write(String string){
       try {
        if(myFileWriter==null){
            myFileWriter=new FileWriter(filePath,false);
        }
            myFileWriter.write(string);
    } catch (IOException e) {
        System.err.println("File Path is not found for writing the file");
        e.printStackTrace();
        System.exit(0);
    }       
 }
     
    public void colseFileWriter(){
        try {
            if(myFileWriter==null) return;
            myFileWriter.close();
        } catch (IOException e) {
            System.err.println("Writer is not created to close it");
            e.printStackTrace();
            System.exit(0);
        }
     }
}
