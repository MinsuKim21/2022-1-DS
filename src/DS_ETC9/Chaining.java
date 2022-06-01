package DS_ETC9;
//자료구조#9_60211646_김민수
public class Chaining <K,V> {
    private int N = 0, M = 11;
    private Node[] a = new Node[M];

    public static class Node {
        private Object key;
        private Object data;
        private Node next;

        public Node(Object newKey, Object newdata, Node ref) {
            key = newKey;
            data = newdata;
            next = ref;
        }

        public Object getKey() {
            return key;
        }

        public Object getData() {
            return data;
        }
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next)
            if (key.equals(x.key))
                return (V) x.data;
        return null;
    }

    private void put(K key, V data) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.data = data;
                return;
            }
        a[i] = new Node(key, data, a[i]);
    }

    public static void main(String[] args) {
        Chaining t = new Chaining();

        t.put(71,"grape"); t.put(23,"apple");t.put(73,"banana");
        t.put(49,"orange"); t.put(54,"watermelon");t.put(89,"kiwi");
        t.put(39,"mango");

        System.out.println("탐색 결과");
        System.out.println("50의 data = " + t.get(50));
        System.out.println("63의 data = " + t.get(63));
        System.out.println("37의 data = " + t.get(37));
        System.out.println("22의 data = " + t.get(22));

        System.out.println();
        System.out.println("해시 테이블:");
        for (int i = 0; i < t.M; ++i) {
            System.out.print(String.format("%2d", i));
            Node x = t.a[i];
            while (x != null){
                System.out.print("-->["+x.getKey()+", "+x.getData()+"]");
                x = x.next;
            }
            System.out.println();
        }
    }
}


