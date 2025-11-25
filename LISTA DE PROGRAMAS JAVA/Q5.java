public class Q5 {
    public static void main(String[] args) throws Exception {
        var unidIntern = IO.readln("Voce deseja converter a temperatura para qual unidade? Digite 'C' para Celsius ou 'F' para Fahrenheit _");
        if (unidIntern.equalsIgnoreCase("C")){
            celsius();
        } else if(unidIntern.equalsIgnoreCase("F")){
            fahrenheit();
        } else {
            IO.println("INVÁLIDO, digite 'C' para Celsius  ou 'F' para Fahrenheit");
        }
    }
    public static void fahrenheit(){
        var temperatura = IO.readln("Digite uma temperatura em Celsius: ");
        int t = Integer.parseInt(temperatura);
        double temp = (t* 1.8) +32;
        IO.println("Sua temperatura: " +t+ " graus Celsius, fica: " +temp+ " graus Fahrenheit");
    }
    public static void celsius(){
        var temperatura = IO.readln("Digite uma temperatura em Fahrenheit: ");
        int t = Integer.parseInt(temperatura);
        double temp = ((t- 32)*5)/9;
        IO.println("Sua temperatura: " +t+ " graus Fahrenheit, fica: " +temp+ " graus Celsius");
    }
}
