
public class Exemplo {	
	public static void main(String[] args) {
		
		int opcao, valor, valor1;
		char operador;
		
		do {
			desenharMenu();
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao) {
			case 1:
				valor = Console.readInt("\nInforme o valor: ");
				System.out.println("O valor é "+Metodos.verificarValor(valor));
				break;
				
			case 2:
				valor=Console.readInt("Informe o valor: ");
				System.out.println("Resposta: "+Metodos.calcularQuadrado(valor));
				break;
				
			case 3:
				valor = Console.readInt("Informe o primeiro valor: ");
				operador = Console.readChar("Operação (+, -, *, /): ");
				valor1 = Console.readInt("Informe o segundo valor: ");
				System.out.println("Resultado: "+Metodos.calcular(valor, operador, valor1));
				break;
			}
			
		}while(opcao!=4);
		
		System.out.println("O programa foi finalizado!");	
	}
	
	/*MODULARIZAÇÃO SEM REUTILIZAÇÃO, pois este menu é específico pra isso*/
	private static void desenharMenu() {
		System.out.println("\n\n1 - Verificar valor");
		System.out.println("2 - Calcular quadrado");
		System.out.println("3 - Calculadora");
		System.out.println("4 - Sair");
	}
}