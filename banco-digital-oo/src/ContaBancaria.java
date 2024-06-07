public class ContaBancaria {

    protected String agencia;
    protected String conta;
    protected double saldo;

    public ContaBancaria(String agencia, String conta, double saldo) {
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    protected void sacar(double valor) {
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso");
        }
    }

    protected void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito realizado com sucesso");
    }

    protected void transferir(ContaBancaria contaDestino, double valor) {
        // Implementar
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

}