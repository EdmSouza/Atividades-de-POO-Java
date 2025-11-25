public class Q4 {
    public static void main(String[] args) {
        IO.println("O ingresso hoje no circo está por R$50,00, com desconto para todos e temos ainda promoçÕes especiais para jovens de até 18 anos e idosos a partir de 60 anos.");
        var idade =  IO.readln("Digite a sua idade: ");
        int idad = Integer.parseInt(idade);
        if (idad<=18){
            IO.println("Voce é um jovem de " +idad+ " anos, hoje voce tem direito a um desconto de 50% no valor do ingresso");
            double desc50 = 50 -(50 * 50/100);
            IO.println("Ao invés de R$50,00, voce irá pagar: R$"+desc50);
        } else if (idad>=60){
            IO.println("Voce é idoso de " +idad+ " anos, hoje voce tem direito a um desconto de 50% no valor do ingresso");
            double desc50 = 50-(50 * 50/100);
            IO.println("Ao invés de R$50,00, voce irá pagar: R$"+desc50);
        } else {
            IO.println("Voce é um adulto de " +idad+ " anos, hoje voce tem direito a um desconto de 10% no valor do ingresso");
            double desc10 = 50 -(50 * 10/100);
            IO.println("Ao invés de R$50,00, voce irá pagar: R$"+desc10);
        }
    }
}
