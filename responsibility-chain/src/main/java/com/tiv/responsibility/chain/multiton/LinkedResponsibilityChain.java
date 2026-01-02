package com.tiv.responsibility.chain.multiton;

/**
 * 责任链实现
 *
 * @param <E>
 */
public class LinkedResponsibilityChain<E> implements ResponsibilityChain<E> {

    private final String name;

    protected transient int size = 0;

    protected transient Node<E> first;

    protected transient Node<E> last;

    public LinkedResponsibilityChain(String name) {
        this.name = name;
    }

    @Override
    public E get(int index) {
        Node<E> x;
        if (index < (size / 2)) {
            x = this.first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = this.last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
        }
        return x.val;
    }

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    @Override
    public boolean addFirst(E e) {
        Node<E> oldFirst = this.first;
        Node<E> newFirst = new Node<>(e, null, oldFirst);
        this.first = newFirst;
        if (oldFirst == null) {
            this.last = newFirst;
        } else {
            oldFirst.pre = newFirst;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        Node<E> oldLast = this.last;
        Node<E> newLast = new Node<>(e, oldLast, null);
        this.last = newLast;
        if (oldLast == null) {
            this.first = newLast;
        } else {
            oldLast.next = newLast;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        if (e == null) {
            for (Node<E> x = this.first; x != null; x = x.next) {
                if (x.val == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = this.first; x != null; x = x.next) {
                if (e.equals(x.val)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private E unlink(Node<E> x) {
        E element = x.val;
        Node<E> next = x.next;
        Node<E> pre = x.pre;

        if (pre == null) {
            this.first = next;
        } else {
            pre.next = next;
            x.pre = null;
        }

        if (next == null) {
            this.last = pre;
        } else {
            next.pre = pre;
            x.next = null;
        }
        x.val = null;
        this.size--;
        return element;
    }

    @Override
    public void print() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = this.first;
            System.out.printf("开始打印链表,头节点:%s,尾节点:%s,整体:%n", this.first.val, this.last.val);
            while (temp != null) {
                System.out.print(temp.val);
                temp = temp.next;
                if (temp != null) {
                    System.out.print("->");
                }
            }
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    protected static class Node<E> {

        E val;

        Node<E> pre;

        Node<E> next;

        public Node(E val, Node<E> pre, Node<E> next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

    }

}
