package DS_ETC5;
//자료구조 과제#5 60211646 김민수
import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node newRoot) {
        root = newRoot;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void preorder(Node n) {
        if (n != null) {
            System.out.print(n.getKey() + " "); //노드 n 방문
            preorder(n.getLeft()); // n의 왼쪽 서브트리 순회
            preorder(n.getRight()); //n의 오른쪽 서브트리 순회
        }
    }

    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft()); // n의 왼쪽 서브트리 순회
            System.out.print(n.getKey() + " ");  //노드 n 방문
            inorder(n.getRight()); //n의 오른쪽 서브트리 순회
        }
    }

    public void postorder(Node n) {
        if (n != null) {
            postorder(n.getLeft()); // n의 왼쪽 서브트리 순회
            postorder(n.getRight()); // n의 오른쪽 서브트리 순회
            System.out.print(n.getKey() + " ");  // 노드 n 방문
        }
    }
    public void levelorder(Node root) {
        // 큐 자료구조 이용
        Queue<Node> q = new LinkedList<Node>();
        Node t;

        q.add(root); //루트 노드를 큐에 삽입
        while (!q.isEmpty()) {
            t = q.remove();  //큐의 맨앞 노드 제거
            System.out.print(t.getKey() + " "); //제거 노드 출력(방문)

            if (t.getLeft() != null)
                q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
            if (t.getRight() != null)
                q.add(t.getRight());  // 큐에 오른쪽 자식 삽입
        }
    }
    public int size(Node n){
        if(n== null)
            return 0;  //null이면 0리턴
        else
            return (1+ size(n.getLeft())+ size(n.getRight()));
    }
    public int height(Node n){
        if(n==null)
            return 0;  //null이면 0리턴
        else
            return (1+Math.max(height(n.getLeft()),
                    height(n.getRight())));
    }
    public static boolean isEqual(Node n, Node m){
        //둘다 null이면 true, 아니면 false
        if(n==null || m==null)
            return n==m;

        //둘다 null이 아니면 item 비교
        if(n.getKey().compareTo(m.getKey()) !=0)
            return false;

        //item이 같으면 왼쪽/오른쪽 자식으로 재귀 호출
        return(isEqual(n.getLeft(), m.getLeft())&&
                isEqual(n.getRight(), m.getRight()));
    }
    public Node DeepCopy(Node n){
        if (n != null){
            Node l = DeepCopy(n.getLeft());
            Node r = DeepCopy(n.getRight());
            return new Node(n.getKey(), l, r);
        }
        return n;
    }
}