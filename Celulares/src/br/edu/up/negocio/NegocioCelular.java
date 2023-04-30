package br.edu.up.negocio;
import br.edu.up.entidades.Celular;

public class NegocioCelular {
	
	public static double verificarEspaçoDisponível (Celular celular) {
		return celular.getArmazenamento()-celular.getOcupado();
	}
}
