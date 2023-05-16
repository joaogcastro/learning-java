package br.edu.up.entidades;

public class PagamentoComissao extends Pagamento{
	private int comissao;

	public int getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		this.comissao = comissao;
	}

	public PagamentoComissao(int id, Funcionario funcionario, int horasTrabalhadas, double valorHora, int comissao) {
		super(id, funcionario, horasTrabalhadas, valorHora);
		this.comissao=comissao;
	}

	public double realizarPagamento() {
		return horasTrabalhadas*valorHora+comissao;
	}
}