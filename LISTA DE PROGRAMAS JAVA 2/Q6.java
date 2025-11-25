public class Q6 {
    private int consumo;

    public Q6(int consumo) {
        this.consumo = consumo;
    }
    public double calculo() {
        double total = 0;
        if (consumo <= 99) {
            total = consumo * 1.35;
        } else if (consumo <= 299) {
            total = (99 * 1.35) + ((consumo - 99) * 1.55);
        } else if (consumo <= 574) {
            total = (99 * 1.35) + (200 * 1.55) + ((consumo - 299) * 1.75);
        } else {
            total = (99 * 1.35) + (200 * 1.55) + (275 * 1.75) + ((consumo - 574) * 2.15);
        }
        //aplica taxa de 10% se consumo > 300
        if (consumo > 300) {
            total *= 1.10;
        }
        if (total < 35) {
            total = 35;
        }return total;
    }
    public void resultado() {
        double totalf = calculo();
        IO.println("O total da conta de energia é: R$ " + String.format("%.2f", totalf));
    }
    public static void main(String[] args) {
        int consumo = Integer.parseInt(IO.readln("Digite o consumo de energia em kWh: ___"));
        Q6 conta = new Q6(consumo);
        conta.resultado();
    }
}
