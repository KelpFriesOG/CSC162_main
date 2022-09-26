package labs;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed = SLOW;

    private boolean on = false;
    private double radius = 5;
    String color = "blue";

    public Fan() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String str = "";
        str = str + "The color of the fan is: " + this.color
                + "\nThe speed of the fan is: " + this.speed +
                "\nThe radius of the fan is: " + this.radius
                + "\nThe fan is is turned " + (this.on ? "on" : "off");
        return str;
    }

    public static void main(String[] args) {
        Fan myFan = new Fan();
        System.out.println(myFan.toString());
    }

}
