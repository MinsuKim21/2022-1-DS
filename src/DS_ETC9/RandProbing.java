package DS_ETC9;
//자료구조#9_60211646_김민수
import java.util.Random;

public class RandProbing <K,V>{
    private int N = 0, M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] dt = (V[]) new Object[M];
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void put(K key, V data){
        int initialpos = hash(key);
        int i = initialpos;
        Random rand = new Random();
        rand.setSeed(10);
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
            i = (initialpos+ rand.nextInt(1000))%M;
        } while (N<M);
    }
    public V get(K key){
        Random rand = new Random();
        rand.setSeed(10);
        int initialpos = hash(key);
        int i = initialpos;
        while (a[i] != null){
            if(a[i].equals(key))
                return dt[i];
            i = (initialpos + rand.nextInt(1000))%M;
        }
        return null;
    }
    public static void main (String[] args){
        RandProbing t = new RandProbing();

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
