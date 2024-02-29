package hi.verkefni2.vidmot;

import Vinnsla.Strengir;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class StrengirController {

    //tilviksbreyta fyrir leitarorðið sem er slegið inn
    @FXML
    private TextArea fxLeitarord;

    //tilviksbreyta fyrir textann sem er sleginn inn
    @FXML
    private TextArea fxTextinn;

    //tilviksbreyta fyrir birtingu á staðsetningu orðs
    @FXML
    private Label fxStadsetningOrds;

    //tilviksbreyta fyrir birtingu á fjölda orða í textanum
    @FXML
    private Label fxFjoldiOrda;

    //tilviksbreyta af klasanum Strengir til að kalla á klasann
    private Strengir strengir = new Strengir();







    /**
     * aðferðin nær í leitarorðið og kallar á fallið sem skilar staðsetningu leitarorðsins
     * í textanum
     * @param actionEvent þegar ýtt á hnappinn Leita
     */
    @FXML
    public void onLeit(ActionEvent actionEvent) {
        try {
            String ordleit = fxLeitarord.getText();
            if (fxLeitarord.getText().isEmpty()) {
                fxLeitarord.setStyle("-fx-border-color: red");
            } else if (strengir.leita(ordleit) == -1) {
                fxStadsetningOrds.setText("Fannst ekki");
            } else {
                String numer = Integer.toString(strengir.leita(ordleit));
                fxStadsetningOrds.setText("Orð númer "+ numer);
            }
        } catch (NullPointerException e) {
            // viðbrögð þín ef textastrengurinn er null
            fxStadsetningOrds.setText("Enginn texti \n vistaður");
            fxTextinn.setStyle("-fx-border-color: red");
        }
    }


    /**
     * Þegar skrifað er á lyklaborðinu í leitarreitinn verður liturinn aftur eins og hann var
     * @param actionEvent liturinn verður aftur eins og hann var, hættir að vera rauður
     */
    @FXML
    public void onSkrifa(KeyEvent actionEvent) {
        fxLeitarord.setStyle("-fx-border-color: #D3D3D3");
        fxStadsetningOrds.setText("0");
    }


    /**
     * aðferðin kallar á fallið sem skilar fjölda orða í textanum
     * @param actionEvent þegar ýtt er hnappinn Telja orð
     */
    @FXML
    public void onTeljaOrd(ActionEvent actionEvent) {
        try {
            String fjoldiOrda = Integer.toString(strengir.fjoldiOrda());
            fxFjoldiOrda.setText("Fjöldi orða er: "+fjoldiOrda);
        } catch (NullPointerException e) {
            fxTextinn.setStyle("-fx-border-color: red");
        }
    }

    /**
     * aðferðin nær í textann sem búið er að slá inn og
     * kallar svo á setterinn í Strengir klasanum
     * @param actionEvent þegar ýtt er á hnappinn Vista
     */
    @FXML
    public void onVistaTexta(ActionEvent actionEvent) {
        String texti = fxTextinn.getText();
        if (fxTextinn.getText().isEmpty()) {
            fxTextinn.setStyle("-fx-border-color: red");
            fxFjoldiOrda.setText("Vantar að skrifa texta");
        } else {
            strengir.setTexti(texti);
            fxStadsetningOrds.setText("0");
        }
    }


    /**
     * Þegar skrifað er á lyklaborðinu í textareitinn verður liturinn aftur eins og hann var
     * @param actionEvent liturinn verður aftur eins og hann var, hættir að vera rauður
     */
    @FXML
    public void onSkrifa2(KeyEvent actionEvent) {
        fxTextinn.setStyle("-fx-border-color: #D3D3D3");
        fxFjoldiOrda.setText("0");
    }

}
