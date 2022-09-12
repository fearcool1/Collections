public interface CarQueue<T> extends CarCollection<T>{

    boolean add();

    T peek();

    T poll();
}
