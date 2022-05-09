package DS_6;

public class main {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();
//        queue.add("apple"); queue.print();
//        queue.add("orange"); queue.print();
//        queue.add("cherry"); queue.print();
//        queue.add("pear"); queue.print();
//
//        queue.remove(); queue.print();
//
//        queue.add("grape"); queue.print();
//
//        queue.remove(); queue.print();
//
//        queue.add("lemon"); queue.print();
//        queue.add("mango"); queue.print();
//        queue.add("lime"); queue.print();
//        queue.add("kiwi"); queue.print();
//
//        queue.remove(); queue.print();
        test("110100111",4);
    }
    static int test(String s,int N){
        if(N<0){
            return 0;
        }
        if (s.charAt(N)=='0'){
            return 2*test(s,N-1);
        }
        return 1 + 2 * test(s,N-1);
    }
}
