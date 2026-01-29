package 2 UNI;

public abstract class Figuras2d {
    private int qntlados;
    private String cor;
    private boolean eh2d = true;

    public Figuras2d(String cor, int qntlados){
        this.cor = cor;
        this.qntlados = qntlados;
    }

    public void eh.retangular(double base, double comprimento){
        double resultado1 = base*comprimento;
        IO.println(resultado1);
    }

    public void eh.triangular(double base, double comprimento){
        double resultado2 = base*comprimento/2;
        IO.println(resultado2);
    }

    public void eh.circular(double raio){
        double resultado3 = 2*3.14*raio*raio;
        IO.println(resultado3);
    }

    public void tipodefigura(){
        if(eh2d){
            if(qntlados == 4){
                eh.retangular();
            }else if(qntlados == 3){
                eh.triangular();
            }else if(qntlados == 0){
                eh.circular();
        }
        }
    }

    public abstract class Figuras3d extends Figuras2d{
        private double profundidade;
        boolean eh2d = false;


        public void tipodefigura(int qntlados){
            if
        }
    }
}
