import java.util.Deque;
import java.util.LinkedList;

public class queue {
  public static void main(String[] args) {
    Deque<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);

    System.out.println("Queue: " + queue);

    int removedElement = queue.remove();
    System.out.println("Removed element: " + removedElement);
    System.out.println("Queue after removal: " + queue);

    int peekedElement = queue.peek();
    System.out.println("Peeked element: " + peekedElement);
  }
}
