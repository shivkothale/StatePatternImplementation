package courseSequencer.stateMgmt;

import java.util.Scanner;

import courseSequencer.util.FileProcessor;
import courseSequencer.util.Results;

public class CourseRegistration {
    /**
     * @param filePath
     * @param results
     */
    public void readFile(String filePath,Results results){
        FileProcessor fProcessor=new FileProcessor(filePath);
        Scanner sc=fProcessor.getFileReader();
        StudentContext sContext=new StudentContext();
        while(sc.hasNextLine()){
            String []list=fProcessor.readLine(sc);
            sContext.registerCourses(list,results);
        }
        fProcessor.closeScanner(sc);
    }

}
