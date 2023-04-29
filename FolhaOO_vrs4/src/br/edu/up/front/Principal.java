package br.edu.up.front;
import br.edu.up.entidades.Folha;
import br.edu.up.persistencia.FolhaPersistencia;
import br.edu.up.negocio.FolhaNegocio;

public class Principal {
	public static void main(String[] args) {
		int opc;
		
		do {
			System.out.println("\n\n1 – Cadastro da folha"
					+ "\n2 – Consultar folha"
					+ "\n3 – Listar folhas"
					+ "\n4 – Sair");
			opc=Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
				Folha folha= new Folha();
				System.out.println("\nCadastrar folha");
				folha.setNomeFuncionario(Console.readString("Informe o nome do funcionário: "));
				folha.setMes(Console.readInt("Informe o mês: "));
				folha.setAno(Console.readInt("Informe o ano: "));
				if(FolhaPersistencia.buscarFolha(folha)==null) {
					folha.setnHoras(Console.readInt("Informe o número de horas trabalhadas no mês: "));
					folha.setValorHora(Console.readFloat("Informe o valor da hora de trabalho: "));
					System.out.println("Folha de pagamento do funcionário "+folha.getNomeFuncionario()+" de data "+folha.getMes()+"/"+folha.getAno()+" cadastrada com sucesso!");
					FolhaPersistencia.cadastrarFolha(folha);
				}else {
					System.out.println("Esta folha já está cadastrada.");
				}
				break;
				
			case 2:
				folha= new Folha();
				System.out.println("\nConsultar folha");
				folha.setNomeFuncionario(Console.readString("Informe o nome do funcionário: "));
				folha.setMes(Console.readInt("Informe o mês: "));
				folha.setAno(Console.readInt("Informe o ano: "));
				if(FolhaPersistencia.buscarFolha(folha)!=null) {
					System.out.println("Folha de pagamento encontrada!");
					folha=FolhaPersistencia.buscarFolha(folha);
					System.out.println("\nNome do funcionário: "+folha.getNomeFuncionario());
					System.out.println("Mês: "+folha.getMes());
					System.out.println("Ano: "+folha.getAno());
					System.out.println("Horas trabalhadas: "+folha.getnHoras());
					System.out.println("Valor da hora de trabalho: "+folha.getValorHora());
					System.out.println("Salário bruto: "+FolhaNegocio.calcularSalarioBruto(folha.getnHoras(), folha.getValorHora()));
					System.out.println("Imposto de renda: "+FolhaNegocio.calcularIR(folha.getnHoras(), folha.getValorHora()));
					System.out.println("INSS: "+FolhaNegocio.calcularINSS(folha.getnHoras(), folha.getValorHora()));
					System.out.println("FGTS: "+FolhaNegocio.calcularFGTS(folha.getnHoras(), folha.getValorHora()));
					System.out.println("Salário líquido: "+FolhaNegocio.calcularSalarioLiquido(folha.getnHoras(), folha.getValorHora()));
				}else {
					System.out.println("A folha de pagamento não foi encontrada.");
				}
				break;
				
			case 3:
				folha= new Folha();
				float totalSalarios=0;
				System.out.println("\nListar folhas");
				folha.setMes(Console.readInt("Informe o mês: "));
				folha.setAno(Console.readInt("Informe o ano: "));
				for(Folha item: FolhaPersistencia.listarFolhas(folha)) {
					System.out.println("\nNome funcionario: "+item.getNomeFuncionario());
					System.out.println("Salário líquido: "+FolhaNegocio.calcularSalarioLiquido(item.getnHoras(), item.getValorHora()));
					totalSalarios+=FolhaNegocio.calcularSalarioLiquido(item.getnHoras(), item.getValorHora());
				}
				System.out.println("\nTotal dos salários dos funcionários: "+totalSalarios);
				break;
				
			case 4:
				System.out.println("\nO programa será finalizado.");
				break;
				
			default:
				System.out.println("\nA opção selecionada não é válida.");
				break;
			}
	
		}while(opc!=4);
		
		
	}
}