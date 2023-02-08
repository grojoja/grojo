package deque;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    private static class intcompare implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return x - y;
        }
    }

    @Test
    public void BasicTest() {
        MaxArrayDeque<Integer> arr = new MaxArrayDeque<>(new intcompare());
        for (int i = 0; i <9; i++) {
            arr.addFirst(i);
        }
        assertEquals(3, arr.max().intValue());

    }
}
