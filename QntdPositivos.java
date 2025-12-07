public class QntdPositivos {
    private int num;
    private int cont;

    public QntdPositivos(){
    }

    public void contarpositivos(){
        this.num = Integer.parseInt(IO.readln(""));
        if(num>0){
            this.cont++;
        }
        while(num != 0){
            this.num = Integer.parseInt(IO.readln(""));
            if(num>0){
            this.cont++;
        }
        }resultado();
    }

    public void resultado(){
        IO.println("A quantidade de inteiros positivos é: "+this.cont);
    }


    public static void main(String[] args){
        QntdPositivos calculo = new QntdPositivos();
        calculo.contarpositivos();
    }
}
