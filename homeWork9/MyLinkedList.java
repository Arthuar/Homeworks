package homeWork9;

import java.util.Objects;

public class MyLinkedList<T>{
    private class Node<T>{
        T element;

       public Node(T element) {
            this.element = element;
        }


        Node<T> next;
        Node<T> prev;
    }
    private Node<T> first;
    private Node<T> last;

    private  int size;

    public int size() {
        return size();
    }


    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if(first == null){
            first = last = newNode;
        }
        else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;

        }
        size++;

        return true;
    }

    public boolean clear() {
        size = 0;
        System.out.println(size);
        return true;
    }
    public T get(int index) {
        Objects.checkIndex(index,size);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return  current.element;
    }


    public T remove(int index) {
        Objects.checkIndex(index,size);
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException("wrong number");
        }
        Node<T> removeElement = first;//0,1,2,3
        while (index>0){//4 нам треба 4 елемент
            index--;//3,2,1
            removeElement=removeElement.next;//1,2,3
        }
        if(removeElement==first){
            first.next.prev=null;
            first=first.next;
            return removeElement.element;
        }
        if(removeElement == last){
            last.prev.next = null;
            last = last.prev;
        }
        else {
            removeElement.next.prev = removeElement.prev;
            removeElement.prev.next = removeElement.next;
        }
        size--;
        return removeElement.element;

    }

    public static void main(String[] args) {
        MyLinkedList<String> myL = new MyLinkedList<String>();
        System.out.println(myL.add("aaa"));
        System.out.println(myL.add("bbb"));
        System.out.println(myL.add("ccc"));
        System.out.println(myL.add("ddd"));
        System.out.println(myL.add("eee"));
        System.out.println(myL.add("hhh"));
        System.out.println(myL.size);
        System.out.println(myL.get(2));
        System.out.println(myL.remove(0));
        System.out.println(myL.get(1));
        System.out.println(myL.size);
        System.out.println(myL.clear());

    }
}














