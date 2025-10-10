public class Registration {
// Task: Field to store student ID
  private String studentID;
// Task: Field to store course code
  private String courseID;
// Task: Field to store class/group
  private int academicLevel; 
// Task: Field to store time
  private int studTime;
// Task: Field to store demand score
  private double studDemandScore;

// Task: Constructor to initialize fields
    public Registration(String studentID, String courseID, int academicLevel, int studTime, double studDemandScore) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.academicLevel = academicLevel;
        this.studTime = studTime;
        this.studDemandScore = 0;//temporary value prior to processing demand score (score hasn't been recorded yet)
    }
// Task: Getters and setters for all fields
    public String getStudentID() {
        return studentID;
    }
  
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(int academicLevel) {
        this.academicLevel = academicLevel;
    }

    public int getStudTime() {
        return studTime;
    }

    public void setStudTime(int studTime) {
        this.studTime = studTime;
    }

    public double getStudDemandScore() {
        return studDemandScore;
    }

    public void setStudDemandScore(double studDemandScore) {
        this.studDemandScore = studDemandScore;
    }
// Task: toString() method to format output line
     @Override
    public String toString() {
        return studentID + ";" + courseID + ";" + academicLevel + ";" + studTime + ";" + Math.round(studDemandScore) + ";";
    }//Math.round function used to round the demand score to the nearest whole number
  
}
