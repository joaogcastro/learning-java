public class Metodos {
	/*Modularização e Reutilização, pode ser reutilizado por qualquer classe*/
	public static String verificarValor(int v) {
		if(v%2==0) {
			return "Par";
		}else {
			return "Ímpar";
		}
	}
	
	public static int calcularQuadrado(int v) {
		return (v*v);
	}
		
	public static float calcular(float v, char op, float v1) {
		switch (op) {
		case '+':
			return v+v1;
		case'-':
			return v-v1;
		case'*':
			return v*v1;
		case'/':
			return v/v1;
		default:
			return 0;
		}
	}
	
}