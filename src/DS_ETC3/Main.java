package DS_ETC3;

import java.util.EmptyStackException;

//자료구조 과제#3 60211646 김민수
public class Main {
    public static void main(String[] args) {
        rightBracket("{{(){()}}}");
        rightBracket("{{(){()})()}");
    }

    public static void rightBracket(String s) {
        ListStack ls = new ListStack<>();
        int index = 1;
        try {
            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case '(':
                    case '{':
                        ls.push(s.charAt(j));
                        break;
                    case '}':
                        if (ls.peek().compareTo('{') == 0)
                            ls.pop();
                        else throw new EmptyStackException();
                        break;
                    case ')':
                        if (ls.peek().compareTo('(') == 0)
                            ls.pop();
                        else throw new EmptyStackException();
                        break;
                }
                index++;
            }
            if (ls.size() == 0) {
                System.out.println("모든 괄호의 짝이 맞습니다.");
            } else
                System.out.println(index - 1 + "번째 괄호 \"" + s.charAt(index - 2) + "\"가 맞지 않습니다.");// index가 1부터 시작하고 index++ 연산자에 걸려서 -2해야함.
        } catch (EmptyStackException e) {
            System.out.println(index + "번째 괄호 \"" + s.charAt(index - 1) + "\"가 맞지 않습니다. 에러코드 : " + e);
        }
    }
}
