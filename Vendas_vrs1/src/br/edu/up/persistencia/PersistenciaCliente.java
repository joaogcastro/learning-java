package br.edu.up.persistencia;
import java.util.ArrayList;

import br.edu.up.entidades.Cliente;

public class PersistenciaCliente {
	
	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public static void adicionarCliente (Cliente cliente) {
		listaClientes.add(cliente);
	}

}
