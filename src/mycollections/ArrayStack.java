/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Raul
 */
public class ArrayStack<E> implements Stack<E> {
    private static int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    
    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size(){
        return (t+1);
    }
    
    @Override
    public boolean isEmpty(){
        return (t==-1);
    }
    
    @Override
    public void push(E e) throws IllegalStateException{
        if(size() == data.length) throw new IllegalStateException("Stack is full!");
        data[++t] = e;
    }
    
    
    @Override
    public E top(){
        if(isEmpty()) return null;
        return data[t];
    }
    
    @Override
    public E pop(){
        if(isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    
    
    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    
    //----------- BEGIN of nested class
    private class ArrayIterator implements Iterator<E>{
        private int j = 0;
        
        @Override
        public boolean hasNext(){
            return j < size();
        }
        
        @Override
        public E next(){
            if(j == size()) throw new NoSuchElementException("No next element");
            return data[j++];
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    
    //----------- END of nested class
}
