package br.edu.up.persistencia;

import java.util.ArrayList;
import br.edu.up.entidades.Celular;

public class PersistenciaCelular {
	
	private static ArrayList<Celular> listaCelulares = new ArrayList<>();
	
	public static ArrayList<Celular> getListaCelulares() {
		return listaCelulares;
	}
	
	public static void adicionarCelular (Celular celular) {
		listaCelulares.add(celular);
	}
	
	public static boolean verificarCelularCadastrado (Celular celular) {
		for(Celular item: listaCelulares) {
			if(item.getMarca().equals(celular.getMarca()) && item.getModelo().equals(celular.getModelo()) || item.getArmazenamento()==celular.getArmazenamento()) {
				return true;
			}
		}
		return false;
	}
	
	public static void exibirModelos () {
		if(listaCelulares.isEmpty()==false) {
			for(Celular item: listaCelulares) {
				System.out.println("Marca: "+item.getMarca()+"   Modelo: "+item.getModelo()+"   Armazenamento: "+item.getArmazenamento()+"Gb"+"   Preço: "+item.getPreco());
			}
		}else {
			System.out.println("Não há modelos cadastrados no estoque da loja.");
		}
	}
	
	public static Celular escolherCelular(Celular celular) {
	    for (Celular item : listaCelulares) {
	        if (item.getModelo().trim().equalsIgnoreCase(celular.getModelo().trim())) {
	            return item;
	        }
	    }
	    return null;
	}
	
	private static ArrayList<Celular> celularesVendidos = new ArrayList<>();
	
	public static ArrayList<Celular> getCelularesVendidos() {
		return celularesVendidos;
	}
	
	public static void venderCelular (Celular celular) {
		celularesVendidos.add(celular);
	}
	
	public static Celular retornarCelularVendido (Celular celular) {
		for(Celular item: celularesVendidos) {
			if(item.getId()==celular.getId()) {
				return item;
			}
		}
		return null;
	}
	
	public static void atualizarCelularVendido (Celular celular) {
		int i=0;
		for(Celular item: celularesVendidos) {
			if(item.getId()==celular.getId()) {
				celularesVendidos.set(i, celular);
				System.out.println("As alterações foram salvas.");
				return;
			}
			i++;
		}
		System.out.println("Houve um erro ao salvar as alterações.");
	}

	public static void exibirCelularesVendidos () {
		if(celularesVendidos.isEmpty()==false) {
			for(Celular item: celularesVendidos) {
				System.out.println("Id: "+item.getId()+"   Proprietário: "+item.getProprietario()+"   Celular: "+item.getMarca()+" "+item.getModelo());
			}
		}else {
			System.out.println("Nenhum celular foi vendido ainda.");
		}
	}
}