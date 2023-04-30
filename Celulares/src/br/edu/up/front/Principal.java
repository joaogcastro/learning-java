package br.edu.up.front;
import br.edu.up.entidades.*;
import br.edu.up.negocio.NegocioCelular;
import br.edu.up.persistencia.*;

public class Principal {
	public static void main(String[] args) {
		int opc=0;
		int opc1=0;
		String res="";
		Celular celular;
		
		//Adicionando exemplos para teste:
		Teste.adicionarFabricantes();
		Teste.adicionarCelularesALoja();
		Teste.adicionarAppsALoja();
		
		do {
			System.out.println("\n\n--------------------------------------------------------------"
					+ "\n                     *Menu Principal*"
					+ "\n1- Menu cadastros"
					+ "\n2- Loja de Smartphones"
					+ "\n3- Exibir lista de celulares e seus respectivos proprietarios\""
					+ "\n4- Use o seu celular"
					+ "\n5- Sair"
					+ "\n--------------------------------------------------------------");
			opc= Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
			do {
				System.out.println("\n------------------------------------------"
						+ "\n          *Menu de cadastros*"
						+ "\n1- Cadastrar fabricantes"
						+ "\n2- Cadastar celular na loja"
						+ "\n3- Cadastrar aplicativos na AppStore"
						+ "\n4- Sair"
						+ "\n------------------------------------------");
				opc1=Console.readInt("Informe a opção: ");
				
				switch(opc1) {
				case 1:
					System.out.println("\n--- Cadastrar Fabricante ---");
					Fabricante fabricante = new Fabricante();
					fabricante.setNome(Console.readString("Nome da fabricante: "));
					if(PersistenciaFabricante.verificarFabricanteCadastrado(fabricante)==false) {
						System.out.println("Agora, cadastre um modelo de celular a esta marca.");
						do {
							Modelo modelo = new Modelo();
							modelo.setNomeModelo(Console.readString("Informe o nome do modelo do celular: "));
							PersistenciaFabricante.adicionarModelo(modelo, fabricante);
							res= Console.readString("\nDeseja adicionar mais um modelo a essa marca?\nDigite S para sim N para não: ");
						}while(res.equalsIgnoreCase("S"));
						PersistenciaFabricante.adicionarFabricante(fabricante);
						
					}else {
						System.out.println("Esta fabricante já foi cadastrada.");
					}
					break;
					
				case 2:
					System.out.println("\n--- Cadastrar modelo de celular na loja ---");
					celular = new Celular();
					celular.setMarca(Console.readString("Informe a fabricante do celular: "));
					if(PersistenciaFabricante.verificarFabricanteCadastrado(celular)!=null) {
						celular.setModelo(Console.readString("Informe o modelo do celular: "));
						if(PersistenciaFabricante.verificarModeloCadastradoNaFabricante(celular)==true){
							celular.setRam(Console.readInt("Informe quantos Gb de Ram o celular possui: "));
							celular.setArmazenamento(Console.readInt("Informe quantos Gb possui o armazenamento: "));
							celular.setTamanhoTela(Console.readDouble("Informe quantas polegadas a tela possui: "));
							celular.setPreco(Console.readDouble("Informe o preço do celular: "));
							if(PersistenciaCelular.verificarCelularCadastrado(celular)==false) {
								PersistenciaCelular.adicionarCelular(celular);
								System.out.println("Modelo de celular cadastrado com sucesso!");
							}else {
								System.out.println("Este modelo de celular já está cadastrado.");
							}	
						}else {
							System.out.println("Este modelo não existe nessa marca.");
						}
					}else {
						System.out.println("Marca não cadastrada.");
					}
					break;
					
				case 3:
					System.out.println("\n--- Cadastrar Aplicativos na AppStore---");
					do {
						App app= new App();
						app.setNome(Console.readString("Informe o nome do aplicativo: "));
						if(PersistenciaApp.verificarAppCadastrado(app)==false) {
							app.setTamanho(Console.readDouble("Informe o tamanho do aplicativo, em Gb: "));
							app.setIdAutomatico();
							PersistenciaApp.adicionarApp(app);
							System.out.println("App adicionado à loja com sucesso!");
							res=Console.readString("Deseja adicionar mais um App à loja?\nS para sim, N para não: ");
						}else {
						System.out.println("Esse app já existe na loja.");
						}
					}while(res.equalsIgnoreCase("S"));
					break;
				
				case 4:
					System.out.println("Voltando ao menu principal.");
					break;
					
				default:
					System.out.println("A opção selecionada não consta no menu.");
					break;
				}
			}while (opc1!=4);
			break;
							
			case 2:
				System.out.println("\n--- Bem vindo à Loja de Smartphones ---"
						+ "\nNós possuimos os seguintes modelos: ");
				PersistenciaCelular.exibirModelos();
				celular= new Celular();
				celular.setModelo(Console.readString("Digite o modelo que deseja: "));
				celular=PersistenciaCelular.escolherCelular(celular);
				if(celular!=null) {
					celular.setIdAutomatico();
					celular.setProprietario(Console.readString("Informe seu nome: "));
					PersistenciaCelular.venderCelular(celular);
					System.out.println("Parabéns "+celular.getProprietario()+", você acaba de adquirir seu novo "+celular.getMarca()+" "+celular.getModelo()+", o id de seu novo celular é: "+celular.getId()+"!"
							+"\nPara utilizá-lo selecione a opção 4 no menu principal.");
				}else {
					System.out.println("Erro, o modelo não está na lista da loja.");
				}
				break;
			
			case 3:
				System.out.println("\n--- Lista de celulares e seus proprietários ---");
				PersistenciaCelular.exibirCelularesVendidos();
				break;
				
			case 4:
				System.out.println("\n--- Usando seu celular ---");
				celular= new Celular();
				celular.setId(Console.readInt("Informe o Id do seu celular: "));
				celular=PersistenciaCelular.retornarCelularVendido(celular);
				if(celular!=null) {
					System.out.println(celular.getProprietario()+", você selecionou seu "+celular.getMarca()+" "+celular.getModelo());
					do {
					System.out.println("\n----------------------------------------------------"
							+ "\n                * Menu do seu celular *"
							+ "\nEspaço livre em seu "+celular.getMarca()+" "+celular.getModelo()+": "+NegocioCelular.verificarEspaçoDisponível(celular)+"Gb de "+celular.getArmazenamento()+"Gb totais."
							+ "\n1- Exibir Apps intalados em seu celular."
							+ "\n2- Abrir a AppStore para instalar um novo aplicativo."
							+ "\n3- Desinstalar um aplicativo da memória do seu celular"
							+ "\n4- Informações sobre o aparelho."
							+ "\n5- Sair"
							+ "\n----------------------------------------------------");
					opc1=Console.readInt("Informe a opção: ");
					
					switch(opc1) {
					case 1:
						System.out.println("\n--- Apps instalados em seu celular ---");
						PersistenciaApp.exibirAppsInstalados(celular);
						break;
					
					case 2:
						System.out.println("\n--- App Store ---");
						System.out.println("Seja bem-vindo à App Store, nós temos no momento estes apps disponíveis para download: ");
						PersistenciaApp.exibirApps();
						do {
							App app= new App();
							app.setId(Console.readInt("Informe o id do app que deseja fazer download: "));
							if(PersistenciaApp.retornarAppInstalado(celular, app)==null) {
								app= PersistenciaApp.retornarApp(app);
								if(app!=null) {
									System.out.println("\n"+PersistenciaApp.baixarApp(app, celular));
									System.out.println("Agora o espaço disponível no armazenamento é: "+NegocioCelular.verificarEspaçoDisponível(celular)+"Gb");
								}else {
									System.out.println("Erro, o id que você digitou não corresponde a nenhum app da loja.");
								}
							}else {
								System.out.println("Erro, este app já está instalado em seu celular.");
							}
							res=Console.readString("Deseja baixar mais apps?\nDigite S para sim N para não: ");
						}while(res.equalsIgnoreCase("S"));
						PersistenciaCelular.atualizarCelularVendido(celular);
						break;
						
					case 3:
						System.out.println("\n--- Desinstalar Apps ---");
						System.out.println("Seu celular possui estes apps instalados atualmente: ");
						PersistenciaApp.exibirAppsInstalados(celular);
						do {
							App app= new App();
							app.setId(Console.readInt("Informe o id do app que deseja excluir: "));
							app= PersistenciaApp.retornarAppInstalado(celular, app);
							if(app!=null) {
								System.out.println("\n"+PersistenciaApp.excluirApp(app, celular));
								System.out.println("Agora o espaço disponível no armazenamento é: "+NegocioCelular.verificarEspaçoDisponível(celular)+"Gb");
							}else {
								System.out.println("Erro, o id que você digitou não corresponde a nenhum app instalado em seu celular.");
							}
							res=Console.readString("Deseja excluir outro app?\nDigite S para sim N para não: ");
						}while(res.equalsIgnoreCase("S"));
						PersistenciaCelular.atualizarCelularVendido(celular);
						break;
					
					case 4:
						System.out.println("\n--- Informações sobre o aparelho ---");
						System.out.println("Aparelho "+celular.getMarca()+" "+celular.getModelo()+" de "+celular.getProprietario()
						+"\nId: "+celular.getId()
						+"\nTamanho da tela: "+celular.getTamanhoTela()+" polegadas"
						+"\nMemória Ram: "+celular.getRam()+"Gb"
						+"\nCapacidade de armazenamento:"+celular.getArmazenamento()+"Gb"
						+"\nArmazenamento ocupado: "+celular.getOcupado()+"Gb"
						+"\nPreço deste aparelho novo: R$"+celular.getPreco());
						break;
						
					case 5:
						System.out.println("\nVoltando ao menu principal.\n");
						break;
						
					default:
						System.out.println("A opção selecionada não consta no menu.");
						break;
					}
					}while(opc1!=5);
					
				}else {
					System.out.println("Erro, não existe nenhum celular com esse id.");
				}
				break;
				
			case 5:
				System.out.println("O programa será finalizado, obrigado por utilizá-lo.");
				break;
				
			default:
				System.out.println("A opção selecionada não consta no menu.");
				break;
			}
		}while(opc!=5);
	}
}