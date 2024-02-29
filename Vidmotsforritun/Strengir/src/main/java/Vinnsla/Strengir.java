package Vinnsla;

public class Strengir{


    private String texti;

    public Strengir(){}


    /**
     * setur texta í vinnsluhlutann
     */
    public void setTexti(String texti) {
        this.texti = texti;
    }

    /**
     * Leitar að leitarord í textanum og skilar staðsetningu leitarorðs
     */
    public int leita (String leitarord) throws NullPointerException {
        if (texti == null) {  // texti er tilviksbreyta í Strengir sem geymir textann sem leitað er í
            throw new NullPointerException();
        }
        else {
            String[] ordalisti = texti.split(" ");
            for (int i = 0; i < ordalisti.length; i++) {
                if (ordalisti[i].equals(leitarord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

    /**
     * Telur fjölda orða í texti og skilar fjöldanum
     */
    public int fjoldiOrda() throws NullPointerException {
        if (texti == null) {  // texti er tilviksbreyta í Strengir sem geymir textann sem leitað er í
            throw new NullPointerException();
        }
        else {
            String[] ordalisti = texti.split(" ");
            return ordalisti.length;
        }
    }


    public static void main(String[] args) {
    }
}
