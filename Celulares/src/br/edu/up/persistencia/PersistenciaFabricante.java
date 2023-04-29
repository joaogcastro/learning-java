package br.edu.up.persistencia;
import java.util.ArrayList;
import br.edu.up.entidades.Fabricante;
import br.edu.up.entidades.Modelo;

public class PersistenciaFabricante {
	
	private static ArrayList<Fabricante> listaFabricantes = new ArrayList<Fabricante>();
	
	public static boolean verificarMarca (String nome) {
		for(Fabricante item: listaFabricantes) {
			if(item.getNome().equals(nome)==true) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verficarModelo (String marca ,String modelo) {
		for(Fabricante item: listaFabricantes) {
			if(item.getNome().equals(marca)==true) {
				for(Modelo i: item.getModelos()) {
					if(i.getModelo().equals(modelo)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
