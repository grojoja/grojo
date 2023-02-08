package gh2;

import deque.ArrayDeque;
import deque.Deque;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int thatscapman = (int) Math.round(SR / frequency);
        buffer = new ArrayDeque<>();
        for (int i = 0; i < thatscapman; i++) {
            buffer.addFirst(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        int size = buffer.size();
        buffer = new ArrayDeque<>();
        //idea from EdStem: https://edstem.org/us/courses/25377/discussion/1822860
        for (int i = 0; i < size; i++) {
            buffer.addLast(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double first = buffer.removeFirst();
        double next = sample();
        double nextfirst = (first + next) * .5 * DECAY;
        buffer.addLast(nextfirst);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        double cheese = buffer.get(0);
        return cheese;
    }
}
