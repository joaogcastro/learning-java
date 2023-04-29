
public class Exercicio2 {
	public static void main(String[] args) {
		
		int r, i, valores, num, maior=-99999, menor=99999;
		
		do {
		valores = Console.readInt("Informe a quantidade de números que será digitada: ");
		
		for(i=0;i<valores;i++) {
			num = Console.readInt("Informe o número "+(i+1)+": ");
			if(num>maior) {
				maior=num;
			}
			if(num<menor) {
				menor=num;
			}
		}
		
		System.out.println("\nO maior valor é: "+maior);
		System.out.println("\nO menor valor é: "+menor);
		
		r = Console.readInt("\nSe quiser repetir o programa pressione 1 \nSe quiser finalizá-lo 2\n");
		}while(r==1);
		
		System.out.println("\nO programa foi finalizado!");
		
	}

}
