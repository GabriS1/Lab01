package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtTime;

    @FXML
    void doCancel(ActionEvent event) {
    	String selezionate;
    	selezionate= txtResult.getSelectedText();
    	List<String> l= new LinkedList<String>();
    	l= elenco.cancella(selezionate);
    	String elencoRidotto= "";
    	for(int i=0; i<l.size(); i++) {
    		elencoRidotto+=l.get(i)+"\n";
    	}
    	txtResult.setText(elencoRidotto);
    	double d= System.nanoTime();
    	txtTime.setText(Double.toString(d));
    }
    
    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	String s= "";
    	s= txtParola.getText();
    	elenco.addParola(s);
    	
    	List<String> l= new LinkedList<String>();
    	l = elenco.getElenco();
    	String elencoOrdinato= "";
    	for(int i=0; i<l.size(); i++) {
    		elencoOrdinato+=l.get(i)+"\n";
    	}
    	txtResult.setText(elencoOrdinato);
    	txtParola.clear();
    	double d= System.nanoTime();
    	txtTime.setText(Double.toString(d));
    	
    	// TODO
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	elenco.reset();
    	txtResult.clear();
    	double d= System.nanoTime();
    	txtTime.setText(Double.toString(d));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole();
    }
}
