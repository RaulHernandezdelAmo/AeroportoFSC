/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections;

/**
 *
 * @author Raul
 */
public interface Queue<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    E first();
    void enqueue(E element);
    E dequeue();
}
