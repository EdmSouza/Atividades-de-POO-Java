public class Q2 {
    private int kmrodad;
    private int ndias;
    
    public Q2(int ndias, int kmrodad){
        this.ndias = ndias;
        this.kmrodad = kmrodad;

    }public double calculo(){
        double total = 0;
        int kmInclusos = 100*ndias;
        if(kmrodad > kmInclusos){
            total = ((kmrodad-kmInclusos)*12)+(90*ndias);
            return total;
        }else{
            total = 90*ndias;
            return total;
        }
    }public void resultado(){
        double totalf = calculo();
        System.out.printf("O valor total a ser pago é de: R$ %.2f\n", totalf);
    }public static void main(String[] args){
        IO.println("*****Promoção especial hoje, 90 reais a diária e bonus de 100 km de cota.*****");
        String dias = IO.readln("Digite a quantidade de dias com o veículo: ___");
        int ndias = Integer.parseInt(dias);
        String kms = IO.readln("Digite a quantidade de kms rodados com o veículo: ___");
        int nkms = Integer.parseInt(kms);
        Q2 alocar = new Q2(ndias,nkms);
        alocar.resultado();
    }
}
