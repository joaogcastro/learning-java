package br.edu.up.entidades;

import br.edu.up.persistencia.PersistenciaApp;

public class App {
	private int id;
	private String nome;
	private double tamanho;
	
	public void setIdAutomatico() {
	    int ultimoId = 0;
	    for(App item: PersistenciaApp.getAppStore()) {
	        int id = item.getId();
	        if(id > ultimoId) {
	            ultimoId = id;
	        } else if(id <= ultimoId) {
	            ultimoId = ultimoId + 1;
	        }
	    }
	    this.id = ultimoId + 1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
}