/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections;

import java.util.Comparator;

/**
 *
 * @author Raul
 */
public abstract class AbstractMap<K, V> implements Map<K, V>{
    public boolean isEmpty(){return size()==0;}
    
    //Definition of internal classes
    /**
     * A nested Entry class
     * providing a composite for storing key-value entries in a map data structure
     */
    
    protected static class Entry<K, V>{
        private K k;
        private V v;
        
        public Entry(K key, V value){
            k = key;
            v = value;
        }
        //public methods
        public K getKey(){return k;}
        public V getValue(){return v;}
        public void setKey(K key){k=key;}
        public V setValue(V value){
            V old = v;
            v = value;
            return old;
        }
    }//end of entry class
    
    /**comparator of Entries that uses the natural orden of Keys*/
    protected static class DefaultEntryComparator<K, V> implements Comparator<Entry<K, V>>{
        @Override
        public int compare(Entry<K, V> a, Entry <K, V> b) throws ClassCastException{
            return ((Comparable<K>) a.getKey()).compareTo(b.getKey());
        }
    }
    
    /**comparator of Entries that uses the comparator of given keys*/
    protected static class EntryComparator<K, V> implements Comparator<Entry<K, V>>{
        private Comparator<K> comp;
        public EntryComparator(Comparator<K> cmp){comp=cmp;}
        @Override
        public int compare(Entry<K, V> a, Entry <K, V> b){
            return comp.compare(a.getKey(), b.getKey());
        }
    }
}
