public class LeibnizPi {

    public double calcularPi(int n) {
        double soma = 0.0;

        for (int i = 0; i < n; i++) {
            
            // Lógica do denominador: 1, 3, 5, 7, 9...
            // Fórmula para número ímpar: 2*i + 1
            double denominador = 2 * i + 1;
            
            // Lógica do termo (fração)
            double termo = 1.0 / denominador;

            // Lógica do Sinal: Alterna entre + e -
            if (i % 2 == 0) {
                soma = soma + termo; // Adiciona
            } else {
                soma = soma - termo; // Subtrai
            }
        }

        return soma * 4;
    }

    public static void main(String[] args) {
        LeibnizPi calc = new LeibnizPi();

        System.out.println("Com 10 termos:   " + calc.calcularPi(10));
        System.out.println("Com 100 termos:  " + calc.calcularPi(100));
        System.out.println("Com 1000 termos: " + calc.calcularPi(1000));
    }
}