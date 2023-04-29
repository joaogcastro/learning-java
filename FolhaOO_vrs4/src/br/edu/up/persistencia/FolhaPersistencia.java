package br.edu.up.persistencia;
import br.edu.up.entidades.Folha;
import java.util.ArrayList;
import java.util.List;

public class FolhaPersistencia {
	
	private static List<Folha> bancoFolhas = new ArrayList<Folha>();
	
	public static Folha buscarFolha(Folha folha) {
		for(Folha item: bancoFolhas) {
			if(item.getNomeFuncionario().equals(folha.getNomeFuncionario()) && item.getMes()==folha.getMes() && item.getAno()==folha.getAno()) {
				return item;
			}
		}
		return null;
	}
	
	public static void cadastrarFolha (Folha folha) {
		bancoFolhas.add(folha);
	}
	
	public static ArrayList<Folha> listarFolhas(Folha folha) {
		List<Folha> listaFolhas = new ArrayList<Folha>();
		for(Folha item: bancoFolhas) {
			if(item.getMes()==folha.getMes() && item.getAno()==folha.getAno()) {
				listaFolhas.add(item);
			}
		}
		return (ArrayList<Folha>) listaFolhas;
	}
	
}