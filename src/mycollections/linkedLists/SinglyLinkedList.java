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
public class SinglyLinkedList<E> implements Iterable<E>{
    //---------BEGIN of nested class NODE
    private static class Node<E>{
        private E element; //reference to the element stored in this node
        private Node<E> next; //reference of the subsequent element on the list
        public Node(E e, Node<E> n){
            element =e;
            next = n;
        }
        
        public E getElement(){ return element;}
        public Node<E> getNext(){ return next;}
        public void setNext(Node<E> n){ next = n;}
    }
    //---------END of nested class NODE
    
    //instance atributes if the SinglyListedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    // default constructor
    public SinglyLinkedList(){}
    
    //access methods
    public int size(){return size; }
    public boolean isEmpty(){
        return size==0;
    }
    public E last(){
        if(isEmpty()){
            return null;
        }else{
            return tail.getElement();
        }
    }
    public E first(){
        if(isEmpty()){
            return null;
        }else{
            return head.getElement();
        }
    }
    
    //update methods
    public void addFirst(E e){
        head = new Node<>(e, head); //create and Link a new Node
        if(size==0){
            tail = head; //special case: new node becomes tail also
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()){
            head = newest;
        }else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0){
            tail=null;
        }
        return answer;
    }
    
    @Override
    public Iterator<E> iterator(){
        return new SLLIterator();
    }
    
    //----------- BEGIN of nested class
    private class SLLIterator implements Iterator<E>{
        private Node<E> cursor = head;
        
        @Override
        public boolean hasNext(){
            return cursor != null;
        }
        
        @Override
        public E next(){
            if(cursor == null) throw new NoSuchElementException("No next element");
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
