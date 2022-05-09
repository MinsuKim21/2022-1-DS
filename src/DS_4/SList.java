package DS_4;
//자료구조 #4 출석과제 김민수 60211646
import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {
    protected Node head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public int search(E target) {
        Node p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem())
                return k;
            p = p.getNext();
        }
        return -1;
    }

    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }

    public void insetAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (Node p = head; p != null; p = p.getNext())
            System.out.print(p.getItem() + "\t ");
        System.out.println();
    }
}
