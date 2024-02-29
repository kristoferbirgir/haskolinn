/********************************************************************
*   Beinagrind fyrir dæmi á Heimadæmum 4
*    Tölvunarfræði 2, vor 2024
*
*********************************************************************/

public class Nemandi implements Comparable<Nemandi>{
    private String nafn;
    private int fAr;
    private int fEin;
    private double mEink;

    public Nemandi(String n, int ar, int ein, double eink) {
        this.nafn = n;
        this.fAr = ar;
        this.fEin = ein;
        this.mEink = eink;
    }

   /* public int compareTo(Nemandi that) {
        if (this.mEink > that.mEink) return -1;
        if (this.mEink < that.mEink) return +1;
        return 0;
    } */


    /* public int compareTo(Nemandi that) {
        if (this.fAr != that.fAr) {
            return this.fAr - that.fAr; // Lækkandi röð eftir fæðingarári
        } else {
            return this.fEin - that.fEin; // Hækkandi röð eftir fjölda eininga
        }
    } */

    public int compareTo(Nemandi that) {
        boolean thisGraduated = this.fEin >= 180;
        boolean thatGraduated = that.fEin >= 180;

        if (thisGraduated && thatGraduated) {
            return this.nafn.compareTo(that.nafn); // Hækkandi stafrófsröð fyrir útskrifaða
        } else if (thisGraduated) {
            return -1; // Alltaf á undan ef útskrifaður
        } else if (thatGraduated) {
            return 1; // Alltaf á eftir ef ekki útskrifaður
        } else {
            return that.fEin - this.fEin; // Lækkandi röð eftir fjölda eininga fyrir óútskrifaða
        }
    }



    public String toString() {
        String strNemi = nafn;
        
        strNemi += " (" + String.format("%4d", fAr) + ")";
        strNemi += " - " + String.format("%3d", fEin) + " ein.";
        strNemi += " Eink: " + String.format("%4.2f", mEink);
    
        return strNemi;
    }

}
