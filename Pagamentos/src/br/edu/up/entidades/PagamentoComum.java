package br.edu.up.entidades;

public class PagamentoComum extends Pagamento {

	public PagamentoComum(int id, Funcionario funcionario, int horasTrabalhadas, double valorHora) {
		super(id, funcionario, horasTrabalhadas, valorHora);
	}

	public double realizarPagamento() {
		return horasTrabalhadas*valorHora;
	}
}