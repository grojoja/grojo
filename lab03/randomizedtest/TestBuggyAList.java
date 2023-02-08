package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> lst = new AListNoResizing<>();
        BuggyAList<Integer> list = new BuggyAList<>();
        lst.addLast(4);
        lst.addLast(8);
        lst.addLast(10);
        list.addLast(4);
        list.addLast(8);
        list.addLast(10);
        assertEquals(lst.size(), list.size());
        assertEquals(lst.removeLast(), list.removeLast());
        assertEquals(lst.removeLast(), list.removeLast());
        assertEquals(lst.removeLast(), list.removeLast());
//        assertEquals(lst.getLast(),4);
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Incorrect = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Incorrect.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = Incorrect.size();
                assertEquals(size, size2);
                System.out.println("size: " + size);
            }
            else if (operationNumber == 2) {
                if(L.size() > 0 && Incorrect.size() > 0) {
                    int last = L.getLast();
                    int IncorrectLast = Incorrect.getLast();
                    assertEquals(last, IncorrectLast);
                }
            }
            else if (operationNumber == 3){
                if(L.size() > 0 && Incorrect.size() > 0) {
                    int randVal = StdRandom.uniform(0, 100);
                    int remove = L.removeLast();
                    int removein = Incorrect.removeLast();
                    assertEquals(remove, removein);
                }
            }
        }
    }

}