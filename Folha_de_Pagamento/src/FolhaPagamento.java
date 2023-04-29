public class FolhaPagamento {
	public static void main(String[] args) {
		
		int opc, mes=0, ano=0, nhoras=0;
		float valorhora=0;
		String nomefuncionario="0";
		
		do {
			System.out.println("\n\nSelecione uma opção:"
					+ "\n1 - Ler dados"
					+ "\n2 - Calcular Salário Líquido"
					+ "\n3 - Sair");
			opc = Console.readInt("Informe  a opção: ");
			
			switch(opc) {
			case 1:
				nomefuncionario= Console.readString("Informe o nome do funcionário: ");
				mes = Console.readInt("Informe o mês: ");
				ano = Console.readInt("Informe o ano: ");
				nhoras = Console.readInt("Informe o número de horas trabalhadas: ");
				valorhora = Console.readFloat("Informe o valor da hora: ");
				break;
				
			case 2:
				if(nhoras==0) {
					System.out.println("Você deve preencher os dados na opção 1 para poder usar a opção 2.");
					break;
				}else {
					System.out.println("Dados do funcionário "+nomefuncionario+"\nData: "+mes+"/"+ano);
					System.out.println("Salario Bruto: "+FolhaMetodos.salarioBruto(nhoras, valorhora));
					System.out.println("Imposto de Renda: "+FolhaMetodos.impostoRenda());
					System.out.println("INSS: "+FolhaMetodos.inss());
					System.out.println("FGTS: "+FolhaMetodos.fgts());
					System.out.println("Salário Líquido: "+FolhaMetodos.salarioLiquido());
					break;
				}
				
			case 3:
				System.out.println("O programa será finalizado.");
				break;
				
			default:
				System.out.println("Erro, esta opção não existe!");
				break;
			}
		}while(opc!=3);
		
	}
}