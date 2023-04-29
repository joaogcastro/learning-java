package br.edu.up.front;
import br.edu.up.entidades.*;
import br.edu.up.persistencia.PersistenciaFabricante;

public class Principal {
	public static void main(String[] args) {
		int opc;
		
		do {
			System.out.println("1- Cadastrar fabricante"
					+ "\n2- Cadastrar celular"
					+ "\n3- Cadastrar aplicativos"
					+ "\n4- Ver dados celular"
					+ "\n5- Sair");
			opc= Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
				System.out.println("\n--- Cadastrar Fabricante ---");
				Fabricante fabricante = new Fabricante();
				fabricante.setNome(Console.readString("Nome da fabricante: "));
				String res;
				do {
					Modelo modelo = new Modelo();
					Modelo.setModelo(Console.readString("Informe o modelo do celular: "));
					fabricante.getModelos().add(modelo);
					res= Console.readString("\nDeseja adicionar mais um modelo a essa marca? \nS para sim N para não");
				}while(res.equals("S") || res.equals("s"));
				break;
				
			case 2:
				System.out.println("\n--- Cadastrar Celular ---");
				Celular celular = new Celular();
				celular.setMarca(Console.readString("Informe a marca do celular: "));
				if(PersistenciaFabricante.verificarMarca(celular.getMarca())) {
					celular.setModelo(Console.readString("Informe o modelo do celular: "));
					if(PersistenciaFabricante.verficarModelo(celular.getMarca(), celular.getModelo())){
						celular.setRam(Console.readInt("Informe quantos Gb de Ram o celular possui: "));
						celular.setArmazenamento(Console.readInt("Informe quantos Gb possui o armazenamento: "));
						celular.setTamanhoTela(Console.readDouble("Informe quantas polegadas a tela possui: "));
						celular.setPreco(Console.readDouble("Informe o preço do celular: "));
					}
				}else {
					System.out.println("Marca não cadastrada.");
				}
				
			}
		}while(opc!=5);
	}

}
