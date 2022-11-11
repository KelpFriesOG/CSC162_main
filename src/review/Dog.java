package review;

public class Dog extends Zoo {
    public Dog() {

    }

    public Dog(String name) {
        super(name);
    }

    public void eat() {
        System.out.println("Eating (from the child class)");
    }
}
