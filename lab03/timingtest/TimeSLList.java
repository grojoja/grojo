package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns= new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();
        AList<Integer> lst = new AList<>();
        for(int i = 1000; i<=128000; i*=2){
            SLList<Integer> list = new SLList<>();
            for(int j = 0; j<= i; j++){
//                addlast would be in here
                list.addLast(j);
            }
//            declare variables outside
            Stopwatch shmeepa = new Stopwatch();
            for(int k = 0; k<=10000; k++){
                list.getLast();
            }
            for(int z = 0; z<8; z++){
                lst.addLast(10000);
            }
            Ns.addLast(i);
            double timing = shmeepa.elapsedTime();
            times.addLast(timing);
//            new a list inside of my for loop, right after for loop
//            hint go up to, addlast will be 0 in the parameter
        }
        printTimingTable(Ns, times, lst);
    }
}