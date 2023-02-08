package deque;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {
    @Test
    public void resizingtest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(1);
        arr.printDeque();
    }

    @Test
    public void printDequeTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
//        arr.addFirst(1);
        arr.addFirst(8);
        arr.addFirst(2);
        arr.addFirst(2);
        arr.addFirst(155);
        arr.addFirst(155);
        arr.addFirst(155);
        arr.addFirst(155);
        arr.addFirst(155);
        arr.printDeque();
        System.out.println("/n");
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.printDeque();
        System.out.println(" ");
        arr.addFirst(8); // problem is that last and first end up both equal to zero, so 8 is overwritten
        arr.addLast(2);
        arr.addFirst(2);
        arr.addLast(155);
        arr.addFirst(15);
        arr.addFirst(1);
        arr.addFirst(10);
        arr.addFirst(16);
        arr.addFirst(8); // problem is that last and first end up both equal to zero, so 8 is overwritten
        arr.addLast(2);
        arr.addFirst(2);
        arr.addLast(155);
        arr.addFirst(15);
        arr.addFirst(1);
        arr.addFirst(10);
        arr.addFirst(16);
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.printDeque();

    }

    @Test
    public void addthenremove() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(5);
        arr.addFirst(2);
        arr.printDeque();
        System.out.println();
        arr.removeFirst();
        arr.removeLast();
        arr.printDeque();

//        arr.addLast(2);
//        arr.printDeque();
    }

    @Test
    public void addthenremovethenadd() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(5);
        arr.addFirst(4);
        arr.removeLast();
        arr.removeFirst();
        arr.addFirst(2);
        arr.addFirst(5);
    }

    @Test
    public void RemoveTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(1);
        arr.addFirst(2);
        arr.removeFirst();
        arr.printDeque();
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        assertEquals(arr.isEmpty(), true);
    }

    @Test
    public void addResize() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(5);
        arr.removeLast();
        arr.printDeque();
    }

    @Test
    public void gettest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(1);
        arr.addFirst(8);
        arr.addLast(2);
        arr.addLast(3);
        arr.addFirst(2);
        arr.addLast(2);
        arr.addFirst(5);
        arr.addFirst(5);
        System.out.println(arr.get(0));
        System.out.println(arr.size());
    }

    @Test
    public void basicTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);
        arr.addLast(2);
        arr.addFirst(5);
        arr.addLast(5);
        arr.addLast(5);
        arr.addLast(5);
        arr.addFirst(4);
        arr.addLast(5);
        arr.addLast(5);
        arr.addLast(5);
        arr.addFirst(4);
        arr.addLast(5);
        arr.addLast(5);
        arr.addFirst(2);
        arr.addFirst(5);
        arr.addLast(16);
        arr.addFirst(7777);
        arr.addLast(2);
        arr.printDeque();
    }

    @Test
    public void resizingdowntest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);
        arr.addLast(2);
        arr.addFirst(3);
        arr.addLast(4);
        arr.addLast(5);
        arr.addLast(6);
        arr.addFirst(7);
        arr.addLast(8);
        arr.addLast(9);
        arr.addLast(10);
        arr.addFirst(11);
        arr.addLast(12);
        arr.addLast(13);
        arr.addFirst(14);
        arr.addFirst(15);
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        arr.removeLast();
        arr.printDeque();
    }

    @Test
    public void LastTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);
        arr.addLast(2);
        arr.addFirst(3);
        arr.addLast(4);
        arr.addLast(5);
        arr.addLast(6);
        arr.addFirst(7);
        arr.addLast(8);
        arr.addLast(9);
        arr.addLast(10);
        arr.addFirst(11);
        arr.addLast(12);
        arr.addLast(13);
        arr.addFirst(14);
        arr.addFirst(15);
        arr.addLast(16);
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.printDeque();
    }

    @Test
    public void addFronting() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();

        for (int i = 0; i < 12; i++) {
            arr.addFirst(i);
        }
        for (int i = 0; i < 12; i++) {
            arr.addLast(i);
        }
        for(int i = 0; i < 20; i++) {
            arr.removeLast();
        }
    }

    @Test
    public void addremove() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.isEmpty();
        arr.addFirst(1);
        arr.isEmpty();
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.removeLast();
        arr.removeLast();
    }

    @Test
    public void basicGet() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for (int i = 0; i < 9; i++) {
            arr.addFirst(i);
        }
        int item = arr.get(5);
        int item2 = 2;
        assertEquals(item2,item);
    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        ArrayDeque<Integer> Incorrect = new ArrayDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Incorrect.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
