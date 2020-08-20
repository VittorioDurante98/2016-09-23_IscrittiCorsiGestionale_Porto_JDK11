package it.polito.tdp.gestionale.model;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model m = new Model();
		DidatticaDAO dao = new DidatticaDAO();
		m.creaGrafo();
		System.out.println("#Vertici: "+m.getGrafo().vertexSet().size()+"\n#Archi:"+m.getGrafo().edgeSet().size());
	}

}
