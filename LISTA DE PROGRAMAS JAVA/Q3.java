import java.util.Scanner;

public class Q3 {
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite um número inteiro: ");
    var n1 = scanner.nextLine();
    int num1 = Integer.parseInt(n1);

    if (num1 < 0) {
        System.out.println("O número " + num1 + " é negativo.");
    } else if (num1 > 0) {
        System.out.println("O número +" + num1 + " é positivo.");
    } else {
        System.out.println("O número " + num1 + " é nulo");
    }
    scanner.close();
}
}
