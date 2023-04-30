package br.edu.up.entidades;

import java.util.ArrayList;

public class Fabricante {
	private String nome;
	private ArrayList<Modelo> modelos = new ArrayList<Modelo>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Modelo> getModelos() {
		return modelos;
	}
	public void setModelos(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}
}