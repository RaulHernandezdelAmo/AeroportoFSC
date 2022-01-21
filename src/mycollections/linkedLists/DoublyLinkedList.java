/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections.linkedLists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Raul
 */
public class DoublyLinkedList<E> implements Iterable<E>{
    //---------BEGIN of nested class NODE
    protected static class Node<E>{
        private E element; //reference to the element stored in this node
        private Node<E> prev; //reference of the previous element on the list
        private Node<E> next; //reference of the subsequent element on the list
        public Node(E e, Node<E> p, Node<E> n){
            element =e;
            prev = p;
            next = n;
        }
        
        public E getElement(){ return element;}
        public Node<E> getPrev(){ return prev;}
        public Node<E> getNext(){ return next;}
        public void setPrev(Node<E> p){ prev = p;}
        public void setNext(Node<E> n){ next = n;}
        public void setElement(E e){ element = e;}
    }
    //---------END of nested class NODE
    
    //instance atributes if the SinglyListedList
    protected Node<E> header = null;
    protected Node<E> trailer = null;
    private int size = 0;
    
    // constructor
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    //access methods
    public int size(){return size; }
    public boolean isEmpty(){
        return size==0;
    }
    public E last(){
        return trailer.getPrev().getElement();
    }
    public E first(){
        return header.getNext().getElement();
    }
    
    //update methods
    protected void addBetween(E e, Node<E> predeccesor, Node<E> succesor){
        Node<E> newest = new Node<>(e, predeccesor, succesor);
        predeccesor.setNext(newest);
        succesor.setPrev(newest);
        size++;
    }
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
        size++;
    }
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
        size++;
    }
    protected E remove(Node<E> node){
        Node<E> predeccesor = node.getPrev();
        Node<E> succesor = node.getNext();
        predeccesor.setNext(succesor);
        succesor.setPrev(predeccesor);
        size--;
        return node.getElement();
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext()); //remove first element beyond header
    }
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev()); //remove first element beyond header
    }
    
     @Override
    public Iterator<E> iterator(){
        return new DLLIterator();
    }
    
    //----------- BEGIN of nested class
    private class DLLIterator implements Iterator<E>{
        private Node<E> cursor = header.getNext();
        
        @Override
        public boolean hasNext(){
            return cursor != trailer;
        }
        
        @Override
        public E next(){
            if(cursor == trailer) throw new NoSuchElementException("No next element");
            Node<E> current = cursor;
            cursor = cursor.getNext();
            return current.getElement();
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    
    //----------- END of nested class
}
