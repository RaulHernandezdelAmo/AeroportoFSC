/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections;

import java.util.Comparator;
import java.util.Iterator;
import mycollections.linkedLists.SortedDoublyLinkedList;

/**
 *
 * @author Raul
 */
//Dictionary based on DLL sorted
public class LinkedMap<K, V> extends AbstractMap<K, V> {
    private SortedDoublyLinkedList<Entry<K, V>> list;
    
    //create a sorted DLL based on the natural ordering of its keys
    public LinkedMap(){
        list = new SortedDoublyLinkedList<>(new DefaultEntryComparator<K,V>());
    }
    
    //create a sorted DLL used the given comparator to order keys
    public LinkedMap(Comparator<K> comp){
        list = new SortedDoublyLinkedList<>(new EntryComparator<K,V>(comp));
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public V get(K key) {
        Entry<K, V> e = new Entry<>(key, null);
        Entry<K, V> f = list.find(e);
        if(f==null) return null;
        else return f.getValue();
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> e = new Entry<>(key, value);
        Entry<K, V> f = list.put(e);
        if(f==null) return null;
        else return f.getValue();
    }

    @Override
    public V remove(K key) {
        Entry<K, V> e = new Entry<>(key, null);
        Entry<K, V> f = list.remove(e);
        if(f==null) return null;
        else return f.getValue();
    }


    public class KeyIterator implements Iterator<K>{
        private Iterator<Entry<K,V>> entries = list.iterator();
        public boolean hasNext(){ return entries.hasNext();}
        public K next(){return entries.next().getKey();}
        public void remove(){ throw new UnsupportedOperationException();}
        
    }
    private class KeyIterable implements Iterable<K>{
        public Iterator<K> iterator(){return new KeyIterator();}
        
    }
    
    public Iterable<K> keySet(){return new KeyIterable();}
    
}
