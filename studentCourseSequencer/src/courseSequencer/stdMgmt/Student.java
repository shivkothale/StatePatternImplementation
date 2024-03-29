package courseSequencer.stdMgmt;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private String id;
    private List<String> subjects=new ArrayList<>();
    private int sems=0;
    public int stateChanges=0;
    public boolean graduated;
    public int getStateChanges() {
        return stateChanges;
    }
    public void setStateChanges(int stateChanges) {
        this.stateChanges = stateChanges;
    }
    public boolean isGraduated() {
        return graduated;
    }
    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }
    public int getSems() {
        return sems;
    }
    public void setSems(int sems) {
        this.sems += sems;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    @Override
    public String toString() {
        String string="Graduated";
        if(!graduated){
            sems=0;
            string="Cannot Graduate";

        }
        return id +" " +subjects +"  --  "+sems+" "+ + stateChanges+"  "+string;
    }
    
    
}