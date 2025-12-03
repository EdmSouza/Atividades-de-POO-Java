
public class RaizSequencial {
    private int num;


    public RaizSequencial(int num){
        this.num = num;
    }

    private void caucularRaizSeq(){
        int r = 0;
        while(true){
            if(r*r<num){
                r++;
            }else if(r*r>=num && r*r<num+1){
                raizInteira(r);
                break;
            }else{
                raizInteira(r-1);
                break;
            }
        }
    }

    public void raizInteira(int r){
        IO.println("A raíz inteira é: "+r);
    }


    public static void main(String[] args){
        int n = Integer.parseInt(IO.readln("Digite um número: "));
        RaizSequencial resposta = new RaizSequencial(n);
        resposta.caucularRaizSeq();
    }
}
