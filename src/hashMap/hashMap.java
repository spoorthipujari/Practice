package hashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quikr on 24/04/18.
 */
public class hashMap<K,V> {
    ArrayList<HashNode<K,V>> map = new ArrayList<>();
    int numOfbuckets = 10;
    int size = 0;

    private int getBucketIndex(K key){
        return key.hashCode()%numOfbuckets;
    }

    public V remove(K key){
        HashNode<K,V> head = map.get(getBucketIndex(key));
        HashNode<K,V> prev = null;
        while(head!=null){
            if(head.key == key)
                break;
            prev = head;
            head = head.next;
        }

        if(head == null)
            return null;

        if(prev == null)
            map.set(getBucketIndex(key),head.next);
        else
            prev.next = head.next;

        return head.value;
    }

    public V get(K key){
        HashNode<K,V> head = map.get(getBucketIndex(key));
        while(head!=null){
            if(head.key == key)
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value){
        HashNode<K,V> hashNode = new HashNode<K, V>(key,value);
        int bucketIndex = getBucketIndex(key);

        if(map.get(bucketIndex) == null)
            map.add(hashNode);
        else{
            HashNode head = map.get(bucketIndex);
            while(head.next!=null)
                head = head.next;
            head.next = hashNode;
        }
    }
}
