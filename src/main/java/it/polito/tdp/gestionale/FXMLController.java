package it.polito.tdp.gestionale;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.gestionale.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

//controller del turno A --> switchare al master_turnoB per turno B

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCorsiFrequentati(ActionEvent event) {
    	
    }

    @FXML
    void doVisualizzaCorsi(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DidatticaGestionale.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
	}
}
