package ss10_dsa_list.bai_tap.array_list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    static final int DEFAULT_CAPACITY=10;
    Object[] elements;
    public MyList(){
        this.elements=new Object[DEFAULT_CAPACITY];
    }
    MyList(int capacity){
        if (capacity>=0){
            this.elements= new Object[capacity];
        }else {
            throw new IllegalArgumentException("capacity" + capacity);
        }
    }
    public int getSize(){
        return this.size;
    }
    public void clear(){
        elements= new Object[DEFAULT_CAPACITY];
        size=0;
    }
    public boolean add(E element){
        if(elements.length == size){
            this.ensureCapacity(10);
        }
        elements[size]=element;
        size++;
        return true;
    }
    public boolean add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            ensureCapacity(size + 1);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity){
        if(minCapacity > 0){
            int newSize= Math.max(minCapacity,elements.length*2);
            elements= Arrays.copyOf(elements,newSize);
        }else {
            throw new IllegalArgumentException("minCapacity "+minCapacity);
        }
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return oldValue;
    }
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int size() {
        return size;
    }
    @Override
    public MyList<E> clone() {
        MyList<E> newList = new MyList<>(elements.length);
        newList.size = this.size;
        newList.elements = Arrays.copyOf(this.elements, this.elements.length);
        return newList;
    }

}
