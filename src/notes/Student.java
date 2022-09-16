package notes;

public class Student {

    private Course[] courseList;
    private String name;

    public String getName() {
        return name;
    }

    public Student(String name) {
        this.courseList = new Course[100];
        this.name = name;
        // According to UML diagram a student can take infinite # of courses!
    }

    public Student(Course[] courses) {
        courseList = courses;
    }

    public void addCourse(Course c) {
        int i = 0;
        while (courseList[i] != null) {
            i++;
        }
        if (i < courseList.length) {
            courseList[i] = c;
        } else {
            System.out.println("The student cannot take any more courses!");
        }
    }
}
