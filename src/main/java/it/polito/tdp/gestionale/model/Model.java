package it.polito.tdp.gestionale.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class Model {
	
	private DidatticaDAO dao;
	private Graph<Nodo, DefaultEdge> grafo;
	private List<Nodo> nodi;
	
	public Model() {
		this.dao = new DidatticaDAO();
		this.nodi=new ArrayList<Nodo>();
		
	}
	
	public void creaGrafo() {
		this.grafo = new SimpleGraph<Nodo, DefaultEdge>(DefaultEdge.class);
		nodi.addAll(dao.getAllCorsi());
		nodi.addAll(dao.getAllStudenti());
		Graphs.addAllVertices(grafo, nodi);
		
		for (Corso c: dao.getAllCorsi()) {
			for (Studente s: dao.getAllStudenti()) {
				//if (dao.isIscritto(s, c)==true) 
					Graphs.addEdgeWithVertices(grafo, s, c);
				
			}
		}
		
	}

	public Graph<Nodo, DefaultEdge> getGrafo() {
		return this.grafo;
	}
}
