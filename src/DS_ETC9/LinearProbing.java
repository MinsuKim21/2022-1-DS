package DS_ETC9;
//자료구조#9_60211646_김민수
public class LinearProbing<K,V> {
    private int cnt;
    private int M = 11; //테이블 크기
    private K[] a = (K[]) new Object[M]; //해시테이블
    private V[] d = (V[]) new Object[M]; //key 관련데이터
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수
    }
    private void put(K key,V data){
        int initialpos = hash(key);
        int i = initialpos, j=1;
        do {
            if (a[i] == null){
                a[i]=key;
                d[i]=data;
                return;
            }
            if (a[i].equals(key)){
                d[i] = data;
                return;
            }
            i =(initialpos + j++)%M;
            ++cnt;
            System.out.println("충돌: "+cnt);
        }while (i!= initialpos);
    }
    public V get(K key){
        int initialpos = hash(key);
        int i = initialpos, j =1;
        while  (a[i] != null){
            if (a[i].equals(key))
                return d[i];
            i=(initialpos+j++)%M;
        }
        return null;
    }
    public static void main(String[] args) {
        LinearProbing t = new LinearProbing();

        t.put(71,"grape"); t.put(23,"apple");t.put(73,"banana");
        t.put(49,"orange"); t.put(54,"watermelon");t.put(89,"kiwi");
        t.put(39,"mango");

        System.out.println("탐색 결과 :");
        System.out.println("50의 data ="+t.get(50));
        System.out.println("63의 data ="+t.get(63));
        System.out.println();

        System.out.println("해시 테이블:");
        for (int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
        System.out.println();
        for (int i =0;i<t.M;++i) System.out.print("\t"+t.a[i]);
        System.out.println();
    }
}

