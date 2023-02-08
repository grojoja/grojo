package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    //Based off of what Alex drew on the board in 273 on 9/22 and lecture 10 slides 18, 39, and 40
    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }
        int max = 0;
        for (int i = 0; i < size(); i++) {
            if (c.compare(this.get(i), this.get(max)) > 0) {
                max = i;
            }
        }
        return this.get(max);
    }

    public T max() {
        return max(comp);
    }
}
