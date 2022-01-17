/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections;

import java.util.Iterator;
import mycollections.linkedLists.SinglyLinkedList;

/**
 *
 * @author Raul
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    
    public LinkedStack(){}
    
    @Override
    public int size(){
        return list.size();
    }
    
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public E top(){
        return list.first();
    }
    
    @Override
    public void push(E element){
        list.addFirst(element);
    }
    
    @Override
    public E pop(){
        return list.removeFirst();
    }   
        
    @Override
    public Iterator<E> iterator(){
        return list.iterator();
    }
}
