package it.polito.tdp.gestionale.db;

public class TestDAO {

	// Test main
	public static void main(String[] args) {
		
		DidatticaDAO dd = new DidatticaDAO();
		System.out.println(dd.getAllCorsi());
		//System.out.println(dd.getStudente(134806));
	}
}
