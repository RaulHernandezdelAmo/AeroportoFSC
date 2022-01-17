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
public interface Deque<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    E first();
    E last();
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();
}
