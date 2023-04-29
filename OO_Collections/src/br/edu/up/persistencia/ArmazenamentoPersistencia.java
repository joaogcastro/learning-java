package br.edu.up.persistencia;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.entidades.Armazenamento;

public class ArmazenamentoPersistencia {
	
	private static List<Armazenamento> unidadesArmazenamento = new ArrayList<Armazenamento>();
	
	public static void incluirUnidade (Armazenamento armazenamento) {
		unidadesArmazenamento.add(armazenamento);
		return;
	}
	
	public static Armazenamento buscarUnidade (Armazenamento armazenamento) {
		for(Armazenamento item: unidadesArmazenamento) {
			if(item.getTipo().equals(armazenamento.getTipo())) {
				return item;
			}
		}
		return null;
	}

	public static void atualizarUnidade (Armazenamento armazenamento) {
		int i=0;
		for(Armazenamento item: unidadesArmazenamento) {
			if(item.getTipo().equals(armazenamento.getTipo())) {
				unidadesArmazenamento.set(i, armazenamento);
				return;
			}
			i++;
		}
	}
}