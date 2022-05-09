package DS_ETC4;
//자료구조 과제 #4 60211646 김민수

public class main {
    public static void main(String[] args) {
        changePostfixNotation("A-B+C/D");
        changePostfixNotation("A/B-C*D");
        changePostfixNotation("A-B*C+D/E-F");
        changePostfixNotation("(A-B)*C-(D/(E+F))");
        changePostfixNotation("(A+B)*(C-D)");
    }
    public static void changePostfixNotation(String s){
        ListStack ls = new ListStack<>();
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            int priority = priority(s.charAt(i));
            switch (s.charAt(i)){
                case '*':
                case '/':
                case '+':
                case '-':
                    while (!ls.isEmpty() && priority((Character) ls.peek())>= priority)
                        output+=ls.pop();
                    ls.push(s.charAt(i));
                    break;
                case '(':
                    ls.push(s.charAt(i));
                    break;
                case ')':
                    while(!ls.isEmpty() && !ls.peek().equals('('))
                        output+=ls.pop();
                    ls.pop();
                    break;
                default:
                    output+=s.charAt(i);
            }
        }
        int size = ls.size();
        for (int i = 0; i < size; i++) {
            output+=ls.pop();
        }
        System.out.println(output);
    }
    public static int priority(char ch){
        switch (ch){
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}
