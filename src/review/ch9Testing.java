package review;

public class ch9Testing {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // If an object does not have a constructor, it has a default
        // constructor. We do not need to make a constructor if we do not
        // plan on passing any arguments.
        // If we plan on having a version of the Dog that accepts a name,
        // but we still want the default constructor WE NEED TO EXPLICITLY
        // code in the default constructor.

        Zoo dog2 = new Dog();
        // This works due to polymorphism!
        // The Zoo class is a parent of the polymorphic class

        dog.eat();
        dog2.eat();
        // This call illustrates that regardless whether the object
        // is initialized as a Dog (non-implicitly) or initialized
        // implicitly as a dog, the compiler is smart enough to understand
        // that in both instances an OBJECT of type DOG was called.
    }
}
