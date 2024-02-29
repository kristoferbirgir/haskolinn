package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Kubbur {

    private Stykki[][] bord;

    private Stykki radadStykki;

    private final IntegerProperty score;

    private final IntegerProperty correctGuesses;

    private Stykki[] talaStykki;

    private final String[] myndaNofn;

    private final int numberOfCells;



    public Kubbur(int radir, int dalkar) {
        bord = new Stykki[radir][dalkar];
        talaStykki = new Stykki[10];
        myndaNofn = new String[]{"/vidmot/css/myndir/mynd1.png", "/vidmot/css/myndir/mynd2.png", "/vidmot/css/myndir/mynd3.png",
                "/vidmot/css/myndir/mynd4.png", "/vidmot/css/myndir/mynd5.png", "/vidmot/css/myndir/mynd6.png", "/vidmot/css/myndir/mynd7.png",
                "/vidmot/css/myndir/mynd8.png", "/vidmot/css/myndir/mynd9.png"};

        score = new SimpleIntegerProperty(0);
        correctGuesses = new SimpleIntegerProperty(0);
        numberOfCells = radir * dalkar;
    }


    public Stykki getBordStykki(int row, int column) {
        if (row < 0 || row >= bord.length || column < 0 || column >= bord[0].length) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        return bord[row][column];
    }


    public Stykki getRadadStykki() {
        return radadStykki;
    }

    public void updateStigin() {
        // Add 2 points to the current score for a correct guess
        score.set(score.get() + 2);
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

    public int getCorrectGuesses() {
        return correctGuesses.get();
    }

    public void incrementCorrectGuesses() {
        // Implement the logic to increment correct guesses here
    }


    private void frumstillaKubb(int radir, int dalkar) {
        bord = new Stykki[radir][dalkar];
        Stykki[] einvittFylki = new Stykki[radir * dalkar];
        for (int i = 0; i < radir; i++) {
            for (int j = 0; j < dalkar; j++) {
                int randomIndex = new Random().nextInt(myndaNofn.length);
                String myndaNafn = myndaNofn[randomIndex];
                Stykki s = new Stykki(myndaNafn);
                bord[i][j] = s;
                einvittFylki[i * dalkar + j] = s;
            }
        }
    }



    // Fyllir fylkið talaStykki með Stykki hlutum sem samsvara tölunum 0-9
    public void fillTalaStykki() {
        for (int i = 0; i < talaStykki.length; i++) {
            talaStykki[i] = new Stykki("tala" + i);
        }
    } //Búið að skoða rétt.


    // Setur tölur á boðrinu í random röð
    public void randomizeBord() {
        Random rand = new Random();
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord[i].length; j++) {
                int randomIndex = rand.nextInt(talaStykki.length);
                bord[i][j] = talaStykki[randomIndex];
            }
        }
    }
    // Búið að skoða



    // Getters og setters
    public Stykki[][] getBord() {
        return bord;
    }



    public void setBord(Stykki[][] bord) {
        this.bord = bord;
    }

    public Stykki[] getTalaStykki() {
        return talaStykki;
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public int getScore() {
        return score.get();
    }



    public void setScore(int score) {
        this.score.set(score);
    }

    public void setTalaStykki(Stykki[] talaStykki) {
        this.talaStykki = talaStykki;
    }

    public IntegerProperty correctGuessesProperty() {
        return correctGuesses;
    }
    public void setCorrectGuesses(int correctGuesses) {
        this.correctGuesses.set(correctGuesses);
    }


    public void setRadadStykki(Stykki radadStykki) {
        this.radadStykki = radadStykki;
    }


}

