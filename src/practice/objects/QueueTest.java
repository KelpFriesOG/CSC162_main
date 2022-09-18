package practice.objects;

public class QueueTest {
    public static void main(String[] args) {

        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        // Debug starting from i = 8 to see how
        // the queue doubles in capacity automatically.

        System.out.println("The first value in the queue was: " + queue.dequeue());
        System.out.println("The second value in the queue was: " + queue.dequeue());
        System.out.println("The queue's size is now: " + queue.getSize());

        System.out.println("The queue looks like: ");
        System.out.println(queue.toString());

    }
}
