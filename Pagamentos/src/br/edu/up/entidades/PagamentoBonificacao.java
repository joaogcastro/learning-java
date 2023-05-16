package br.edu.up.entidades;

public class PagamentoBonificacao extends Pagamento{
	private int comissao;
	private double bonificacao;

	public int getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		this.comissao = comissao;
	}

	public double getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}

	public PagamentoBonificacao(int id, Funcionario funcionario, int horasTrabalhadas, double valorHora, int comissao, double bonificacao) {
		super(id, funcionario, horasTrabalhadas, valorHora);
		this.comissao=comissao;
		this.bonificacao=bonificacao;
	}

	public double realizarPagamento() {
		return horasTrabalhadas*valorHora+comissao+bonificacao;
	}
}