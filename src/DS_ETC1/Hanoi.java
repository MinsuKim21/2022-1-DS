//자료구조 과제 #1 60211646 김민수
package DS_ETC1;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        num = scanner.nextInt();
        String start = "A";
        String sub = "B";
        String end = "C";
        System.out.println("원반이 " + num + "개인 경우\n(원반 이름:크기가 작은-큰 순서 1-2-3)\n");
        hanoi(num, start, end, sub);
    }

    static void hanoi(int num, String start, String end, String sub) {
        if (num == 1) {
            System.out.println("원반 " + num + "을 " + start + "에서 " + end + "로 이동");
            return;
        }
        hanoi(num - 1, start, sub, end);
        System.out.println("원반 " + num + "을 " + start + "에서 " + end + "로 이동");
        hanoi(num - 1, sub, end, start);
    }
}


