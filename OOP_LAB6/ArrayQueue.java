import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<T> implements Queue<T> {
    private final List<T> queue = new ArrayList<>();

    @Override
    public void enqueue(T item) {
      queue.add(item);
    }

    @Override
    public T dequeue() {
      if (queue.isEmpty()) {
        return null;
      }
      return queue.remove(0);
    }

    public boolean isEmpty() {
      return queue.isEmpty();
    }

    public int size() {
      return queue.size();
    }
}
