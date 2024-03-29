package courseSequencer.stateMgmt;

import courseSequencer.util.Results;

public class StateTwo implements CourseSequencerI{

    @Override
    public void attempt2RegisterCourse(String courseName, CourseSequencerHelper helper,Results results) {
      
        helper.assignCourses(courseName,results);
        if(helper.waitList.size()!=0){
            helper.checkWaitList();
        }
    }

    @Override
    public void changeGroup(CourseSequencerHelper helper) {
            helper.checkForStateChange();
        
    }

   
}
