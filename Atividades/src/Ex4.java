
public class Ex4 {
	public static void main(String[] args) {
		
		float a1, n, r;
		
		a1=Console.readFloat("Informe o primeiro termo da P.A.: ");
		n=Console.readFloat("Informe a posição do enésimo termo: ");
		r=Console.readFloat("Informe a razão da P.A.: ");
		
		System.out.println("O enésimo termo dessa P.A. é: "+(a1+(n-1)*r));
		
	}

}
