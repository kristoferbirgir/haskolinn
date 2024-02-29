package vinnsla;

public class Lag {
    private String skra;
    private String lagNafn;
    private String lagLengd;
    private String myndSkra;

    /**
     * Smiður fyrir Lag
     * @param skra skrá
     * @param lagNafn lagNafn
     * @param lagLengd lagLengd
     * @param myndSkra myndSkra
     */
    public Lag(String skra, String lagNafn, String lagLengd, String myndSkra) {
        this.skra = skra;
        this.lagNafn = lagNafn;
        this.lagLengd = lagLengd;
        this.myndSkra = myndSkra;
    }

    /**
     * Skilar skrá
     * @return skrá
     */
    public String getSkra() {
        return skra;
    }

    /**
     * Skilar laglagi
     * @return lag
     */
    public String getLagNafn() {
        return lagNafn;
    }

    /**
     * Skilar lengd lags
     * @return lengd
     */
    public String getlagLengd() {
        return lagLengd;
    }

    /**
     * Skilar mynd
     * @return mynd
     */
    public String getMyndSkra() {
        return myndSkra;
    }

    @Override
    public String toString() {
        return lagNafn;
    }
}