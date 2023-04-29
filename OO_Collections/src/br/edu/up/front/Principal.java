package br.edu.up.front;
import br.edu.up.entidades.Armazenamento;
import br.edu.up.negocio.ArmazenamentoNegocio;
import br.edu.up.persistencia.ArmazenamentoPersistencia;

public class Principal {
	public static void main(String[] args) {
		int opc;
		
		do {
			System.out.println("\n\n1 - Criar unidade de armazenamento"
					+ "\n2 - Gravar dados"
					+ "\n3 - Apagar dados"
					+ "\n4 - Verificar espaço disponível"
					+ "\n5 - Sair");
			opc= Console.readInt("Escolha a opção: ");	
			
			switch(opc) {
			case 1:
				Armazenamento armazenamento = new Armazenamento();
				armazenamento.setTipo(Console.readString("Informe o tipo do armazenamento: "));
				armazenamento.setTamanhoOriginal(Console.readFloat("Informe o tamanho do armazenamento: "));
				if(ArmazenamentoPersistencia.buscarUnidade(armazenamento)==null) {
					ArmazenamentoPersistencia.incluirUnidade(armazenamento);
					System.out.println("Unidade "+armazenamento.getTipo()+" com "+armazenamento.getTamanho()+" Gbytes "+"criada com sucesso.");
				}else {
					System.out.println("Esta unidade de armazenamento já está cadastrada.");
				}
				break;
			
			case 2:
				armazenamento = new Armazenamento();
				armazenamento.setTipo(Console.readString("Informe o tipo do armazenamento: "));
				if(ArmazenamentoPersistencia.buscarUnidade(armazenamento)!=null) {
					System.out.println("Unidade encontrada!");
					armazenamento= ArmazenamentoPersistencia.buscarUnidade(armazenamento);
					String unidadeMedida= Console.readString("Informe a unidade de medida a ser gravada (bytes, kbytes, mbytes, gbytes): ");
					float quantidadeInfo= Console.readFloat("Informe a quantidade de informação a ser gravada: ");
					System.out.println("\n\n"+ArmazenamentoNegocio.gravarDados(armazenamento, unidadeMedida, quantidadeInfo));
					System.out.println("Agora o espaço disponível em "+armazenamento.getTipo()+" é de "+armazenamento.getTamanho()+" Gbytes.");
					ArmazenamentoPersistencia.atualizarUnidade(armazenamento);
				}else {
					System.out.println("Unidade de armazenamento não encontrada.");
				}
				break;
			
			case 3:
				armazenamento = new Armazenamento();
				armazenamento.setTipo(Console.readString("Informe o tipo do armazenamento: "));
				if(ArmazenamentoPersistencia.buscarUnidade(armazenamento)!=null) {
					System.out.println("Unidade encontrada!");
					armazenamento= ArmazenamentoPersistencia.buscarUnidade(armazenamento);
					String unidadeMedida= Console.readString("Informe a unidade de medida a ser apagada (bytes, kbytes, mbytes, gbytes): ");
					float quantidadeInfo= Console.readFloat("Informe a quantidade de informação a ser apagada: ");
					System.out.println("\n\n"+ArmazenamentoNegocio.apagarDados(armazenamento, unidadeMedida, quantidadeInfo));
					System.out.println("Agora o espaço disponível em "+armazenamento.getTipo()+" é de "+armazenamento.getTamanho()+" Gbytes.");
					ArmazenamentoPersistencia.atualizarUnidade(armazenamento);
				}else {
					System.out.println("Unidade de armazenamento não encontrada.");
				}
				break;
			
			case 4:
				armazenamento = new Armazenamento();
				armazenamento.setTipo(Console.readString("Informe o tipo do armazenamento: "));
				if(ArmazenamentoPersistencia.buscarUnidade(armazenamento)!=null) {
					armazenamento= ArmazenamentoPersistencia.buscarUnidade(armazenamento);
					System.out.println("Unidade encontrada!");
					System.out.println("\nUnidade: "+armazenamento.getTipo());
					System.out.println("Espaço total: "+armazenamento.getTamanhoOriginal()+" Gbytes.");
					System.out.println("Espaço ocupado: "+(armazenamento.getTamanhoOriginal()-armazenamento.getTamanho())+" Gbytes  "+((armazenamento.getTamanhoOriginal()-armazenamento.getTamanho())/armazenamento.getTamanhoOriginal()*100)+"%");
					System.out.println("Espaço disponível: "+armazenamento.getTamanho()+" Gbytes  "+(armazenamento.getTamanho()/armazenamento.getTamanhoOriginal()*100)+"%");
				}else {
					System.out.println("Unidade de armazenamento não encontrada.");
				}
				break;
			
			case 5:
				System.out.println("O programa será finalizado.");
				break;
			
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}while(opc!=5);
	}
}