public class FolhaMetodos {
	
	static float sbruto, ir, inss;
	
	public static float salarioBruto(int nhora, float vhora) {
		sbruto = nhora*vhora;
		return sbruto;
	}
	
	public static float impostoRenda() {
		if(sbruto<=1372.82) {
			ir= 0;
		}else if(sbruto>=1372.83 && sbruto<=2743.25) {
			ir= sbruto*0.15f-205.92f;
		}else {
			ir= sbruto*0.275f-548.82f;
		}
		return ir;
	}
	
	public static float inss() {
		if(sbruto<=868.29) {
			inss= sbruto*0.08f;
		}else if(sbruto>=868.30 && sbruto<=1447.14) {
			inss= sbruto*0.09f;
		}else if(sbruto>=1447.14 && sbruto<=28984.28) {
			inss= sbruto*0.11f;
		}else {
			inss= 318.37f;
		}
		return inss;
	}
	
	public static float fgts() {
		return sbruto*0.08f;
	}
	
	public static float salarioLiquido() {
		return sbruto-ir-inss;
	}

}
