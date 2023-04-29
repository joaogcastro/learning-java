package br.edu.up.persistencia;
import br.edu.up.entidades.Item;
import br.edu.up.entidades.Venda;

public class PersistenciaVendas {
	
	public static String adicionarItem(Venda venda, Item item) {
        // Verificar se o item já foi adicionado
        for (Item i : venda.getItens()) {
            if (i.getNomeProduto().equals(item.getNomeProduto())) {
                return "Erro: O item já foi adicionado!"; // Item já foi adicionado, não permitir a adição novamente
            }
        }

        // Adicionar o item à lista
        venda.getItens().add(item);
        return "Item adicionado com sucesso!";
    }
}
