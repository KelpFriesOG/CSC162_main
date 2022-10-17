package labs;

public class TriangleTesting {

    public static void main(String[] args) {
        try {
            Triangle tri = new Triangle(5, 6, 13, "blue", true);
        } catch (IllegalTriangleException e) {
            System.out.println("Impossible triangle!");
        }
    }
}
