package DS_4;
//자료구조 #4 출석과제 김민수 60211646
 import java.util.NoSuchElementException;

public class DList<E> {
    protected DNode head, tail;
    protected int size;

    public DList() {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    public void delete(DNode x) {
        if (x == null) throw new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

    public void print() {
        DNode q = tail;
        for (DNode p = head; p != null; p = p.getNext()) {
            if (p.getItem() != null) {
                System.out.print(p.getItem() + "\t ");
                continue;
            }
            if (p.getNext()==q.getPrevious().getItem())
                System.out.println("리스트 비어있음");
            System.out.println();
        }
    }
}
