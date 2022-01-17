/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Arrays;
import java.util.Iterator;
import mycollections.ArrayDeque;
import mycollections.ArrayStack;
import mycollections.Deque;
import mycollections.LinkedDeque;
import mycollections.LinkedStack;
import mycollections.Stack;

/**
 *
 * @author Raul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // exercise 15, paragraph d)
        Integer[] a = {1, 3, 12, 23, 45, 67};
        System.out.println("a = " + Arrays.toString(a));
        
        System.out.println("");
        System.out.println("AS - ArrayStack");
        System.out.println("");
        Stack<Integer> buffer = new ArrayStack<>(a.length);
        for(int i=0; i<a.length; i++){
            buffer.push(a[i]);
        }
        //test the iterators
        Iterator<Integer> it = buffer.iterator();
        while(it.hasNext()){
            System.out.println(it.next() + " ");
        }
        System.out.println("<<<<<AS Iteration with while");
        
        for(Integer x: buffer){
            System.out.println(x+"");
        }
        System.out.println("<<<<<AS Iteration with for each");
        
        //----------------------------------------------------
        // the same with linkedStack
        System.out.println("");
        System.out.println("LS - LinkedStack");
        System.out.println("");
        buffer = new LinkedStack<>();
        
        for(int i=0; i<a.length;i++){
            buffer.push(a[i]);
        }
        //test the iterators with LinkedStack
        it = buffer.iterator();
        while(it.hasNext()){
            System.out.println(it.next()+" ");
        }
        System.out.println("<<<<<LS Iteration with while");
        
        for(Integer x: buffer){
            System.out.println(x+"");
        }
        System.out.println("<<<<<LS Iteration with for each");
        
        //put back in the array
        for(int i=0;i<a.length; i++){
            a[i]=buffer.pop();
        }
        System.out.println("a = "+Arrays.toString(a));
        
        //reversing with a Deque
        //using ArrayDeque
        System.out.println("Reversing with ArrayDeque...");
        Deque<Integer> buffer2 = new ArrayDeque<>(a.length);
        
        for(int i=0; i<a.length;i++){
            buffer2.addFirst(a[i]);
        }
        for(int i=0; i<a.length;i++){
            a[i] = buffer2.removeFirst();
        }
        System.out.println("a = " + Arrays.toString(a));
        
        //using LinkedDeque
        System.out.println("Reversing with LinkedDeque...");
        buffer2 = new LinkedDeque<>();
        
        for(int i=0; i<a.length;i++){
            buffer2.addFirst(a[i]);
        }
        for(int i=0; i<a.length;i++){
            a[i] = buffer2.removeFirst();
        }
        System.out.println("a = " + Arrays.toString(a));
        
        //Implement Map, ArrayMap, LinkedMap
        
        
        
        
    }
    
}
