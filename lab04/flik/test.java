package flik;

import static org.junit.Assert.*;
import org.junit.Test;

public class test {
    @Test
    public void testAddConstantOne() {
        IntList lst = IntList.of(1, 2, 3, 4, 5);
        IntListExercises.addConstant(lst, 1);
        assertEquals("2 -> 3 -> 4 -> 5 -> 6", lst.toString());
    }
}
