package com.tiv.responsibility.chain.multiton;

/**
 * 责任链接口
 *
 * @param <E>
 */
public interface ResponsibilityChain<E> {

    E get(int index);

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(E e);

    void print();

}
