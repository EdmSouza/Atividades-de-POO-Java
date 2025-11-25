public class Q3 {
    private int num1;
    private int num2;
    private int num3;

    public Q3(int num1,int num2,int num3){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    } public double media(){
        double m =(num1+num2+num3)/3.0;
        return m;
    } public int verifmaior(double m){
        int maiorqmedia = 0;
        if (num1>m){
            maiorqmedia +=1;
        }if (num2>m){
            maiorqmedia +=1;
        }if (num3>m){
            maiorqmedia +=1;
        }return maiorqmedia;
    }
    public static void main(String[] args){
        int n1 = Integer.parseInt(IO.readln("Digite um número __"));
        int n2 = Integer.parseInt(IO.readln("Digite um outro número __"));
        int n3 = Integer.parseInt(IO.readln("Digite um último número __"));
        Q3 analise = new Q3(n1,n2,n3);
        double m = analise.media();
        IO.println("A quantidade de números acima da média sao: " +analise.verifmaior(m));
    }
}
