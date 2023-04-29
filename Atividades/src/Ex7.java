
public class Ex7 {
	public static void main(String[] args) {
		
		int i, erro, nota, notas[] = new int[5];
		
		for(i=0;i<5;i++) {
			
			do {
				erro= 0;
				nota = Console.readInt("Informe a nota "+(i+1)+":");
			
				if(nota>=0 && nota<=10) {
					System.out.println("Nota cadastrada!");
					notas[i]=nota;
				}else {
					System.out.println("Erro, a nota não está entre 0 e 10!");
					erro=1;
				}
			}while(erro==1);
		}
		
		
	}

}
