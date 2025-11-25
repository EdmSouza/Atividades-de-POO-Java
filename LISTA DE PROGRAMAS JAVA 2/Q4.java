public class Q4 {
    private int n1;
    private int n2;
    private int n3;

    public Q4(int num1, int num2, int num3){
        this.n1 = num1;
        this.n2 = num2;
        this.n3 = num3;
    } public double media(){
        double media = (n1+n2+n3)/3.0;
        return media;
    } public int distmedia(double media){
        double dist = Math.abs(n1-media);
        double dist2 = Math.abs(n2-media);
        double dist3 = Math.abs(n3-media);
        if(dist<= dist2 && dist <= dist3){
            return n1;
        } else if(dist2<= dist && dist2<= dist3){
            return n2;
        }else {
            return n3;
        }
    }
    public static void main(String[] args){
        int nu1 = Integer.parseInt(IO.readln("Digite um número __"));
        int nu2 = Integer.parseInt(IO.readln("Digite um outro número __"));
        int nu3 = Integer.parseInt(IO.readln("Digite um último número __"));
        Q4 analise = new Q4(nu1,nu2,nu3);
        double media = analise.media();
        IO.println("O número mais próximo a média é: "+analise.distmedia(media));
    }
}


