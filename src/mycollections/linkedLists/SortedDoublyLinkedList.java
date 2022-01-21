/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections.linkedLists;

import java.util.Comparator;

/**
 *
 * @author Raul
 */
public class SortedDoublyLinkedList<E> extends DoublyLinkedList<E> {
    private Comparator<E> comp;
    private static class DefaultComparator<E> implements Comparator<E>{
        @Override
        public int compare(E a, E b) throws ClassCastException{
            return ((Comparable<E>) a).compareTo(b);
        }
    }
    
    public SortedDoublyLinkedList(){
        this(new DefaultComparator<E>());
    }
    
    public SortedDoublyLinkedList(Comparator<E> othercmp){
        super();
        comp=othercmp;
    }
    
    private Node<E> ceilingNode(E e){
        Node<E> n=header.getNext();
        while(n!=trailer && comp.compare(e, n.getElement())>0){
            n=n.getNext();
        }
        return n;
    }
    
    public E find(E e){
        Node<E> n = ceilingNode(e);
        if(n!=trailer && comp.compare(e, n.getElement())==0){
            return n.getElement();
        }else return null;
    }
    
    public void add(E e){
        Node<E> n = ceilingNode(e);
        addBetween(e, n.getPrev(), n);
    }
    
    @Override
    public void addFirst(E e){
        throw new UnsupportedOperationException("Insertion method not supported in Sorted list");
    }
    
    @Override
    public void addLast(E e){
        throw new UnsupportedOperationException("Insertion method not supported in Sorted list");
    }
    
    public E put(E e){
        Node<E> n = ceilingNode(e);
        if(n!=trailer && comp.compare(e, n.getElement())==0){
            E old = n.getElement();
            n.setElement(e);
            return old;
        }else{
            addBetween(e, n.getPrev(), n);
            return null;
        }
    }
    
    public E remove (E e){
        Node<E> n = ceilingNode(e);
        if(n!= trailer && comp.compare(e, n.getElement()) == 0){
            return remove(n);
        }else{ return null;}
    }
    
    
}
