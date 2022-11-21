package notes;


public class CarTesting {
    public static void main(String []args){
        Car car = new Car("Ford", 2002, "kelpscar", 100000);
        Car car2 = new Car("GMC", 2015, "somecar", 50000);
        
        System.out.println(car2.compareTo(car2));


        System.out.println(car.getBrand());
    }
}
