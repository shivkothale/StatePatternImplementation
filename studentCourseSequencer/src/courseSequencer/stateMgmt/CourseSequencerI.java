package courseSequencer.stateMgmt;

import courseSequencer.util.Results;

public interface CourseSequencerI {
    public void attempt2RegisterCourse(String courseName,CourseSequencerHelper helper,Results results);
    public void changeGroup(CourseSequencerHelper helper);

}
