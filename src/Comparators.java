import java.util.Comparator;

public final class Comparators {
    // Private constructor to prevent instantiation (utility class)

    private Comparators() {
    }

    // Comparator to sort Registration by studentId (ascending)
    public static final Comparator<Registration> by_ID = new Comparator<Registration>() {
        @Override
        public int compare(Registration r1, Registration r2) {
            return r1.getStudentID().compareTo(r2.getStudentID());
        }
    };

    // Comparator to sort Registration by courseCode (A–Z)
    public static final Comparator<Registration> by_CourseCode = new Comparator<Registration>() {
        @Override
        public int compare(Registration r1, Registration r2) {
            return r1.getCourseID().compareTo(r2.getCourseID());
        }
    };
    // Comparator to sort Registration by academicLevel (ascending)
    public static final Comparator<Registration> by_Level = new Comparator<Registration>() {
        @Override
        public int compare(Registration r1, Registration r2) {
            return Integer.compare(r1.getAcademicLevel(), r2.getAcademicLevel());
        }
    };

    // Comparator to sort Registration by regTime (ascending)
    public static final Comparator<Registration> by_RegTime = new Comparator<Registration>() {
        @Override
        public int compare(Registration r1, Registration r2) {
            return Integer.compare(r1.getRegTime(), r2.getRegTime());
        }
    };

    // Static helper to get comparator by user choice (e.g., "id", "name",
    // "course")
    public static Comparator<Registration> getComparator(String criterion) {
        switch (criterion.toLowerCase()) { // Case insensitive matching
            case "id":
                return by_ID;
            case "course":
                return by_CourseCode;
            case "level":
                return by_Level;
            case "time":
                return by_RegTime;
            default:
                throw new IllegalArgumentException("Unknown sorting criterion: " + criterion);
        }
    }

}
