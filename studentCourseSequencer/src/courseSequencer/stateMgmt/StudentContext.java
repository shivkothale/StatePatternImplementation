package courseSequencer.stateMgmt;

import courseSequencer.stdMgmt.Student;
import courseSequencer.util.Results;

public class StudentContext {

    CourseSequencerI currentState=new StateOne();
    public void registerCourses(String studentPref[],Results results) {
        
        CourseSequencerHelper courseSequencerHelper=new CourseSequencerHelper();
        Student student=new Student();
        for(int i=1;i<studentPref.length;i++){
            courseSequencerHelper.setCurrentState(currentState);
            currentState.attempt2RegisterCourse(studentPref[i], courseSequencerHelper,results);
            currentState.changeGroup(courseSequencerHelper);
            setCurrentState(courseSequencerHelper.getCurrentState());
        }
        if(courseSequencerHelper.getSem().size()!=0){
             courseSequencerHelper.getSemisters().add(courseSequencerHelper.getSem());
        }
        student.setId(studentPref[0]);
        student.setStateChanges(courseSequencerHelper.getStatesChanged());
        student.setSubjects(courseSequencerHelper.getSubjectsAssigned());
        student.setSems(courseSequencerHelper.getSemisters().size());
        student.setGraduated(courseSequencerHelper.addAllCourses());
        results.writeResult(student.toString());

    }
    private void setCurrentState(CourseSequencerI currentState2) {
        currentState=currentState2;
    }
}
