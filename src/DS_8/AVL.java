package DS_8;

public class AVL <Key extends Comparable<Key>, Value> {
    public Node root;
    public void put(Key k, Value v){root = put(root, k,v);}

    private Node put(Node n, Key k, Value v) {
        if( n == null) return new Node(k,v,1);

        int t = k.compareTo((Key)n.getKey());
        if  (t<0) n.setLeft(put(n.getLeft(),k,v));
        else if (t>0) n.setRight(put(n.getRight(),k,v));
        else{
            n.setValue(v);
            return n;
        }
        n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight()))+1);

        return balance(n);
    }

    private int tallerHeight(int x, int y) {
        if (x>y) return x;
        else return y;
    }

    private Node balance(Node n) {
        if (bf(n)>1){
            if (bf(n.getLeft())<0){
                n.setLeft(rotateLeft(n.getLeft()));//LR 회전
            }
            n = rotateRight(n) ;//LL 회전
        }
        else if (bf(n)<-1){
            if (bf(n.getRight())>0){
                n.setRight(rotateRight(n.getRight()));
            }
            n = rotateLeft(n);
        }
        return n;
    }

    private Node rotateRight(Node n) {
        Node x = n.getLeft();
        n.setLeft(x.getRight());
        x.setRight(n);
        n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight()))+1);
        x.setHeight(tallerHeight(height(x.getLeft()), height(x.getRight()))+1);
        return x;
    }

    private Node rotateLeft(Node n) {
        Node x = n.getRight();
        n.setRight(x.getLeft());
        x.setLeft(n);
        n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight()))+1);
        x.setHeight(tallerHeight(height(x.getLeft()), height(x.getRight()))+1);
        return x;
    }

    private int bf(Node n) {
        return height(n.getLeft()) - height(n.getRight());
    }

    private int height(Node n) {
        if (n == null )return 0;
        return n.getHeight();
    }

    public void delete(Key k){root = delete(root, k);}
    private Node delete(Node n, Key k){
        if (n==null) return null;

        int t = n.getKey().compareTo(k);
        if (t > 0)
            n.setLeft(delete(n.getLeft(), k));
        else if (t < 0)
            n.setRight(delete(n.getRight(), k));
        else {
            if (n.getRight() == null)
                return n.getLeft();
            if (n.getLeft() == null)
                return n.getRight();

            Node target = n;
            n = min(target.getRight());
            n.setLeft(deleteMin(n.getLeft()));
            n.setLeft(target.getLeft());
        }
        return balance(n);
    }
    public Key min() {
        if (root == null) return null;

        return (Key) min(root).getKey();
    }

    private Node min(Node n) {
        if (n.getLeft() == null) return n;

        return min(n.getLeft());
    }

    public void deleteMin() {
        if (root == null) System.out.println("empty 트리");

        root = deleteMin(root);
    }

    public Node deleteMin(Node n) {
        if (n.getLeft() == null)
            return n.getRight();

        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }
}
