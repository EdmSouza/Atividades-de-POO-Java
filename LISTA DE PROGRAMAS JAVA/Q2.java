import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número ");
        var num1 = scanner.nextLine();
        double n1 = Double.parseDouble(num1);

        System.out.println("Digite um segundo número ");
        var num2 = scanner.nextLine();
        double n2 = Double.parseDouble(num2);

        System.out.println("Digite um terceiro número ");
        var num3 = scanner.nextLine();
        double n3 = Double.parseDouble(num3);

        double media = (n1+n2+n3)/3;
        System.out.printf("A média dos tres números é: %.0f\n ",media);

        scanner.close();
        }
    }
