package DS_ETC9;
//자료구조#9_60211646_김민수
public class QuadProbing <K,V>{
    private int N = 0, M = 13; //테이블 크기
    private K[] a = (K[]) new Object[M]; //해시테이블
    private V[] d = (V[]) new Object[M]; //key 관련데이터
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수
    }
    private void put(K key, V data){
        int initalpos = hash(key);
        int i = initalpos, j =1;
        do{
            if (a[i]==null){
                a[i]= key;
                d[i] = data;
                N++;
                return;
            }
            if (a[i].equals(key)){
                d[i] = data;
            }
            i = (initalpos + j*j++)%M;
        }while(N<M);
    }
    public V get(K key){
        int initialpos = hash(key);
        int i = initialpos, j =1;
        while  (a[i] != null){
            if (a[i].equals(key))
                return d[i];
            i=(initialpos+j*j++)%M;
        }
        return null;
    }
    public static void main(String[] args) {
        QuadProbing t = new QuadProbing();

        t.put(25,"grape"); t.put(37,"apple");t.put(18,"banana");
        t.put(50,"orange"); t.put(63,"watermelon");
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
