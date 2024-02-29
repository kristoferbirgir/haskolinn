/******************************************************************************
 *  Compilation:  javac Shell.java
 *  Execution:    java Shell < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/21elementary/tiny.txt
 *                https://algs4.cs.princeton.edu/21elementary/words3.txt
 *
 *  Sorts a sequence of strings from standard input using shellsort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Shell < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Shell < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *
 ******************************************************************************/

/**
 *  The {@code Shell} class provides static methods for sorting an
 *  array using <em>Shellsort</em> with
 *  <a href = "https://oeis.org/A003462"> Knuth's increment sequence</a>
 *  (1, 4, 13, 40, ...). In the worst case, this implementation makes
 *  &Theta;(<em>n</em><sup>3/2</sup>) compares and exchanges to sort
 *  an array of length <em>n</em>.
 *  <p>
 *  This sorting algorithm is not stable.
 *  It uses &Theta;(1) extra memory (not including the input array).
 *  <p>
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
import edu.princeton.cs.algs4.*;


public class Shell {
    private static int totalComparisons = 0;
    private static int totalExchanges = 0;

    public static void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 3x+1 increment sequence

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }

    private static boolean less(int v, int w) {
        totalComparisons++;
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        totalExchanges++;
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // Take N from command line argument
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = (int) (Math.random() * N); // Fill array with random numbers

        sort(a);
        System.out.println("Total compares: " + totalComparisons);
        System.out.println("Total exchanges: " + totalExchanges);
    }
}
