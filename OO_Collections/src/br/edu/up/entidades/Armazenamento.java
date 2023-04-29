package br.edu.up.entidades;

public class Armazenamento {
	private String tipo;
	private float tamanho;
	private float tamanhoOriginal;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getTamanho() {
		return tamanho;
	}
	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}
	public float getTamanhoOriginal() {
		return tamanhoOriginal;
	}
	public void setTamanhoOriginal(float tamanhoOriginal) {
		this.tamanhoOriginal = tamanhoOriginal;
		this.tamanho = tamanhoOriginal;
	}
}