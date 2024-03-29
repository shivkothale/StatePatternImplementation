# CSX42: Assignment 3
## Name: Shivkumar Subhash Kothale

# Using 2 Slack Days 2 Remaining
-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCourseSequencer/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCourseSequencer/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCourseSequencer/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:  ant -buildfile studentCourseSequencer/src/build.xml run -Darg0=input.txt -Darg1=Output.txt -Darg2=errorLog.txt -Darg3=LEVEL -Darg4=dummy

## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:


Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
   I am parsing a course and checking for the given conditions and then assigning or adding it to waitList.
   WaitList is processed every time after processing a course and assigned according to given conditions.
   I have used ArraysList as a data structure to maintain the waitList.
   
   Processing WaitList- checkWaitListMethod()-This method handles the waitlist for courses, iterating through the list and attempting to assign courses to students from the waitlist. It checks conditions for course assignment, manages semester limits, and updates assigned courses while handling waitlist entries until all eligible courses are assigned or until the conditions are met.
   
   Driver: This code sets up a course registration. It takes command-line arguments for input, output, and error files, creates instances of necessary classes (CourseRegistration and Results), reads data from the input file, and handles output and error handling before closing file writing operations.

   Student Context: This code orchestrates course registration for a student. It iterates through preferences, attempting to register the student for each course. It manages the sequencing, updates student details based on the process, handles semester information, and ultimately writes the student's details to some output (results).

   CourseSequencer Helper: This method manages course assignments for a student. It checks for state changes, assigns courses based on certain conditions, handles group numbers, manages a semester list, and handles waitlisting if necessary. The method also accounts for maximum course limits per semester and updates state changes as needed.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date:  16/11/2023.


