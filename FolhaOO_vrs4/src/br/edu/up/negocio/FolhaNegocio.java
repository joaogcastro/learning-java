package br.edu.up.negocio;

public class FolhaNegocio {
	
	public static float calcularSalarioBruto(int nhoras, float vhora) {
		return nhoras*vhora;
	}
	
	public static float calcularIR(int nhoras, float vhora){
		float salario=calcularSalarioBruto(nhoras, vhora)-calcularINSS(nhoras, vhora);
		if(salario<=1372.81) {
			return 0;
		}else if(salario>1372.81 && salario<=2743.25) {
			return salario*0.15f+205.92f; 
		}else {
			return salario*0.275f+548.82f;
		}
	}
	
	public static float calcularINSS(int nhoras, float vhora) {
		float sbruto=calcularSalarioBruto(nhoras, vhora);
		if(sbruto<=868.29) {
			return sbruto*0.08f;
		}else if(sbruto>868.29 && sbruto<=1447.14) {
			return sbruto*0.09f;
		}else if(sbruto>1447.14 && sbruto<=2894.28) {
			return sbruto*0.11f;
		}else {
			return 318.37f;
		}
	}
	
	public static float calcularFGTS(int nhoras, float vhora) {
		float sbruto= calcularSalarioBruto(nhoras, vhora);
		return sbruto*0.08f;
	}
	
	public static float calcularSalarioLiquido(int nhoras, float vhora) {
		return calcularSalarioBruto(nhoras, vhora) - calcularIR(nhoras, vhora) - calcularINSS(nhoras, vhora);
	}

}
