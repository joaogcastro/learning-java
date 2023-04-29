import java.util.ArrayList;
import java.util.List;
public class Principal {
	static List<Conta> contas = new ArrayList<>();
	public static void main(String[] args) {
		int opc;
		
		do {
			System.out.println("\n\n1 - Criar conta corrente."
					+ "\n2 - Depositar."
					+ "\n3 - Sacar."
					+ "\n4 - Verificar Saldo."
					+ "\n5 - Transferir"
					+ "\n6 - Sair.");
			opc = Console.readInt("Informe a opção: ");
			
			switch(opc) {
				case 1:
				criarConta();
					break;
				case 2:
				depositar();
					break;
				case 3:
				sacar();
					break;
				case 4:
				verSaldo();
					break;
				case 5:
				transferir();
					break;
				case 6:
					System.out.println("O Programa será finalizado.");
					break;
				default:
					System.out.println("A opção selecionada não é válida.");
					break;			
			}
		}while(opc!=6);
	}

	private static void transferir() {
		float valor;
		Conta conta;
		Conta conta1;
		conta= new Conta();
		conta.setNumeroAgencia(Console.readInt("Informe o número da agencia da conta de origem: "));
		conta.setNumeroConta(Console.readInt("Informe o número da conta de origem: "));
		conta= buscarConta(conta);
		
		if(conta!=null) {
			conta1= new Conta();
			conta1.setNumeroAgencia(Console.readInt("Informe o numero da agencia da conta de destino: "));
			conta1.setNumeroConta(Console.readInt("Informe o número da conta de destino: "));
			conta1= buscarConta(conta1);
			
			if(conta1!=null) {
				valor = Console.readFloat("Informe o valor a ser transferido da conta do(a) "
			+conta.getNomeCliente()+ " para a conta do(a) "+conta1.getNomeCliente()+": ");
				
				if(conta.verificarSaldo(valor)==true) {
					conta.sacar(valor);
					conta1.depositar(valor);
					atualizarConta(conta);
					atualizarConta(conta1);
					System.out.println("Transferência realizada com sucesso.");
				}else {
					System.out.println("A conta de origem não tem saldo suficiente para a transferência.");
				}
				
			}else {
				System.out.println("Conta não cadastrada.");
			}
			
		}else {
			System.out.println("Conta não cadastrada.");
		}
	}

	private static void verSaldo() {
		Conta conta;
		conta= new Conta();
		conta.setNumeroAgencia(Console.readInt("\nInforme o número da agência: "));
		conta.setNumeroConta(Console.readInt("Informe o número da conta: "));
		conta= buscarConta(conta);
		if(conta!=null) {
			System.out.println("Nome do cliente: "+conta.getNomeCliente());
			System.out.println("Saldo: "+conta.getSaldo());
			System.out.println("Limite: "+conta.getLimite());
			System.out.println("Saldo disponível: "+conta.calcularSaldoDisponivel());
		}else {
			System.out.println("\nConta corrente não cadastrada.");
		}
	}

	private static void sacar() {
		float valor;
		Conta conta;
		conta= new Conta();
		conta.setNumeroAgencia(Console.readInt("\nInforme o número da agência: "));
		conta.setNumeroConta(Console.readInt("Informe o número da conta: "));
		conta= buscarConta(conta);
		if(conta!=null) {
			valor = Console.readFloat("Informe o valor do depósito: ");
			if(conta.verificarSaldo(valor)==true){
				conta.sacar(valor);
				atualizarConta(conta);
				System.out.println("Novo saldo: "+conta.calcularSaldoDisponivel());
			}else {
				System.out.println("\nSaldo insuficiente.");
			}
			
		}else {
			System.out.println("\nConta corrente não cadastrada.");
		}
	}

	private static void depositar() {
		float valor;
		Conta conta;
		conta= new Conta();
		conta.setNumeroAgencia(Console.readInt("\nInforme o número da agência: "));
		conta.setNumeroConta(Console.readInt("Informe o número da conta: "));
		conta= buscarConta(conta);
		if(conta!=null) {
			valor = Console.readFloat("Informe o valor do depósito: ");
			conta.depositar(valor);
			atualizarConta(conta);
			System.out.println("Novo saldo: "+conta.calcularSaldoDisponivel());
		}else {
			System.out.println("\nConta corrente não cadastrada.");
		}
	}

	private static void criarConta() {
		Conta conta;
		conta = new Conta();
		conta.setNumeroAgencia(Console.readInt("Informe o número da agência: "));
		conta.setNumeroConta(Console.readInt("Informe o número da conta: "));
		if(buscarConta(conta) == null) {
			conta.setNomeCliente(Console.readString("\nInforme o nome do cliente: "));
			conta.setLimite(Console.readFloat("Informe o valor do limite: "));
			conta.setSaldo(0);
			contas.add(conta);
		}else {
			System.out.println("\nConta corrente já cadastrada.");
		}
	}

	private static Conta buscarConta(Conta conta) {
		for(Conta item: contas) { //foreach percorre o array até achar o objeto, se achar o objeto ele retornará o objeto
			if(item.getNumeroAgencia() == conta.getNumeroAgencia() && item.getNumeroConta()== conta.getNumeroConta()) {
				return item;
			}
		}
		return null;
	}
	
	private static void atualizarConta(Conta conta) {
		int i=0;
		for(Conta item: contas) { //foreach vai percorrer o array até achar a conta procurada
			if(item.getNumeroAgencia() == conta.getNumeroAgencia() && item.getNumeroConta()== conta.getNumeroConta()) {
				contas.set(i, conta);
				return;
			}
			i++;
		}
	}
	
}
