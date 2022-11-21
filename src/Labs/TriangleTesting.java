package labs;

public class TriangleTesting {

    public static void main(String[] args) {
        try {
            Triangle tri = new Triangle(15, 60, 30, "blue", true);
            System.out.println(tri.getArea());
        } catch (IllegalTriangleException e) {
            System.out.println("Impossible triangle!");
            // e.printStackTrace();
        }

    }
}
