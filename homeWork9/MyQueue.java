package homeWork9;


public class MyQueue<T> {

    private class Node<T>{
        private final T element;
        public Node(T element) {
            this.element = element;
        }
        private Node<T> next;
        private Node<T> prev;
    }
    private Node<T> first;
    private Node<T> second;

    private int size = 0;

    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if(first == null){
            first = second = newNode;
        }
        else{
            second.next = newNode;
            newNode.prev = second;
            second = newNode;

        }
        size++;
        return true;
    }

    public T poll() {
        Node<T> elementToRemove = first;
        if (size > 1) {
            first = first.next;
            first.prev = null;
        } else {
            first = second = null;
        }
        size--;
        return elementToRemove.element;
    }

    public T peek() {
        return first.element;
    }

    public int size() {
        return size;
    }


    public int clear() {
        size = 0;
        first = second = null;
        return 0;
    }


    public static void main(String[] args) {
        MyQueue <String> myQ = new MyQueue<String>();
        System.out.println(myQ.add("aaa"));
        System.out.println(myQ.add("bbb"));
        System.out.println(myQ.add("ccc"));
        System.out.println(myQ.add("fff"));
        System.out.println(myQ.add("ggg"));
        System.out.println(myQ.add("hhh"));
        System.out.println(myQ.peek());
        System.out.println(myQ.poll());
        System.out.println(myQ.size);
        System.out.println(myQ.clear());
    }
}

