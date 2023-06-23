package homeWork9;

import java.util.*;

public class MyArrayList<T>  {
    private Object[] elements = new Object[8];
    private int size;

    public int size() {
        return size;
    }



    public boolean add(T element) {
        resize();
        elements[size] = element;
        size++;
        return true;
    }
    private void resize(){

        if(elements.length == size){
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }


    public void clear() {
        size = 0;
        elements = new Object[8];
    }


    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }


    @SuppressWarnings("uncheked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T rElement = (T) elements[index];
        System.arraycopy(elements, index +1, elements, index,size - index -1);
        size--;
        return rElement;
    }

    public static void main(String[] args) {
        MyArrayList <String> arList = new MyArrayList<String>();

        System.out.println(arList.add("Artur"));
        System.out.println(arList.add("Oksana"));
        System.out.println(arList.add("Eugen"));
        System.out.println(arList.add("Volody"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("Stepan"));
        System.out.println(arList.add("asdfad"));
        System.out.println(arList.get(13));
        System.out.println(arList.get(3));
        System.out.println(arList.size());
        System.out.println(arList.remove(3));
        System.out.println(arList.size());
        System.out.println(arList.get(14));
        System.out.println(arList);
    }
}
