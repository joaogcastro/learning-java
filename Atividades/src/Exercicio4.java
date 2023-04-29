
public class Exercicio4 {
	public static void main(String[] args) {
		
		int  r, nalunos=0, aprovados=0, reprovados=0, recuperacao=0;
		float n1, n2, n3, n4, maiormedia= -9999, menormedia=9999, mediaturma=0, media;
		
		do {
			nalunos ++;
			n1 = Console.readFloat("Informe a primeira nota: ");
			n2 = Console.readFloat("Informe a segunda nota: ");
			n3 = Console.readFloat("Informe a terceira nota: ");
			n4 = Console.readFloat("Informe a quarta nota: ");
			media = (n1+n2+n3+n4)/4;
			if(media>maiormedia) {
				maiormedia = media;
			}
			if(media<menormedia) {
				menormedia = media;
			}
			if(media>=6) {
				aprovados++;
			}
			if(media<6 && media>=4) {
				recuperacao++;
			}
			if(media<4) {
				reprovados++;
			}
			mediaturma+=media;
			
			r = Console.readInt("Deseja adicionar dados de mais um aluno?\nDigite 1 para Sim\nDigite 2 para Não\n");
		}while(r==1);
		
		System.out.println("RESULTADOS DA ANÁLISE:\nNúmero de alunos da análise: "+nalunos+"\nMaior média entre os alunos: "+maiormedia+"\nMenor média entre os alunos: "+menormedia+"\nNúmero de alunos aprovados: "+aprovados+" "+(aprovados/nalunos*100)+"%"+"\nNúmero de alunos reprovados: "+reprovados+" "+(reprovados/nalunos*100)+"%"+"\nNúmero de alunos em recuperação: "+recuperacao+" "+(recuperacao/nalunos*100)+"%"+"\nA média da turma foi de: "+mediaturma/nalunos);
		
	}

}
