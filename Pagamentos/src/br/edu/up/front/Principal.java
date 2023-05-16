package br.edu.up.front;

import java.util.ArrayList;

import br.edu.up.entidades.*;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
		Pagamento pagamento;
		Funcionario funcionario;
		
		
		funcionario= new Funcionario(1, "Altair");
		pagamento= new PagamentoComum(1, funcionario, 200, 10);
		pagamentos.add(pagamento);
		
		funcionario= new Funcionario(2, "Matheus");
		pagamento= new PagamentoComum(2, funcionario, 160, 5);
		pagamentos.add(pagamento);
		
		funcionario= new Funcionario(3, "Eliane");
		pagamento= new PagamentoComissao(3, funcionario, 200, 12, 1000);
		pagamentos.add(pagamento);
		
		funcionario= new Funcionario(4, "Vinicius");
		pagamento= new PagamentoComissao(4, funcionario, 160, 6, 600);
		pagamentos.add(pagamento);
		
		funcionario= new Funcionario(5, "Anne");
		pagamento= new PagamentoBonificacao(5, funcionario, 200, 20, 2000, 1350);
		pagamentos.add(pagamento);
		
		funcionario= new Funcionario(6, "Marie");
		pagamento= new PagamentoBonificacao(6, funcionario, 180, 15, 1200, 750);
		pagamentos.add(pagamento);
		
		for(Pagamento item: pagamentos) {
			System.out.println("\nNome funcionario: "+item.getFuncionario().getNome()
					+"\nSalário: "+item.realizarPagamento());
		}
		
	}
}
