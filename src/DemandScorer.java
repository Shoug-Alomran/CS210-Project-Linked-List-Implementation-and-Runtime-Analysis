public class DemandScorer {
    public static void computeDemandScore(Registration reg) {
        double score = 50; // Base score

        score = applyStudentClassMultiplier(score, reg.getAcademicLevel());
        score = applyTimePreferenceMultiplier(score, reg.getStudTime());
        score = applyCoursePriority(score, reg.getCourseID());
   
        score = Math.round(score); // Round to nearest whole number.
        score = Math.max(0, Math.min(100, score)); // Stop between 0-100.

        reg.setStudDemandScore(score); // Save the final score to the Registration object.
    }

    private static double applyStudentClassMultiplier(double score, int studentClass) {

        if (studentClass == 1) {
            score = score * 0.75; // Freshman bonus
        } else if (studentClass == 2) {
            score = score * 0.90; // Sophomore bonus
        } else if (studentClass == 3) {
            score = score * 1.10; // Junior bonus
        } else if (studentClass == 4) {
            score = score * 1.25; // Senior bonus
        } else if (studentClass == 5) {
            score = score * 1.5; // Graduate bonus
        }
        return score;
    }

    public static double applyTimePreferenceMultiplier(double score, int time) {
        if (time >= 6 && time < 8) {
            score += 5;
        } else if (time >= 8 && time < 10) {
            score += 10; // 8:00 - 10:00: +10
        } else if (time >= 10 && time < 12) {
            score += 5; // 10:00 - 12:00: +5
        } else if (time >= 12 && time < 14) {
            score += 0; // 12:00 - 14:00: No change.
        } else if (time >= 14 && time < 16) {
            score -= 5; // 14:00 - 16:00: -5
        } else if (time >= 16 && time < 20) {
            score -= 10; // 16:00 - 20:00: -10
        } else {
            score -= 15; // After 20:00: -15 (also covers 0-6 AM).
        }
        return score;
    }

    private static double applyCoursePriority(double score, String courseID) {
        // Get the last character of the course code.
        char lastChar = courseID.charAt(courseID.length() - 1);

        // Check if it's a digit and whether it's odd/even.
        if (Character.isDigit(lastChar)) {
            int lastDigit = Integer.parseInt(String.valueOf(lastChar)); // Convert char to int
            if (lastDigit % 2 == 1) { // Odd number.
                score += 20;
            } else { // Even number.
                score -= 10;
            }
        }
        return score;
    }
}
