package DS_ETC2;

// 자료구조 과제#2 60211646 김민수

public class Main {
    public static void main(String[] args) {
        SList<Integer> s1 = new SList<>();
        s1.insertFront(50);
        s1.insertFront(40);
        s1.insertFront(30);
        s1.insertFront(20);
        s1.insertFront(10);

        s1.print();

        SList<Integer> s2 = new SList<>();
        s2.insertFront(55);
        s2.insertFront(37);
        s2.insertFront(35);
        s2.insertFront(18);
        s2.insertFront(15);

        s2.print();

        SList<Integer> s3 = new SList<>();
        s3 = s3.mergeLists(s1.head, s2.head);
        s3.print();

        SList<Integer> s4 = new SList<>();
        SList<Integer> s5 = new SList<>();
        s3.splitList(s3.head, 20, s4, s5);

        s4.print();
        s5.print();
    }
}
