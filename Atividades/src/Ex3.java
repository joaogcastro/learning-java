
public class Ex3 {
	public static void main(String[] args) {
		
		float A, B;
		char op;
		
		do {
			A =Console.readFloat("Informe o numero A: ");
			B =Console.readFloat("Informe o numero B: ");
			op =Console.readChar("Informe a operação:\n+ para soma\n- para subtração\n/ para divisão\n* para multiplicação\n");
		
			switch(op) {
			case('+'):
				System.out.println("Resultado soma: "+(A+B));
				break;
			case('-'):
				System.out.println("Resultado da subtração: "+(A-B));
				break;
			case('*'):
				System.out.println("Resultado da multiplicacao: "+(A*B));
				break;
			case('/'):
				System.out.println("Resultado da divisão: "+(A/B));
				break;
			default:
				System.out.println("A operação inserida é inválida\n");
				break;
			}
		}while(op!='+' || op!='-' || op!='*' || op!='/');
		
	}

}
