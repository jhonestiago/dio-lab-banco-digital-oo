package model;

public abstract class ContaBancaria {

    // Atributos
    private static int sequencial = 1;
    final private String AGENCIA_PADRAO = "001";

    protected String agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    // Construtor
    public ContaBancaria(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    // Métodos

    // Depositar
    public void depositar(double valor) {
        this.saldo += valor;
    }

    // Sacar
    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    // Transferir
    public boolean transferir(double valor, ContaBancaria contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    // Imprimir Extrato
    public abstract void imprimirExtrato();

    // Getters
    
    public String getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
