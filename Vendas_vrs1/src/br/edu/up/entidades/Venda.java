package br.edu.up.entidades;
import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private String nomeCliente;
	private String nomeVendedor;
	private Date data;
	private ArrayList<Item> itens;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(Cliente cliente) {
		this.nomeCliente = cliente.getNome();
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(Vendedor vendedor) {
		this.nomeVendedor = vendedor.getNome();
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
}