package DS_5;

//자료구조#5주차 출석과제 60211646 김민수
public class Main {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");
        stack.print();

        System.out.println(stack.peek());
        stack.push("pear");
        stack.print();

        stack.pop();
        stack.print();

        System.out.println(stack.peek());
        stack.push("grape");
        stack.print();

        System.out.println("------------------------------");

        ListStack<String> st = new ListStack<>();
        st.push("apple");
        st.push("orange");
        st.push("cherry");
        st.print();

        System.out.println(st.peek());
        st.push("pear");
        st.print();

        st.pop();
        st.print();

        System.out.println(st.peek());
        st.push("grape");
        st.print();
    }
}
