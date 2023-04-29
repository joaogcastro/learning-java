package br.edu.up.entidades;

import java.util.ArrayList;

public class Celular {
	private String marca;
	private String modelo;
	private double tamanhoTela;
	private int ram;
	private int armazenamento;
	private double preco;
	private double ocupado=0;
	
	public double getOcupado() {
		return ocupado;
	}
	public void setOcupado(double ocupado) {
		this.ocupado = ocupado;
	}
	private ArrayList<App> aplicativos = new ArrayList<App>();
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getTamanhoTela() {
		return tamanhoTela;
	}
	public void setTamanhoTela(double tamanhoTela) {
		this.tamanhoTela = tamanhoTela;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public ArrayList<App> getAplicativos() {
		return aplicativos;
	}
	public void setAplicativos(ArrayList<App> aplicativos) {
		this.aplicativos = aplicativos;
	}
}