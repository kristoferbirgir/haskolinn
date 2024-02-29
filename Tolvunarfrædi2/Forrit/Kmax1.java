/******************************************************************************
 *  Beinagrind að lausn á einum lið í dæmi 5 í Heimadæmum 5 í Tölvunarfræði 2
 *   Vor 2024
 
 ******************************************************************************/
import edu.princeton.cs.algs4.*;


public class Kmax1 {

    // Notum MaxPQ
    public static Double[] findKLargestUsingMaxPQ(Double[] a, int K) {
        MaxPQ<Double> maxPQ = new MaxPQ<>(a);
        Double[] result = new Double[K];
        for (int i = 0; i < K; i++) {
            result[i] = maxPQ.delMax();
        }
        return result;
    }

    // Notum MinPQ
    public static Double[] findKLargestUsingMinPQ(Double[] a, int K) {
        MinPQ<Double> minPQ = new MinPQ<>(K);
        for (Double item : a) {
            if (minPQ.size() < K) {
                minPQ.insert(item);
            } else if (item.compareTo(minPQ.min()) > 0) {
                minPQ.delMin();
                minPQ.insert(item);
            }
        }
        Double[] result = new Double[K];
        for (int i = 0; i < K; i++) {
            result[i] = minPQ.delMin();
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 10000000;
        int K = 100;
        Double[] a = new Double[N];

        // 10 milljón random tölur
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformDouble(0.0, 10.0);

        // tími fyrir MaxPQ
        Stopwatch timerMaxPQ = new Stopwatch();
        findKLargestUsingMaxPQ(a, K);
        double timeMaxPQ = timerMaxPQ.elapsedTime();
        StdOut.println("Tími með að nota MaxPQ: " + timeMaxPQ + " sekúndur");

        // tími fyrir MinPQ
        Stopwatch timerMinPQ = new Stopwatch();
        findKLargestUsingMinPQ(a, K);
        double timeMinPQ = timerMinPQ.elapsedTime();
        StdOut.println("Tími með að nota MinPQ: " + timeMinPQ + " sekúndur");
    }
}

