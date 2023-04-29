
public class Ex1 {
	public static void main(String[] args) {
		
		int num1, num2, num3;
		
		num1 = Console.readInt("Numero1: ");
		num2 = Console.readInt("Numero2: ");
		num3 = Console.readInt("Numero3: ");
		
		if(num1>=num2 && num1>=num3) {
			if(num2>=num3) {
				System.out.println(num3+" "+num2+" "+num1);
			}else {
				System.out.println(num2+" "+num3+" "+num1);
			}
		}
		
		if(num2>=num1 && num2>=num3) {
			if(num1>=num3) {
				System.out.println(num3+" "+num1+" "+num2);
			}else {
				System.out.println(num1+" "+num3+" "+num2);
			}
		}
		
		if(num3>=num1 && num3>=num2) {
			if(num1>=num2) {
				System.out.println(num2+" "+num1+" "+num3);
			}else {
				System.out.println(num1+" "+num2+" "+num3);
			}
		}
	}

}
