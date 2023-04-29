import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	private static Folha buscarFolha(Folha folha) {
		for(Folha item: folhas) {
			if(item.getNomeFuncionario().equals(folha.getNomeFuncionario())
					&& folha.getMes() == item.getMes() && folha.getAno() == item.getAno()) {
				return item;
			}else {
				return null;
			}
		}
		return null;
	}
	
	private static Folha buscarFolhas(Folha folha) {
		for(Folha item: folhas) {
			if(folha.getMes() == item.getMes() && folha.getAno() == item.getAno()) {
				return item;
			}else {
				return null;
			}
		}
		return null;
	}
	
	static List<Folha> folhas= new ArrayList<>();
	public static void main(String[] args) {
		int opc;
		Folha folha = null;
		
		do {
			System.out.println("\n\n1 – Cadastro da folha"
					+ "\n2 – Consultar folha"
					+ "\n3 – Listar folha"
					+ "\n4 – Sair");
			opc= Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
				criarFolha();
				break;
				
			case 2:
				consultarFolha();
				break;
				
				
			case 3:
				listarFolhas();
				break;
			
			case 4:
				System.out.println("O programa será finalizado.");
				break;
				
			default:
				System.out.println("A opção selecionada não é válida.");
				break;
		}
		}while (opc!=4);
	}

	private static void listarFolhas() {
		Folha folha;
		float salarios=0;
		folha= new Folha();
		folha.setMes(Console.readInt("Mes: "));
		folha.setAno(Console.readInt("Ano: "));
		for(Folha item: folhas) {
			if(buscarFolhas(folha)!=null) {
				item=buscarFolhas(folha);
				System.out.println("Nome do funcionario: "+item.getNomeFuncionario());
				System.out.println("Salário líquido: "+item.calcularSalarioLiquido());
				salarios+=item.calcularSalarioLiquido();
			}
		}
		System.out.println("Total dos salários do período "+folha.getMes()+"/"+folha.getAno()+": "+salarios);
	}

	private static void consultarFolha() {
		Folha folha;
		folha= new Folha();
		folha.setNomeFuncionario(Console.readString("Nome do funcionario: "));
		folha.setMes(Console.readInt("Mes: "));
		folha.setAno(Console.readInt("Ano: "));
		if(buscarFolha(folha)!=null) {
			folha=buscarFolha(folha);
			System.out.println("\nFuncionario: "+folha.getNomeFuncionario());
			System.out.println("Mês: "+folha.getMes());
			System.out.println("Ano: "+folha.getAno());
			System.out.println("Horas trabalhadas: "+folha.getNumHoras());
			System.out.println("Valor da hora: "+folha.getValorHora());
			System.out.println("Salário bruto: "+folha.calcularSalarioBruto(folha.getNumHoras(), folha.getValorHora()));
			System.out.println("Imposto de renda: "+folha.calcularImpostoRenda());
			System.out.println("INSS: "+folha.calcularInss());
			System.out.println("FGTS: "+folha.calcularFgts());
			System.out.println("Salário Líquido: "+folha.calcularSalarioLiquido());
		}else {
			System.out.println("A folha não foi encontrada.");
		}
	}

	private static void criarFolha() {
		Folha folha;
		folha= new Folha();
		folha.setNomeFuncionario(Console.readString("Nome do funcionario: "));
		folha.setMes(Console.readInt("Mes: "));
		folha.setAno(Console.readInt("Ano: "));
		if(buscarFolha(folha)==null) {
			folha.setNumHoras(Console.readInt("Número de horas trabalhadas: "));
			folha.setValorHora(Console.readFloat("Valor da hora: "));
			folhas.add(folha);
		}else {
			System.out.println("Esta folha de pagamento já foi registrada.");
		}
	}
}
