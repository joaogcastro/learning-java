package br.edu.up.entidades;

public abstract class Pagamento {
	int id;
	Funcionario funcionario;
	int horasTrabalhadas;
	double valorHora;
	
	public Pagamento (int id, Funcionario funcionario, int horasTrabalhadas, double valorHora) {
		this.id= id;
		this.funcionario= funcionario;
		this.horasTrabalhadas= horasTrabalhadas;
		this.valorHora= valorHora;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	public abstract double realizarPagamento();
}