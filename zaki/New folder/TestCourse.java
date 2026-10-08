public class Course {
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new String[4];
        this.numberOfStudents = 0;
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }

    // Add student
    public void addStudent(String student) {

        // If array is full, create a larger array
        if (numberOfStudents >= students.length) {

            String[] newStudents = new String[students.length * 2];

            // Copy old students
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }

            students = newStudents;
        }

        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    // Drop student
    public void dropStudent(String student) {

        for (int i = 0; i < numberOfStudents; i++) {

            if (students[i].equals(student)) {

                // Move remaining students one position left
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[numberOfStudents - 1] = null;
                numberOfStudents--;

                return;
            }
        }
    }

    // Get students
    public String[] getStudents() {

        String[] currentStudents = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            currentStudents[i] = students[i];
        }

        return currentStudents;
    }

    // Get number of students
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}

public class TestCourse {

    public static void main(String[] args) {

        // Create Course
        Course course = new Course("Java Programming");

        // Add students
        course.addStudent("Abdighafar");
        course.addStudent("Ahmed");
        course.addStudent("Mohamed");
        course.addStudent("Hassan");
        course.addStudent("Ali");

        // Display course name
        System.out.println("Course Name: " + course.getCourseName());

        // Display students
        System.out.println("\nStudents:");

        String[] students = course.getStudents();

        for (String student : students) {
            System.out.println("- " + student);
        }

        // Display number of students
        System.out.println("\nNumber of Students: "
                + course.getNumberOfStudents());

        // Drop a student
        course.dropStudent("Ahmed");

        // Display after dropping
        System.out.println("\nAfter dropping Ahmed:");

        students = course.getStudents();

        for (String student : students) {
            System.out.println("- " + student);
        }

        System.out.println("\nNumber of Students: "
                + course.getNumberOfStudents());
    }
}