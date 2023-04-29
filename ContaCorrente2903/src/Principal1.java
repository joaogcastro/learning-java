public class Principal1 {
	public static void main(String[] args) {
		Conta conta = new Conta("José",1,1,100,0);
		//Conta conta = new Conta();
		
		System.out.println("\n\nNome do cliente: "+conta.getNomeCliente());
		System.out.println("Número da agência: "+conta.getNumeroAgencia());
		System.out.println("Número da conta: "+conta.getNumeroConta());
		System.out.println("Saldo: "+conta.getSaldo());
		System.out.println("Limite: "+conta.getLimite());
	}

}
