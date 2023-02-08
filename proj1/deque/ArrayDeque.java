
package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        public ArrayDequeIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            T value = items[index];
            index++;
            return value;
        }
    }

    private T[] items;
    private int size;
    private int first;
    private int last;
    private static final int STOPTHECAP = 8;
    private static final int LIMIT = 16;
    private double usage;

    // need to create a function to reset first and last so that the array does not continue
    // circularly and addfirst or last wrong
    // find a way to keep track of first and last so that they don't overlap
    public ArrayDeque() {
        items = (T[]) new Object[STOPTHECAP];
        size = 0;
    }

    private boolean checkUsage() {
        if (items.length >= LIMIT && usage < 0.25) {
            return true;
        }
        return false;
    }

    private void resizeF(int capacity) {
        if (checkUsage()) {
            T[] a = (T[]) new Object[items.length / 2];
            for (int i = 0; i < a.length; i++) {
                a[i] = items[(first + 1) % items.length];
                first++;
            }
            items = a;
            last = size;
            first = items.length - 1;
        }
    }
    /*
    private void resizeL(int size) {
        if (checkUsage()) {
            T[] a = (T[]) new Object[items.length / 2];
            for (int i = 0; i < a.length; i++) {
                a[i] = items[(last + 1) % items.length];
            }
            items = a;
            first = items.length - 1;
            last = size;
            }
     */

    public void addFirst(T x) {
        resizeUpF(size);
        if (size == 0) {
            first = items.length - 1;
            //modulo idea from Chloe, tinkered around to make it work,Alex confirmed this was right
            last = 0;
        }
        size++;
        usage = (double) size / (double) items.length;
        //       resize((int)(size *1.01));
        items[first] = x;
        first = (first - 1 + items.length) % items.length;
        //same thing here, first = 0 and replaces the first value of addLast.

    }

    public void addLast(T x) {
        resizeUpF(size);
        if (size == 0) {
            last = 0;
            first = items.length - 1;
        }
        //        else if(last == items.length-1){
        //            last = 0;
        //        }
        //last = 0 here and replaces the first value, how to fix this?
        usage = (double) size / (double) items.length;
        items[last] = x;
        last = (last + 1) % items.length;
        size++;
    }


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        resizeF(size);
        int index = (first + 1) % items.length;
        T hold = items[index];
        items[index] = null;
        first = index;
        usage = (double) size / (double) items.length;
        size--;
        return hold;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        resizeF(size);
        int index = (last - 1 + items.length) % items.length;
        T hold = items[index];
        items[index] = null;
        last = index;
        usage = (double) size / (double) items.length;
        size--;
        return hold;
    }

    /*
        Vanessa (staff member) confirmed this was for the most part right.
        Vanessa tip: put resizeup function inside of an if statement and
         helper function and shift everything forward by one
        Create separate function for resizing down

        private int changePointerFirstRemove(int first) {
            if (first != items.length - 1) {
                first++;
            } else {
                first = 0;
            }
            return first;
        }

        private int changePointerLastRemove(int last) {
            if (last != 0) {
                last--;
            } else {
                last = items.length - 1;
            }
            return last;
        }

        private int changePointerLast(int first) {
            if (first == items.length - 1) {
                first = 0; //shift it backwards so that we can continue adding to the front
            } else {
                first++; // move it to the end so that it adds to the front
            }
            return first;
        }
        private int changePointerFirst(int last) {
            if (last == 0) {
                last = items.length - 1;
            } else {
                last--;
            }
            return last;
        }
       Chloe said use modulo instead so that I do not have to continually reset the pointers.
    */
    /*
    private void resizeUpL(int size) {
        if (size == items.length) {
            int temp = size;
            T[] a = (T[]) new Object[size * 2];
            for (int i = 0; i <= items.length; i++) {
                a[(i - 1 + items.length) % a.length] = items[(i - 1 + items.length) % items.length];
            }
            items = a;
            first = items.length - 1;
            last = temp;
        }
    }
     */

    private void resizeUpF(int capacity) {
        if (size == items.length) {
            //            int temp = size;
            T[] a = (T[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                a[i] = items[(first + 1) % items.length];
                first++;
            }
            //System.arraycopy(items,(first)%items.length,a,0, size);
            items = a;
            last = size;
            first = items.length - 1;
        }
    }

    public T get(int i) {
        if (isEmpty()) {
            return null;
        }
        return items[(first + i + 1) % items.length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
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
                if (!neww.get(index).equals(this.get(index))) {
                    return false;
                } else {
                    index++;
                }
            }
        }
        return true;
    }
}


// starter code from CSM assignment
//public class IntArrayIterator implements Iterator<Integer>{
//    private int index;
//    private int[] array;
//    public IntArayIterator(int[] arr){
//        array = arr;
//        index = 0;
//    }
//    public boolean hasNext() {
//        return index < array.length;
//    }
//    public Integer next(){
//        int value = array[index];
//        index++;
//        return value;
//    }
//}
