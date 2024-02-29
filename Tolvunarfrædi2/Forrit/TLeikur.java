import edu.princeton.cs.algs4.*;

public class TLeikur {
    public static void main(String[] args) {
        int summa = 0;
        int sidastaGildi = 0;
        int nyttGildi;

        while (true) {
            nyttGildi = StdRandom.uniformInt(1, 11);
            if (nyttGildi <= sidastaGildi) {
                break;
            }
            summa += nyttGildi;
            sidastaGildi = nyttGildi;
        }

        System.out.println(summa);
    }
}
