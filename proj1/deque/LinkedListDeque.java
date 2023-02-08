package deque;

import java.util.Iterator;
// Logic Videos I Watched
// Lalitha Natraj "Introduction to Circular Queues"
// Link: https://www.youtube.com/watch?v=ihEmEcO2Hx8&ab_channel=LalithaNatraj
// "Introduction To Double Ended Queues"
// Link: https://www.youtube.com/watch?v=j3rvizohd0I&ab_channel=LalithaNatraj
// "Circular Queues - Additions and Deletions"
// Link: https://www.youtube.com/watch?v=LS89dVNGDGc&ab_channel=LalithaNatraj
// Constructor code from @61B code via SLList file with few tweaks
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    public Iterator<T> iterator() {
        return new SLDequeIterator(this);
    }

    public class SLDequeIterator implements Iterator<T> {
        private LinkedListDeque<T> node;
        private int index;
        private LinkedListDeque<T> sentinel;
        public SLDequeIterator(LinkedListDeque<T> lst) {
            node = lst;
            index = 0;
        }

        public boolean hasNext() {
            if (size <= size -1) {
                return true;
            }
            return false;
        }

        public T next() {
            T value = get(index);
            index++;
            return value;
        }
    }
    }
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(Node p, T i, Node n) {
            item = i;
            next = n;
            prev = p;
        }

        public Node() {
            item = null;
            next = this;
            prev = this;
        }
    }

    private Node sentinel;
    private int size;

    /* Node, item, Node
       previous, item, next
       pushes previous to next node and inserts item in front
       basically move previous forward, next is just there to indicate positioning
       */

    public LinkedListDeque() {
        sentinel = new Node();
        size = 0;
    }

    // redefine sentinel.next to new node @61B SLList
    // SLList does not display anything when only sentinel.next is there
    // redefine sentinel.next.next?
    @Override

    public void addFirst(T x) {
        sentinel.next = new Node(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev.next = new Node(sentinel.prev, x, sentinel);
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    //reversing logic of addFirst does not work
    // need to test for edge case of 0, failed test and got -3 instead of 0
    //        cannot be void, failed multipleparamtest
    //        passed removeEmptyTest by returning size
    //        failed the rest bc returning an int and not parameter T
    //        what would T value be
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node temp = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel.next;
        sentinel.next.prev = sentinel;
        temp.prev = null;
        temp.next = null;
        size--;
        return temp.item;
    }

    // reversal of removeFirst
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        temp.prev = null;
        temp.next = null;
        size--;
        return temp.item;
    }
    // same logic as printDeque except with index instead of sentinel.next, wrong
    // index must not be equal to the sentinel node value
    @Override
    public T get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        if (index > size - 1) {
            return null;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index > (size - 1)) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    //Code from 61B lecture
    private T getRecursiveHelper(Node ind, int index) {
        if (index == 0) {
            return ind.item;
        } else {
            return getRecursiveHelper(ind.next, index - 1);
        }
    }

    @Override
    public void printDeque() {
        while (sentinel.next != sentinel) {
            System.out.print(sentinel.next.item + " ");
            sentinel.next = sentinel.next.next;
        }
    }

    // @61B SLList.java file
    public int size() {
        return size;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Deque)) {
            return false;
        } else if (o == this) {
            return true;
        }
        if (o instanceof Deque) {
            Deque<T> neww = (Deque<T>) o;
            if (neww.size() != this.size()) {
                return false;
            }
            int index = 0;
            while (index < size) {
                if (neww.get(index) != this.get(index)) {
                    return false;
                }
                else {
                    index++;
                }
            }
        }
        return true;
    }
}

//public class LinkedListDequeIterator implements Iterator<T>{
//    public T item;
//    private Node next;
//    public Node sentinel;
//    public LinkedListDequeIterator(Node list){
//        next = list;
//    }
//    public boolean hasNext(){
//        return sentinel.next != sentinel;
//    }
//    public Integer next(){
//        T value = sentinel.item;
//        sentinel = sentinel.next;
//        return value;
//    }
//}
