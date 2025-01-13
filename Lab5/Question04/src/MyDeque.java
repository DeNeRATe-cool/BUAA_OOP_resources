import java.util.LinkedList;

public class MyDeque<T> {
    private final LinkedList<T> elements;

    public MyDeque() {
        this.elements = new LinkedList<>();
    }

    public void addFirst(T element) {
        elements.addFirst(element);
    }

    public void addLast(T element) {
        elements.addLast(element);
    }

    public T removeFirst() {
        T element = elements.getFirst();
        elements.removeFirst();
        return element;
    }

    public T removeLast() {
        T element = elements.getLast();
        elements.removeLast();
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T element : elements) {
            sb.append(element.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque);

        deque.removeFirst();

        System.out.println(deque);

        deque.removeLast();

        System.out.println(deque);

    }
}