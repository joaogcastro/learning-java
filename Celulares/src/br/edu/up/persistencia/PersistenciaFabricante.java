package br.edu.up.persistencia;
import java.util.ArrayList;

import br.edu.up.entidades.Celular;
import br.edu.up.entidades.Fabricante;
import br.edu.up.entidades.Modelo;

public class PersistenciaFabricante {
	
	private static ArrayList<Fabricante> listaFabricantes = new ArrayList<Fabricante>();
	
	public static void adicionarFabricante (Fabricante fabricante) {
		listaFabricantes.add(fabricante);
	}
	
	public static boolean verificarFabricanteCadastrado (Fabricante fabricante) {
		for(Fabricante item: listaFabricantes) {
			if(item.getNome().equals(fabricante.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verificarModeloCadastradoNaFabricante(Modelo modelo, Fabricante fabricante) {
	    for (Modelo item : fabricante.getModelos()) {
	        if (item.getNomeModelo().equalsIgnoreCase(modelo.getNomeModelo())) {
	            return true;
	        }
	    }
	    return false;
	}

	public static void adicionarModelo(Modelo modelo, Fabricante fabricante) {
	    if (verificarModeloCadastradoNaFabricante(modelo, fabricante) == false) {
	        fabricante.getModelos().add(modelo);
	        System.out.println("Modelo " + modelo.getNomeModelo() + " cadastrado com sucesso à fabricante " + fabricante.getNome());
	    } else {
	        System.out.println("O modelo " + modelo.getNomeModelo() + " já existe na fabricante " + fabricante.getNome() + ", portanto não foi cadastrado.");
	    }
	}

	public static Fabricante verificarFabricanteCadastrado (Celular celular) {
		for(Fabricante item: listaFabricantes) {
			if(item.getNome().equals(celular.getMarca())) {
				return item;
			}
		}
		return null;
	}
	
	public static boolean verificarModeloCadastradoNaFabricante(Celular celular) {
		Fabricante fabricante= verificarFabricanteCadastrado(celular);
		if(fabricante !=null) {
			for (Modelo item : fabricante.getModelos()) {
				if (item.getNomeModelo().equalsIgnoreCase(celular.getModelo())) {
					return true;
				}
			}
			return false;
		}else {
			return false;
		}
	}
}
