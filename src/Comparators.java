import java.util.Comparator;

public final class Comparators {
    // Task: Private constructor to prevent instantiation (utility class)
   
    private Comparators() {
    }

    // Task: Comparator to sort Registration by studentId (ascending)
    
    public static final Comparator<Registration> by_ID = new Comparator<Registration>() {
            @Override
            public int compare(Registration r1, Registration r2) {
                return r1.getStudentID().compareTo(r2.getStudentID());
            }
        } ;
    
      // Task: Comparator to sort Registration by name (A–Z)
    public static final Comparator<Registration> by_Name = new Comparator<Registration>() {
            @Override
            public int compare(Registration r1, Registration r2) {
                // Assuming Registration has a getName() method
                return r1.getStudentID().compareTo(r2.getStudentID());
            }
        } ;
    // Task: Comparator to sort Registration by courseCode (A–Z)
    public static final Comparator<Registration> by_Course = new Comparator<Registration>() {
            @Override
            public int compare(Registration r1, Registration r2) {
                return r1.getCourseID().compareTo(r2.getCourseID());
            }
        } ;
    // Task: (Optional) Comparator to sort by score/grade (descending)
    public static final Comparator<Registration> by_Score_Descending = new Comparator<Registration>() {
            @Override
            public int compare(Registration r1, Registration r2) {
                return Double.compare(r2.getStudDemandScore(), r1.getStudDemandScore());
            }
        } ;

        // Task: Static helper to get comparator by user choice (e.g., "id", "name", "course")
    public static Comparator<Registration> getComparator(String criterion) {
        switch (criterion.toLowerCase()) {
            case "id":
                return by_ID;
            case "name":
                return by_Name;
            case "course":
                return by_Course;
            case "score":
                return by_Score_Descending;
            default:
                    throw new IllegalArgumentException("Unknown sorting criterion: " + criterion);  
            }
        }
    }



