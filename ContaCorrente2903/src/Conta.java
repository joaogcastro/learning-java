public class Conta {
	private String nomeCliente;
	private int numeroAgencia;
	private int numeroConta;
	private float limite;
	private float saldo;
	
	public Conta() {};
	
	public Conta(String nomeCliente, int numeroAgencia, int numeroConta, float limite, float saldo) {
		this.nomeCliente = nomeCliente;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.limite = limite;
		this.saldo = saldo;
	}
	
	public void depositar(float valor) {
		saldo+=valor;
	}
	
	public void sacar(float valor) {
		saldo-=valor;
	}
	
	public boolean verificarSaldo(float valor) {
		if(saldo+limite>=valor) {
			return true;
		}else {
			return false;
		}
	}
	
	public float calcularSaldoDisponivel() {
		return saldo+limite;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}
