public class BuscaSequencial {
    private int num;
    private int cont;


    public BuscaSequencial(int num){
        this.num = num;
        this.cont = 0;
    }

    public void calcularraiz(){
        if(num>=0){
            while(true){
                if(cont*cont<num){
                    cont++;
                }else if(cont*cont>=num && cont*cont<num+1){
                    resultado(cont);
                    break;
                }else{
                    resultado(cont-1);
                    break;
                }
            }
        }
    }

    public void resultado(int cont){
        IO.println("A raíz inteira de "+this.num+" é: "+cont);
    }

    
    public static void main(String[] args){
        int numero = Integer.parseInt(IO.readln(""));
        BuscaSequencial resposta = new BuscaSequencial(numero);
        resposta.calcularraiz();
    }
}
