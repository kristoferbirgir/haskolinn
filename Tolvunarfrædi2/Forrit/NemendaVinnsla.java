/******************************************************************************
*  Sýnisforrit sem vinnur með klasann Nemandi til að prófa samanburð
*     Tölvunarfræði 2, vor 2024
*
******************************************************************************/
import edu.princeton.cs.algs4.*;

public class NemendaVinnsla {
    static final int NafnLen = 8;

    // Innra fall sem býr til slembinafn af lengd len úr
    //  enskum bókstöfum
    private static String buaSlembiNafn(int len) {
        String enHastaf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String enLagstaf = "abcdefghijklmnopqrstuvwxyz";
        String slNafn = "";

        // Byrja að búa til hástaf...
        int slVisir = StdRandom.uniformInt(enHastaf.length());
        char slStafur = enHastaf.charAt(slVisir);
        slNafn += String.valueOf(slStafur);
        
        // Restin er í lágstöfum
        for (int i=1; i<len; i++){
            slVisir = StdRandom.uniformInt(enLagstaf.length());
            slStafur = enLagstaf.charAt(slVisir);
            slNafn += String.valueOf(slStafur);
        }
        
        return slNafn;
    }
    
    // Fallið býr til og skilar nemanda með slembinafn og
    //  slembi eiginleika
    public static Nemandi buaSlembiNema() {
        
        String slNafn = buaSlembiNafn( NafnLen );
        int slAr = StdRandom.uniformInt(10) + 1995;
        int slEin = StdRandom.uniformInt(200);
        double slEink = StdRandom.uniformDouble(0.0, 10.0);
        
        return new Nemandi(slNafn, slAr, slEin, slEink);
    }


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Nemandi[] bekkur = new Nemandi[N];
        
        // Búa til nemendur...
        for (int i=0; i<N; i++)
            bekkur[i] = buaSlembiNema();

        // Raða nemendum...
        Insertion.sort(bekkur);
        
        for (int i=0; i<N; i++)
            StdOut.println(bekkur[i]);
    }

}