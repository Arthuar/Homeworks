package homeWork9;


public class MyStack<T> {

    private class Node<T>{
        T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element) {
            this.element = element;
        }
    }
    private Node<T> first;
    private Node<T> second;
    private int size ;

    public void push(T elements) {
        Node<T> newNode = new Node<T>(elements);
        if(first == null){
            first = second = newNode;
        }
        else{
            second.next = newNode;
            newNode.prev = second;
            second = newNode;
        }
        size++;
    }


    public T pop() {
        Node <T> remElement = second;
        second = second.prev;
        return remElement.element;
    }


    public T peek() {
        return second.element;
    }


    public int size() {
        return size;
    }


    public T remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException ("wrong number of index!!!");
        }
        Node<T> remElem = first;
        for (int i = 0; i < index ; i++) {
            remElem=remElem.next;
        }
        if(remElem == first){
            first.next.prev = null;
            first = first.next;
            return remElem.element;
        }
        if(remElem == second){
            second.prev.next = null;
        }
        else{
            remElem.next.prev=remElem.prev;
            remElem.prev.next = remElem.next;
        }
        size--;
        return remElem.element;
    }


    public int clear() {
        size = 0;
        first = second = null;
        return 0;
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("aaa");
        myStack.push("bbb");
        myStack.push("ccc");
        System.out.println(myStack.first.element);
        System.out.println(myStack.first.next.element);
        System.out.println(myStack.first.next.next.element);
        System.out.println(myStack.size);
        System.out.println(myStack.remove(1));
        System.out.println(myStack.first.element);
        System.out.println(myStack.first.next.element);
        System.out.println(myStack.clear());
    }

}
