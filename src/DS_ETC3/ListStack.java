package DS_ETC3;
//자료구조 과제#3 60211646 김민수

import java.util.EmptyStackException;

public class ListStack<E extends Comparable<E>> {
    private Node<E> top;
    private int size;

    public ListStack() {
        top = null;
        size = 0;
    }

    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.getItem();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E newItem) {
        Node newNode = new Node(newItem, top);
        top = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        E topItem = top.getItem();
        top = top.getNext();
        size--;
        return topItem;
    }

    public void print() {
        System.out.print("top =  ");
        Node p = top;
        while (p != null) {
            if (p.getNext() != null) {
                System.out.print(p.getItem() + "  ->  ");
            } else {
                System.out.print(p.getItem());
            }
            p = p.getNext();
        }
        System.out.println();
    }
}
