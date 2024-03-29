package courseSequencer.stateMgmt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import courseSequencer.util.Results;
public class CourseSequencerHelper {
    public CourseSequencerHelper(){
        subjects.add(group1);
        subjects.add(group2);
        subjects.add(group3);
        subjects.add(group4);
        subjects.add(group5);
    }
    public List<String> waitList=new ArrayList<>();
    private List<List<String>> subjects=new ArrayList<>();
    private List<String> group1=Arrays.asList("A","B","C","D");//
    private List<String> group2=Arrays.asList("E","F","G","H");//
    private List<String> group3=Arrays.asList("I","J","K","L");//
        private List<String> group4=Arrays.asList("M","N","O","P");
    private List<String> group5=Arrays.asList("Q","R","S","T","U","V","V","W","X","Y","Z");//
    private int state=0;
    
    public void setSubjectsAssigned(List<String> subjectsAssigned) {
        this.subjectsAssigned = subjectsAssigned;
    }
    public List<String> getSem() {
        return sem;
    }
    public void setSem(List<String> sem) {
        this.sem = sem;
    }
    public void setSemisters(List<List<String>> semisters) {
        this.semisters = semisters;
    }
    public CourseSequencerI getCurrentState() {
        return currentState;
    }
    public void setCurrentState(CourseSequencerI currentState) {
        this.currentState = currentState;
    }
    public int getStatesChanged() {
        return statesChanged;
    }
    public void setStatesChanged(int statesChanged) {
        this.statesChanged = statesChanged;
    }

    private List<String> subjectsAssigned=new ArrayList<>();
    private List<String>sem=new ArrayList<>();
    private int group1Courses=0;
    private int group2Courses=0;
    private int group3Courses=0;
    private int group4Courses=0;
    private int group5Courses=0;
    private List<List<String>> semisters=new ArrayList<>();
    private CourseSequencerI currentState;
    private int max=group1Courses;
    private int group=state;
    private int statesChanged=0;
    
    public List<String> getSubjectsAssigned() {
        return subjectsAssigned;
    }
    public List<List<String>> getSemisters() {
        return semisters;
    }
    public boolean addAllCourses() {
        if(group1Courses>=2 && group2Courses>=2 && group3Courses>=2 && group4Courses>=2 && group5Courses>=2){
            return true;
        }
        return false;

    }
    /**
     * @param groupNumber
     */
    private void increaseGroupCount(int groupNumber) {
        if(groupNumber==0)group1Courses++;
        else if(groupNumber==1)group2Courses++;
        else if(groupNumber==2)group3Courses++;
        else if(groupNumber==3)group4Courses++;
        else if(groupNumber==4)group5Courses++;
    }
    /**
     * @param s
     * @return
     */
    private int getGroup(String s) {
       for(int i=0;i<subjects.size();i++){
            if(subjects.get(i).contains(s)){
                return i;
            }
       }
        return -1;
    }
    /**
     * @param courseName
     * This method manages course assignments for a student. It checks for state changes,
     *  assigns courses based on certain conditions, handles group numbers,
     *  manages a semester list, and handles waitlisting if necessary. 
     * The method also accounts for maximum course limits per semester and updates state changes as needed.
     */
    public void assignCourses(String courseName,Results results) {
       // checkWaitList();
        checkForStateChange();
         if(addAllCourses()){
                return;
        }
            if(sem.size()>=3){
                semisters.add(sem);
                sem=new ArrayList<>();
                
            }
            int groupNumber=getGroup(courseName);
            if(groupNumber==-1){
                System.err.println("Course not found in any of the groups");
                results.writeError("Course "+courseName+ " not found in any of the groups");
                results.colseFileWriter();
                System.exit(0);

            }
            if(groupNumber==4){
                if(sem.size()<3){
                    sem.add(courseName);              
                }else{
                    semisters.add(sem);
                    sem=new ArrayList<>();
                    sem.add(courseName);
                }
                subjectsAssigned.add(courseName);
                increaseGroupCount(groupNumber);
            }else{
                int index=subjects.get(groupNumber).indexOf(courseName);
                if(index==0){
                    if(sem.size()<3){
                            sem.add(courseName);
                        }else{
                            semisters.add(sem);
                            sem=new ArrayList<>();
                            sem.add(courseName);
                        }
                        subjectsAssigned.add(courseName);
                        increaseGroupCount(groupNumber);
                }else{
                    if(subjectsAssigned.contains(subjects.get(groupNumber).get(index-1))&& !sem.contains(subjects.get(groupNumber).get(index-1))){
                        if(sem.size()<3){
                            sem.add(courseName);
                        }else{
                            semisters.add(sem);
                            sem=new ArrayList<>();
                            sem.add(courseName);
                        }
                        subjectsAssigned.add(courseName);
                        increaseGroupCount(groupNumber);
                    }else{
                        waitList.add(courseName);
                    }
                }
            }
            if(sem.size()>=3){
                semisters.add(sem);
                sem=new ArrayList<>();
            }
           checkForStateChange();
            

    }
    public void checkForStateChange() {
        
        if(group1Courses>max){
            max=group1Courses;
            group=0;
        }
        if(group2Courses>max){
            max=group2Courses;
            group=1;
        }
        if(group3Courses>max){
            max=group3Courses;
            group=2;
        }
        if(group4Courses>max){
            max=group4Courses;
            group=3;
        }
        if(group5Courses>max){
            max=group5Courses;
            group=4;
        }
         switch (group) {
            case 0:
                if(state!=group){
                    currentState=new StateOne();
                    state=group;
                    statesChanged++;
                }
                break;
            
            case 1:
                if(state!=group){
                    currentState=new StateTwo();
                    state=group;
                    statesChanged++;
                }
                break;
            case 2:
                if(state!=group){
                    currentState=new StateThree();
                    state=group;
                    statesChanged++;
                }
                break;
            
            case 3:
                if(state!=group){
                    currentState=new StateFour();
                    state=group;
                    statesChanged++;
                }
                break;
            
            case 4:
                if(state!=group){
                    currentState=new StateFive();
                    state=group;
                    statesChanged++;
                }
                break;
            
            default:
                break;
        }
    }
    public void checkWaitList() {
        int i=0;
            while(i<waitList.size()){
                boolean flag=false;
                if(addAllCourses()){
                return;
                }
                if(sem.size()>=3){
                semisters.add(sem);
                sem=new ArrayList<>();
                }   
                 int groupNumber=getGroup(waitList.get(i));
                 int index=subjects.get(groupNumber).indexOf(waitList.get(i));
                 
                if(subjectsAssigned.contains(subjects.get(groupNumber).get(index-1))&& !sem.contains(subjects.get(groupNumber).get(index-1))){
                    if(sem.size()<3){
                            sem.add(waitList.get(i));
                    }else{
                            semisters.add(sem);                     
                            sem=new ArrayList<>();
                            
                            sem.add(waitList.get(i));
                    }
                    subjectsAssigned.add(waitList.get(i));
                    increaseGroupCount(groupNumber);
                    waitList.remove(waitList.get(i));
                    flag=true;
                }if(!flag){
                    i++;  
                }  
                  
            }
    }
                                                                                                                                    
}
