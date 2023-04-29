package br.edu.up.front;
import br.edu.up.entidades.*;
import br.edu.up.persistencia.*;
import br.edu.up.negocio.*;

public class Principal {
	public static void main(String[] args) {
		
		int opc;
		do {
			System.out.println("\n\n------------------------------------"
					+ "\n1 - Cadastrar cliente"
					+ "\n2 - Cadastrar vendedor"
					+ "\n3 - Cadastrar produto"
					+ "\n4 - Nova venda"
					+ "\n5 - Consultar venda"
					+ "\n6 - Listar vendas"
					+ "\n7 - Sair"
					+ "\n------------------------------------");
			opc= Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
				System.out.println("\n--- Cadastrar cliente ---");
				Cliente cliente = new Cliente();
				cliente.setNome(Console.readString("Informe o nome do cliente: "));
				cliente.setCpf(Console.readString("Informe o CPF do cliente: "));
				if(Negocio.validarCPF(cliente.getCpf())==true) {
					if(PersistenciaCliente.verificarClienteCadastrado(cliente)==false) {
						PersistenciaCliente.adicionarCliente(cliente);
						System.out.println("Cliente cadastrado com sucesso!");
					}else {
						System.out.println("Este cliente já foi cadastrado.");
					}
				}else {
					System.out.println("CPF inválido.");
				}
				break;
				
			case 2:
				System.out.println("\n--- Cadastrar vendedor ---");
				Vendedor vendedor = new Vendedor();
				vendedor.setNome(Console.readString("Informe o nome do vendedor: "));
				vendedor.setCpf(Console.readString("Informe o CPF do vendedor: "));
				if(Negocio.validarCPF(vendedor.getCpf())==true) {
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
				
			case 4:
				System.out.println("\n--- Nova Venda ---");
				Venda venda = new Venda();
				venda.setId(Console.readInt("Informe o Id da venda: "));
				if(PersistenciaVenda.verificarVendaCadastrada(venda)==false) {
					cliente = new Cliente();
					cliente.setCpf(Console.readString("Informe o CPF do cliente: "));
					if(Negocio.validarCPF(cliente.getCpf())==true) {
						cliente= PersistenciaCliente.retornarCliente(cliente);
						if(cliente !=null) {
								System.out.println("Cliente encontrado.");
								venda.setNomeCliente(cliente);
								vendedor = new Vendedor();
								vendedor.setCpf(Console.readString("Informe o CPF do vendedor"));
								if(Negocio.validarCPF(vendedor.getCpf())==true) {
									PersistenciaVendedor.retornarVendedor(vendedor);
									if(vendedor!=null) {
										venda.setNomeVendedor(vendedor);
										venda.setData(Console.readString("Informe a data da venda: "));
										String resposta ="S";
										do {
											Item itemVenda = new Item();
											produto= new Produto();
											produto.setNome(Console.readString("Informe o nome do produto: "));
											produto= PersistenciaProduto.retornarProduto(produto);
											if(produto!=null) {
												System.out.println("Produto encontrado.");
												itemVenda.setNomeProduto(produto);
												itemVenda.setQuantidade(Console.readInt("Informe a quantidade do produto: "));
												itemVenda.setUnitario(NegocioProduto.calcularPrecoVenda(produto));
												System.out.println("Valor unitário: "+NegocioProduto.calcularPrecoVenda(produto));
												venda.getItens().add(itemVenda);
												
												
											}else {
												System.out.println("Produto não cadastrado.");
											}
										}while(resposta.equals("S"));
									}else {
										System.out.println("Vendedor não cadastrado.");
									}
								}else {
									System.out.println("CPF inválido.");
								}
							
						}else {
							System.out.println("Cliente não cadastrado. ");
						}
						
					}else {
						System.out.println("CPF inválido.");
					}
				}else {
					System.out.println("Esta venda já está cadastrada.");
				}
			break;
			
			
				
			}
			
		}while(opc!=7);
	}
}
