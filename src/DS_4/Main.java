package DS_4;

//자료구조 #4 출석과제 김민수 60211646
public class Main {
    public static void main(String[] args) {
        SList<String> s = new SList<>();
        s.insertFront("orange"); s.insertFront("apple");
        s.insetAfter("cherry",s.head.getNext());
        s.insertFront("pear");

        s.print();
        System.out.println(": s의 길이 ="+s.size()+"\n");

        System.out.println("체리가 \t"+s.search("cherry")+"번째에 있다.");
        System.out.println("키위가 \t"+s.search("kiwi")+"번째에 있다.");

        s.deleteAfter(s.head);
        s.print();
        System.out.println(": s의 길이 = "+s.size()+"\n");

        s.deleteFront();
        s.print();
        System.out.println(": s의 길이 = "+s.size()+"\n");

        s.deleteFront();
        s.deleteFront();
        s.print();
        System.out.println(": s의 길이 = "+s.size()+"\n");

        DList<String> dList = new DList<>();
        dList.insertAfter(dList.head,"apple"); dList.print();
        dList.insertBefore(dList.tail,"orange"); dList.print();
        dList.insertBefore(dList.tail,"cherry"); dList.print();
        dList.insertAfter(dList.head.getNext(),"pear"); dList.print();

        dList.delete(dList.tail.getPrevious()); dList.print();

        dList.insertBefore(dList.tail,"grape"); dList.print();

        dList.delete(dList.head.getNext()); dList.print();
        dList.delete(dList.head.getNext()); dList.print();
        dList.delete(dList.head.getNext()); dList.print();
        dList.delete(dList.head.getNext()); dList.print();
    }
}
