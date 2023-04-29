package br.edu.up.negocio;
import br.edu.up.entidades.Armazenamento;

public class ArmazenamentoNegocio {
	
	private static float verificarTamanho (Armazenamento armazenamento, String unidadeMedida, float quantidadeInfo, String operacao) {
	float res;
	if(operacao=="gravar") {
		switch(unidadeMedida) {
		case "bytes":
			res=(armazenamento.getTamanho()-(quantidadeInfo/1024/1024/1024));
			return res;
		case "kbytes":
			res=(armazenamento.getTamanho()-(quantidadeInfo/1024/1024));
			return res;
		case "mbytes":
			res=(armazenamento.getTamanho()-(quantidadeInfo/1024));
			return res;
		case "gbytes":
			res=(armazenamento.getTamanho()-quantidadeInfo);
			return res;
		default:
			return 0;
		}
	}else if(operacao=="apagar") {
		switch(unidadeMedida) {
		case "bytes":
			res=(armazenamento.getTamanho()+(quantidadeInfo/1024/1024/1024));
			return res;
		case "kbytes":
			res=(armazenamento.getTamanho()+(quantidadeInfo/1024/1024));
			return res;
		case "mbytes":
			res=(armazenamento.getTamanho()+(quantidadeInfo/1024));
			return res;
		case "gbytes":
			res=(armazenamento.getTamanho()+quantidadeInfo);
			return res;
		default:
			return 0;
		}
	}else {
		return 0;
	}
	}
	
	public static String gravarDados (Armazenamento armazenamento, String unidadeMedida, float quantidadeInfo) {
		String op="gravar";
		if(verificarTamanho(armazenamento, unidadeMedida, quantidadeInfo, op)>=0) {
			armazenamento.setTamanho(verificarTamanho(armazenamento, unidadeMedida, quantidadeInfo, op));
			return "Dados gravados com sucesso.";
		}
		return "Não há espaço suficiente para gravação desses dados.";
	}
	
	public static String apagarDados (Armazenamento armazenamento, String unidadeMedida, float quantidadeInfo) {
		String op="apagar";
		if(verificarTamanho(armazenamento, unidadeMedida, quantidadeInfo, op)<=armazenamento.getTamanhoOriginal()) {
			armazenamento.setTamanho(verificarTamanho(armazenamento, unidadeMedida, quantidadeInfo, op));
			return "Dados apagados com sucesso.";
		}
		return "Não é possível excluir mais dados do que o espaço disponível da unidade.";
	}	
}