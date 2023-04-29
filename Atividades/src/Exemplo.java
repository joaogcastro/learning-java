
public class Exemplo {
	public static void main(String[] args) { /*Para agilizar escreve só main e ctrl espaço ou cria o main direto no New Class */
		String nome = "João";
		int idade = 15;
		
		
		/*SAIDA DE DADOS*/
		System.out.println("O nome informado foi: " + nome + "\n"); /*sysou atalho*/
		System.out.println("A idade informada foi: " + idade);
		System.out.println();
		
		String aluno;
		int idadealuno;
		float b1, b2, b3, b4, media;
		
		/*ENTRADA DE DADOS*/
		/*O PROJETO PRECISA TER O Console.java para os comandos Console. funcionar*/
		aluno = Console.readString("Informe o nome do aluno: "); /*Console. (ja aparece automatico)*/
		idadealuno = Console.readInt("Informe a idade do aluno");
		b1 = Console.readFloat("Informe a nota do 1o bimestre: ");
		b2 = Console.readFloat("Informe a nota do 2o bimestre: ");
		b3 = Console.readFloat("Informe a nota do 3o bimestre: ");
		b4 = Console.readFloat("Informe a nota do 4o bimestre: ");
		
		media = (b1+b2+b3+b4)/4;
		System.out.println("Aluno: " + aluno);
		System.out.println("Idade: " + idadealuno);
		System.out.println("Média: " + media);
	}

}
