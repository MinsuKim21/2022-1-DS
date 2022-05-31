package DS_ETC9;
//자료구조#9_60211646_김민수
public class DoubleHashing <K,V>{
    private int N = 0, M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] dt = (V[]) new Object[M];
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void put(K key, V data){
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        int d = (7-(int)key %7);
        do {
            if (a[i] == null){
                a[i]  = key;
                dt[i] = data; N++;
                return;
            }
            if (a[i].equals(key)){
                dt[i] = data;
                return;
            }
            i = (initialpos+j*d)%M;
            j++;
        } while (N<M);
    }
    public V get(K key){
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        int d = (7-(int)key % 7);
        while (a[i] != null){
            if(a[i].equals(key))
                return dt[i];
            i = (initialpos + j*d)%M;
            j++;
        }
        return null;
    }
    public static void main (String[] args){
        DoubleHashing t = new DoubleHashing();

        t.put(25,"grape"); t.put(37,"apple"); t.put(18,"bananna");
        t.put(55,"cherry");t.put(22,"mango"); t.put(35,"lime");
        t.put(50,"orange"); t.put(63,"watermelon");

        System.out.println("탐색 결과");
        System.out.println("50의 data = " + t.get(50));
        System.out.println("63의 data = " + t.get(63));

        System.out.println(); System.out.println("해시 테이블:");
        for (int i=0; i<t.M;++i) System.out.printf("\t%2d", i);
        System.out.println();
        for (int i =0; i<t.M;++i) System.out.print("\t"+t.a[i]);
        System.out.println();
    }
}
