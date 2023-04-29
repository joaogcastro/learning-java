public class Principal {
	public static void main(String[] args) {
		
		int opc;
		boolean verificacao=false;
		
		Folha folha=null;
		
		do {
			System.out.println("\n\nSelecione uma opção:"
					+ "\n1 - Ler dados"
					+ "\n2 - Calcular Salário Líquido"
					+ "\n3 - Sair");
			opc = Console.readInt("Informe  a opção: ");
			
			switch(opc) {
			case 1:
				folha = new Folha();
				folha.setNome_funcionario(Console.readString("Informe o nome do funcionário: "));
				folha.setMes(Console.readInt("Informe o mês: "));
				folha.setAno(Console.readInt("Informe o ano: "));
				folha.setNhoras(Console.readInt("Informe o número de horas trabalhadas: "));
				folha.setValorhora(Console.readFloat("Informe o valor da hora: "));
				verificacao=true;
				break;
				
			case 2:
				if(verificacao==false) {
					System.out.println("Você deve preencher os dados na opção 1 para poder usar a opção 2.");
					break;
				}else {
					System.out.println("Salario Bruto: "+folha.calcularSalarioBruto(folha.getNhoras(), folha.getValorhora()));
					System.out.println("Imposto de Renda: "+folha.calcularImpostoRenda());
					System.out.println("INSS: "+folha.calcularInss());
					System.out.println("FGTS: "+folha.calcularFgts());
					System.out.println("Salário líquido: "+folha.calcularSalarioLiquido());
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