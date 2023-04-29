
public class Exercicio {
	public static void main(String[] args) {
		
		int num, i, r;
		
		do {
		for(i=0;i<10;i++) {
			num = Console.readInt("Informe um numero: ");
			if(num%2==0) {
				System.out.println(num+" é Par !\n");
			}else {
				System.out.println(num+" é Ímpar!\n");
			}
		}
			r = Console.readInt("Se quiser repetir o programa pressione 1 \nSe quiser finalizá-lo 2\n");
		}while(r==1);
		
		System.out.println("\nO programa foi finalizado!");
	}

}
