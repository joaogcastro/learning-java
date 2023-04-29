public class Folha {
	private String nome_funcionario;
	private int mes;
	private int ano;
	private int nhoras;
	private float valorhora;
	
	float sbruto, ir, inss;
	
	public float calcularSalarioBruto(int nhora, float vhora) {
		sbruto = nhora*vhora;
		return sbruto;
	}
	
	public float calcularImpostoRenda() {
		if(sbruto<=1372.82) {
			ir= 0;
		}else if(sbruto>=1372.83 && sbruto<=2743.25) {
			ir= sbruto*0.15f-205.92f;
		}else {
			ir= sbruto*0.275f-548.82f;
		}
		return ir;
	}
	
	public float calcularInss() {
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
	
	public float calcularFgts() {
		return sbruto*0.08f;
	}
	
	public float calcularSalarioLiquido() {
		return sbruto-ir-inss;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNhoras() {
		return nhoras;
	}

	public void setNhoras(int nhoras) {
		this.nhoras = nhoras;
	}

	public float getValorhora() {
		return valorhora;
	}

	public void setValorhora(float valorhora) {
		this.valorhora = valorhora;
	}

	public float getSbruto() {
		return sbruto;
	}

	public void setSbruto(float sbruto) {
		this.sbruto = sbruto;
	}

	public float getIr() {
		return ir;
	}

	public void setIr(float ir) {
		this.ir = ir;
	}

	public float getInss() {
		return inss;
	}

	public void setInss(float inss) {
		this.inss = inss;
	}
	
	
}