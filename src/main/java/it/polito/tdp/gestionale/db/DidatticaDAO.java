package it.polito.tdp.gestionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.Studente;

public class DidatticaDAO {

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(String codins) {

		final String sql = "SELECT * FROM corso where codins=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getString("nome"),  rs.getInt("crediti"),
						rs.getInt("pd"));
				return corso;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Data una matricola ottengo lo studente.
	 */
	public Studente getStudente(int matricola) {

		final String sql = "SELECT * FROM studente where matricola=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				return studente;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public List<Studente> getAllStudenti() {

		final String sql = "SELECT * FROM studente";
		List<Studente> result = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				result.add(studente);
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public List<Corso> getAllCorsi() {

		final String sql = "SELECT * FROM corso";
		List<Corso> result = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getString("nome"), rs.getInt("crediti"),rs.getInt("pd"));
				
				result.add(corso);
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}


	public List<Studente> isIscritto( Corso c) {
		final String sql = "SELECT s.matricola, s.nome, s.cogome, s.CDS FROM studente AS s, corso AS c, iscrizione AS i WHERE s.matricola= i.matricola AND c.codins = i.codins AND c.codins=?";
		boolean iscritto=false;
		List<Studente> studenti = new ArrayList<Studente>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, c.getCodins());

			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				studenti.add(studente);
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
