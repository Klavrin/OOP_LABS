import java.util.LinkedList;

public class LinkQueue<T> implements Queue<T> {
  private final LinkedList<T> queue = new LinkedList<>();

  @Override
  public void enqueue(T item) {
    queue.addLast(item);
  }

  @Override
  public T dequeue() {
    if (queue.isEmpty()) {
      return null;
    }
    return queue.removeFirst();
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public int size() {
    return queue.size();
  }
}
