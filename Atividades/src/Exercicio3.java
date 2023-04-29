
public class Exercicio3 {
	public static void main(String[] args) {
		
		int num, soma=0;
		
		System.out.println("Informe números para serem somados e digite zero para visualizar o resultado");
		
		do {
			num = Console.readInt("Informe o número a ser somado: ");
			soma+=num;
		}while(num!=0);
		
		System.out.println("O resultado da soma é: "+soma);
	}

}
