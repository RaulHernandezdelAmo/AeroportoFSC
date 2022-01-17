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
public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size(){
        return sz;
    }
    
    @Override
    public boolean isEmpty(){
        return (sz==0);
    }
    
    @Override
    public E first(){
        if(isEmpty()) return null;
        return data[f];
    }
    
    @Override
    public void enqueue(E element) throws IllegalStateException{
        if(sz == data.length) throw new IllegalStateException("Queue is full!");
        int avail = (f+sz)%data.length;
        data[avail] = element;
        sz++;
    }
    
    @Override
    public E dequeue(){
        if(isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        sz--;
        return answer;
    }
    
        @Override
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    
    //----------- BEGIN of nested class
    private class ArrayIterator implements Iterator<E>{
        private int j = 0;
        
        public ArrayIterator(){
            if(sz==0){
                j = data.length;
            }else j=f;
        }
        
        @Override
        public boolean hasNext(){
            return j != data.length;
        }
        
        @Override
        public E next(){
            if(j == data.length) throw new NoSuchElementException("No next element");
            int j_actual = j;
            j = (j+1)%data.length;
            if(j==(f+sz)%data.length){
                j = data.length;
            }
            return data[j_actual];
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    
    //----------- END of nested class
    
}
