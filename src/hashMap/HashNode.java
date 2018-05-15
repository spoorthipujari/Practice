package hashMap;

/**
 * Created by quikr on 24/04/18.
 */
public class HashNode<K,V> {
    K key;
    V value;
    HashNode next;

    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