//            } else if (operationNumber == 1) {
//                // size
//                int size = L.size();
//                int size2 = Incorrect.size();
//                assertEquals(size, size2);
//                System.out.println("size: " + size);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                Incorrect.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            } else if (operationNumber == 2) {
                if (L.size() > 0 && Incorrect.size() > 0) {
                    int last = L.removeFirst();
                    int IncorrectLast = Incorrect.removeFirst();
                    assertEquals(last, IncorrectLast);
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0 && Incorrect.size() > 0) {
                    int randVal = StdRandom.uniform(0, 100);
                    int remove = L.removeLast();
                    int removein = Incorrect.removeLast();
                    assertEquals(remove, removein);
                }
//            } else if (operationNumber == 4) {
//                // addLast
//                int randVal = StdRandom.uniform(0,100);
//                int item = L.get(randVal);
//                int item2 = Incorrect.get(randVal);
//                assertEquals(item, item2);
//            }
            }
        }
    }
        @Test
        public void randomTest () {
            ArrayDeque<Integer> arr = new ArrayDeque<>();
            arr.addFirst(20);
            arr.addFirst(39);
            arr.addLast(70);
            arr.addFirst(40);
            arr.addFirst(9);
            arr.addFirst(62);
            arr.addLast(28);
            arr.addLast(22);
            arr.removeLast();
            arr.removeLast();
            arr.addLast(56);
            arr.addLast(87);
            arr.removeLast();
            arr.removeLast();
            arr.addFirst(93);
            arr.removeLast();
            arr.addFirst(30);
            arr.addFirst(88);
            arr.addLast(12);
            arr.addFirst(24);
            arr.removeFirst();
            arr.addLast(5);
            arr.addFirst(91);
            arr.addFirst(95);
            arr.removeFirst();
            arr.addFirst(17);
            arr.removeFirst();
            arr.addLast(79);
            arr.removeLast();
            arr.addLast(18);
            arr.addFirst(95);
            arr.addLast(55);
            arr.addFirst(41);
            arr.addFirst(84);
            arr.addFirst(60);
            arr.removeLast();
            arr.addLast(55);
            arr.removeLast();
            arr.removeLast();
            arr.addFirst(41);
            arr.addLast(30);
            arr.addLast(86);
            arr.addFirst(20);
            arr.addFirst(47);
            arr.addLast(5);
            arr.addFirst(45);
            arr.addLast(12);
            arr.addFirst(54);
            arr.addLast(9);
            arr.addLast(38);
            arr.removeLast();
            arr.addFirst(40);
            arr.addFirst(64);
            arr.addFirst(92);
            arr.removeLast();
            arr.addFirst(96);
            arr.addFirst(42);
            arr.addLast(60);
            arr.addFirst(48);
            arr.addLast(45);
            arr.addFirst(3);
            arr.addLast(71);
            arr.removeLast();
            arr.removeLast();
            arr.addFirst(96);
            arr.addFirst(89);
            arr.addLast(2);
            arr.addLast(56);
            arr.removeLast();
            arr.removeLast();
            arr.addLast(64);
            arr.addFirst(68);
            arr.addLast(77);
            arr.addLast(68);
            arr.addLast(90);
            arr.addLast(32);
            arr.addLast(63);
            arr.addLast(7);
            arr.removeLast();
            arr.addLast(6);
            arr.addLast(28);
            arr.removeLast();
            arr.removeLast();
            arr.addFirst(42);
            arr.addLast(68);
            arr.addFirst(40);
            arr.addLast(66);
            arr.removeLast();
            arr.addFirst(82);
            arr.addFirst(87);
            arr.addLast(40);
            arr.removeLast();
            arr.addLast(52);
            arr.removeLast();
            arr.addFirst(86);
            arr.addFirst(14);
            arr.addFirst(21);
            arr.addFirst(40);
            arr.addLast(9);
            arr.addFirst(49);
            arr.addFirst(61);
            arr.addFirst(5);
            arr.addFirst(81);
            arr.addFirst(96);
            arr.removeLast();
            arr.addFirst(65);
            arr.addFirst(63);
            arr.addFirst(42);
            arr.removeLast();
            arr.addLast(72);
            arr.addLast(78);
            arr.removeLast();
            arr.addLast(85);
            arr.removeLast();
            arr.addFirst(41);
            arr.addLast(86);
            arr.addFirst(59);
            arr.removeLast();
            arr.addLast(86);
            arr.addFirst(56);
            arr.removeLast();
            arr.addLast(21);
            arr.addFirst(42);
            arr.addFirst(94);
            arr.addFirst(64);
            arr.addLast(3);
            arr.addLast(39);
            arr.addLast(96);
            arr.addLast(14);
            arr.removeFirst();
        }

    @Test
    public void TestIterator() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }
        Iterator<Integer> iter = ad1.iterator();
        int i = 0;
        while (iter.hasNext()) {
            System.out.println(iter.next()+2);
            i++;
        }
    }
    }