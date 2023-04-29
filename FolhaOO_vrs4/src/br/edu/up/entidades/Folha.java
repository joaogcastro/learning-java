package br.edu.up.entidades;

public class Folha {
	private String nomeFuncionario;
	private int mes;
	private int ano;
	private int nHoras;
	private float valorHora;
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getnHoras() {
		return nHoras;
	}
	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
	}
	public float getValorHora() {
		return valorHora;
	}
	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}
}
