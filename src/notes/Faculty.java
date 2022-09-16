package notes;

public class Faculty {
    private Course[] courseList;
    private String name;

    public Faculty(String name) {
        this.name = name;
        this.courseList = new Course[3];
        // According to UML diagram each faculty can teach
        // a maximum of 3 courses
    }

    public Faculty(Course[] courseList) {
        this.courseList = courseList;
        this.name = "Default";
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course c) {
        // Adds a course to the courseList (if possible)

        int i = 0;
        while (courseList[i] != null) {
            i++;
        }
        if (i < courseList.length) {
            courseList[i] = c;
        } else {
            System.out.println("The teacher cannot take any more courses!");
        }
    }

    public boolean isOverloaded() {
        // If faculty has more than 3 courses, returns true!

        int nCourses = 0;

        for (int i = 0; i < courseList.length; i++) {
            if (courseList[i] != null) {
                nCourses++;
            }
        }

        boolean overloaded = nCourses > 3 ? true : false;

        return overloaded;
    }
}
