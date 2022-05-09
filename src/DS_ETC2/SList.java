package DS_ETC2;

import DS_4.DNode;

import java.util.NoSuchElementException;

// 자료구조 과제#2 60211646 김민수

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

    public void insertAfter(E newItem, Node p) {
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

    public SList mergeLists(Node p1, Node p2) {
        SList output = new SList<>();
        Node n = null;

        while(p1.getItem() != null || p2.getItem() != null){
            if (p1.getItem().compareTo(p2.getItem())>0){
                if (output.head== null){
                    output.insertFront(p2.getItem());
                    n = output.head;
                }else{
                    output.insertAfter(p2.getItem(),n);
                    n = n.getNext();
                }
                p2 = p2.getNext();
            }else {
                if (output.head== null){
                    output.insertFront(p1.getItem());
                    n = output.head;
                }else{
                    output.insertAfter(p1.getItem(),n);
                    n = n.getNext();
                }
                p1 = p1.getNext();
            }
//            System.out.println(n.getItem());
        }
        return output;
    }

    public void splitList(Node p, int k, SList l1, SList l2) { //l1,l2 조건문으로 나눠서 각각 head값이 =null인지 판단
        Node n1 = null;
        Node n2 = null;
        for (p = head; p != null; p = p.getNext()) {
            if (p.getItem().compareTo(k) <= 0) {
                if (l1.head == null) {
                    l1.insertFront(p.getItem());
                    n1 = l1.head;
                } else {
                    l1.insertAfter(p.getItem(), n1);
                    n1 = n1.getNext();
                }
            } else {
                if (l2.head == null) {
                    l2.insertFront(p.getItem());
                    n2 = l2.head;
                } else {
                    l2.insertAfter(p.getItem(), n2);
                    n2 = n2.getNext();
                }
            }
        }

    }
}