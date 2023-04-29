package br.edu.up.front;
import br.edu.up.entidades.*;
import br.edu.up.persistencia.PersistenciaCliente;
import br.edu.up.persistencia.PersistenciaProduto;
import br.edu.up.persistencia.PersistenciaVendedor;

public class Principal {
	public static void main(String[] args) {
		int opc;
		
		do {
			System.out.println("\n\n------------------------------------"
					+ "\n1 - Cadastrar cliente"
					+ "\n2 - Cadastrar vendedor"
					+ "\n3 - Cadastrar produto"
					+ "\n4 - Nova venda"
					+ "\n5 - Consulta da venda"
					+ "\n6 - Listagem de vendas"
					+ "\n7 - Sair"
					+ "\n------------------------------------");
			opc= Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
				System.out.println("\n--- Cadastrar cliente ---");
				Cliente cliente = new Cliente();
				cliente.setNome(Console.readString("Informe o nome do cliente: "));
				cliente.setCpf(Console.readString("Informe o CPF do cliente: "));
				//if validar cpf
					//if cpf nao repetido
						PersistenciaCliente.adicionarCliente(cliente);
						System.out.println("Cliente cadastrado com sucesso!");
					//else
				//else
				break;
				
			case 2:
				System.out.println("\n--- Cadastrar vendedor ---");
				Vendedor vendedor = new Vendedor();
				vendedor.setNome(Console.readString("Informe o nome do vendedor: "));
				vendedor.setCpf(Console.readString("Informe o CPF do vendedor: "));
				if(ValidadorCPF.validarCPF(vendedor.getCpf())==true) {
					System.out.println("CPF válido.");
					if(PersistenciaVendedor.verificarVendedorCadastrado(vendedor)==false) {
						vendedor.setComissao(Console.readDouble("Informe a taxa de comissão do vendedor, em porcentagem: "));
						PersistenciaVendedor.adicionarVendedor(vendedor);
						System.out.println("Vendedor cadastrado com sucesso!");
					}else {
						System.out.println("Este vendedor já foi cadastrado.");
					}
				}else {
					System.out.println("CPF inválido.");
				}
				break;
				
			case 3:
				System.out.println("\n--- Cadastrar produto ---");
				Produto produto = new Produto();
				produto.setNome(Console.readString("Informe o nome do produto: "));
				if(PersistenciaProduto.verificarProdutoCadastrado(produto)==false) {
					produto.setPreco(Console.readDouble("Informe o preço de compra do produto: "));
					produto.setMarkup(Console.readDouble("Informe o markup do produto: "));
					PersistenciaProduto.adicionarProduto(produto);
					System.out.println("Produto cadastrado com sucesso!");
				}else {
					System.out.println("Este produto já está cadastrado.");
				}
				break;
				
				
			}
			
		}while(opc!=7);
	}
}
