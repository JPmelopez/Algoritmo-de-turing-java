package turingmachine;
import java.util.Scanner;
public class TuringMachine {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = input.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = input.nextInt();
        String binary1 = Integer.toBinaryString(num1);
        System.out.println("Número 1 en binario: " + binary1);
        char[] tape = new char[binary1.length() + 1 + Integer.toBinaryString(num2).length()];
        for (int i = 0; i < binary1.length(); i++) {
            tape[i] = binary1.charAt(i);
        }
        tape[binary1.length()] = '0';
        int head = binary1.length() + 1;
        while (num2 != 0) {
            tape[head] = '1';
            head++;
            num2--;
            if (num2 == 0) {
                break;
            }
            while (tape[head] != '0') {
                head++;
            }
            tape[head] = '1';
            head++;
            num1++;
            String binary = Integer.toBinaryString(num1);
            for (int i = 0; i < binary.length(); i++) {
                tape[head] = binary.charAt(i);
                head++;
            }
            while (tape[head] != '0') {
                head++;
            }
        }
        String binaryResult = String.valueOf(tape).trim();
        int result = Integer.parseInt(binaryResult, 2);
        System.out.println("El resultado de la suma es: " + result);
    }
    
}
