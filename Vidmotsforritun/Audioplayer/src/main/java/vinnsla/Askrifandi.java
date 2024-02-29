package vinnsla;

public class Askrifandi {
    // Tilviksbreyta fyrir nafn
    private String nafn;

    // Smiður sem frumtillir nafn sem "Vantar nafn"
    public Askrifandi() {
        this.nafn = "Vantar nafn";
    }


    // set aðferð fyrir nafn
    public void setNafn(String nafn) {
        this.nafn = nafn;
    }


    // get aðferð fyrir nafn
    public String get(){
        return this.nafn;
    }
}
