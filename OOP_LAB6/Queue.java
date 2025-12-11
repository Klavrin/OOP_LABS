public interface Queue<T> {
  abstract void enqueue(T item);
  abstract T dequeue();
}
