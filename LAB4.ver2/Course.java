package LinkedList;

public class Course {
    static LinkedList<String> courseCodes = new LinkedList<String>();
    static LinkedList<String> courseNames = new LinkedList<String>();
    static LinkedList<Integer> creditHours = new LinkedList<Integer>();
    static LinkedList<String> grades = new LinkedList<String>();

    public static void main(String[] args) {
        // Insert course information into the linked lists
        courseCodes.addLast("WXX101");
        courseNames.addLast("Programming");
        creditHours.addLast(5);
        grades.addLast("B");

        courseCodes.addLast("WXX201");
        courseNames.addLast("Networking");
        creditHours.addLast(4);
        grades.addLast("C");

        courseCodes.addLast("WXX301");
        courseNames.addLast("Operating System");
        creditHours.addLast(3);
        grades.addLast("A");

        displayList();
    }

    public static void displayList() {
        System.out.println("The list consists of:");

        System.out.println("Course: " + courseCodes.get(0) + " (" + courseNames.get(0) + ") "  + creditHours.get(0) + " credit hours" + " Grade: " + grades.get(0) + " (" + getGradePoint(grades.get(0)) + ")");
        System.out.println("Course: " + courseCodes.get(1) + " (" + courseNames.get(1) + ") "  + creditHours.get(1) + " credit hours" + " Grade: " + grades.get(1) + " (" + getGradePoint(grades.get(1)) + ")");
        System.out.println("Course: " + courseCodes.get(2) + " (" + courseNames.get(2) + ") "  + creditHours.get(2) + " credit hours" + " Grade: " + grades.get(2) + " (" + getGradePoint(grades.get(2)) + ")");


        int totalCredit = creditHours.get(0) + creditHours.get(1) + creditHours.get(2);
        double totalPoints = (getGradePoint(grades.get(0)) * creditHours.get(0))
                            + (getGradePoint(grades.get(1)) * creditHours.get(1))
                            + (getGradePoint(grades.get(2)) * creditHours.get(2));

        double gradePointAverage = totalPoints / totalCredit;

        System.out.println("Total Points: " + totalPoints);
        System.out.println("Total Credit: " + totalCredit);
        System.out.printf("Grade Point Average: %.2f\n", gradePointAverage);
    }

    public static int getGradePoint(String grade) {
        switch (grade) {
            case "A":
                return 4;
            case "B":
                return 3;
            case "C":
                return 2;
            case "D":
                return 1;
            default:
                return 0;
        }
    }
}
