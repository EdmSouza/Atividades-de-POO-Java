public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    class Conta extends Cliente implements Deposito {
        private double saldo;

        public Conta(String nome, String cpf, String email, double saldo) {
            super(nome, cpf, email);
            this.saldo = saldo;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
    }
    
}
