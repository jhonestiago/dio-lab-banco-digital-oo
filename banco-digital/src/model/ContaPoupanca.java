package model;

public class ContaPoupanca extends ContaBancaria {

    // Construtor
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    // Métodos
    @Override
    public void imprimirExtrato() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
