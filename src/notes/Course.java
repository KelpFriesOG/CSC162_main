package notes;

import java.util.Arrays;

public class Course {
    private Student[] classList;
    private Faculty faculty;
    private int numberOfStudents = 0;
    private String courseName;

    // #region Constructors
    public Course(String courseName, Faculty faculty) {
        this.courseName = courseName;
        this.faculty = faculty;
        classList = new Student[60];
        // According to UML diagram each course has 1 teacher
        // and a max of 60 students
    }

    // #endregion

    // #region Getters and Setters
    public Student[] getClassList() {
        return classList;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty.getName();
    }

    public String getCourseName() {
        return courseName;
    }

    // #endregion

    // #region Methods
    public void addStudent(Student s) {
        classList[numberOfStudents] = s;
        numberOfStudents++;
    }

    public void dropStudent(Student s) {
        for (int i = 0; i < classList.length; i++) {
            if (classList[i] == s) {
                System.arraycopy(classList, i + 1, classList, i,
                        classList.length - i - 1);
                classList = Arrays.copyOf(classList, classList.length - 1);
            }
        }
    }

    public String getStudents() {
        String students = "";
        for (int i = 0; i < numberOfStudents; i++) {
            students = students + classList[i].getName() + ", ";
        }

        return students;
    }

    public boolean isQualified() {
        // If the course has more than 60 or less than 5 students
        // returns false

        int nStudents = 0;
        for (int i = 0; i < classList.length; i++) {
            if (classList[i] != null) {
                nStudents++;
            }
        }

        boolean qualified = (faculty != null) && (5 <= nStudents && nStudents <= 60)
                ? true
                : false;

        return qualified;
    }

    // #endregion
}
