
public class Ex6 {
	public static void main(String[] args) {
		
		float horas, vm;
		
		vm=Console.readFloat("Informe a velocidade média do veículo: ");
		horas=Console.readFloat("Informe quantas horas de viagem: ");
		
		System.out.println("Foram gastos "+((vm/horas)/12)+" litros de combustível na viagem");
	}

}
