public class Q7{
    private double pesoPao;   // em kg
    private int litrosLeite;
    private int garrafasVinho;
    // Preços fixos
    private final double precoPao = 4.50;
    private final double precoLeite = 5.30;
    private final double precoVinho = 25.00;

    public Q7(double pesoPao, int litrosLeite, int garrafasVinho) {
        this.pesoPao = pesoPao;
        this.litrosLeite = litrosLeite;
        this.garrafasVinho = garrafasVinho;
    }

    //Calcula o valor total do pão (com desconto, se houver)
    public double valorPao() {
        double total = pesoPao * precoPao;
        if (pesoPao >= 1.0) {
            total *= 0.95; //desconto de 5%
        }
        return total;
    }//Retorna o valor do desconto do pão, se houver
    public double descontoPao() {
        if (pesoPao >= 1.0) {
            return pesoPao * precoPao * 0.05;
        } else {
            return 0;
        }
    }
    //Calcula o valor total do leite (com desconto no 3º litro)
    public double valorLeite() {
        double total = litrosLeite * precoLeite;
        int litrosComDesconto = litrosLeite / 3; // cada 3 litros, 1 tem 10porc off
        double desconto = litrosComDesconto * precoLeite * 0.10;
        return total - desconto;
    }public double descontoLeite() {
        int litrosComDesconto = litrosLeite / 3;
        return litrosComDesconto * precoLeite * 0.10;
    } 
    public double valorVinho() {
        int garrafasPagas = garrafasVinho - (garrafasVinho / 3);
        return garrafasPagas * precoVinho;
    }public double descontoVinho() {
        int garrafasGratis = garrafasVinho/3;
        return garrafasGratis * precoVinho;
    }
    public double valorTotal() {
        return valorPao() + valorLeite() + valorVinho();
    }
    public void exibirConta() {
        if (pesoPao > 0) {
            IO.println(String.format("Pão --------------------- R$ %.2f", valorPao()));
            if (descontoPao() > 0)
                IO.println(String.format("Desconto no pão --------- R$-%.2f", descontoPao()));
        }
        if (litrosLeite > 0) {
            IO.println(String.format("Leite ------------------- R$ %.2f", valorLeite()));
            if (descontoLeite() > 0)
                IO.println(String.format("Desconto no leite ------- R$-%.2f", descontoLeite()));
        }
        if (garrafasVinho > 0) {
            IO.println(String.format("Vinho ------------------- R$ %.2f", valorVinho()));
            if (descontoVinho() > 0)
                IO.println(String.format("Desconto no vinho ------- R$-%.2f", descontoVinho()));
        }
        IO.println(String.format("Valor Total ------------- R$ %.2f", valorTotal()));
    }
    public static void main(String[] args) {
        double pesoPao = Double.parseDouble(IO.readln("Digite o peso de pão (kg): "));
        int litrosLeite = Integer.parseInt(IO.readln("Digite a quantidade de litros de leite: "));
        int garrafasVinho = Integer.parseInt(IO.readln("Digite a quantidade de garrafas de vinho: "));
        Q7 compra = new Q7(pesoPao, litrosLeite, garrafasVinho);
        IO.println("\n========== CONTA DA COMPRA ==========");
        compra.exibirConta();
    }
}

