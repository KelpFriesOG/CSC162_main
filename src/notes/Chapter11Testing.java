package notes;

import java.util.Scanner;

import labs.Triangle;

public class Chapter11Testing {
        public static void main(String[] args) {

                // #region Testing the Triangle class

                Scanner kbd = new Scanner(System.in);

                System.out.println("Lets create a triangle! ");

                System.out.println("What should be the length of side 1?: ");
                double side1 = kbd.nextDouble();
                System.out.println("What should be the length of side 2?: ");
                double side2 = kbd.nextDouble();
                System.out.println("What should be the length of side 3?: ");
                double side3 = kbd.nextDouble();

                System.out.println("What color should the triangle be? :");
                String color = kbd.next();

                System.out.println("Should the triangle be filled? (Enter 'y' or 'n')");
                String filled = kbd.next();
                boolean isFilled = filled == "y" ? true
                                : filled == "n" ? false
                                                : true;

                try {
                        Triangle triangle = new Triangle(side1, side2, side3, color, isFilled);
                        System.out.println(triangle.toString());
                        System.out.println("The triangle's color is : "
                                        + triangle.getColor());
                        System.out.println("Is the triangle filled? "
                                        + triangle.isFilled());

                        System.out.println("The triangle's perimeter is "
                                        + triangle.getPerimeter());

                        System.out.println("The triangle's area is "
                                        + triangle.getArea());
                } catch (Exception e) {
                        e.printStackTrace();
                }

                // #endregion

                kbd.close();

        }
}
