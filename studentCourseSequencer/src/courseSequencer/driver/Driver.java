package courseSequencer.driver;

import courseSequencer.stateMgmt.CourseRegistration;
import courseSequencer.util.Results;


public class Driver {
    public static void main(String[] args) {
        if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
		 		 || args[3].equals("${arg3}") || args[4].equals("${arg4}")) {
		 	System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
		 	System.exit(0);
        }
        CourseRegistration courseRegistration=new CourseRegistration();
        String input=args[0];
        String output=args[1];
        String error=args[2];
        Results results=new Results(output,error);
        courseRegistration.readFile(input,results);
        results.colseFileWriter();
        
   }
}