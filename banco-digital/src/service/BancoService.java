package service;

import model.ContaBancaria;

public class BancoService {

    // Realizar Deposito
    public void realizarDeposito(ContaBancaria conta, double valor) {
        conta.depositar(valor);
    }

    // Realizar Saque
    public boolean realizarSaque(ContaBancaria conta, double valor) {
        return conta.sacar(valor);
    }

    // Realizar Transferencia
    public boolean realizarTransferencia(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor) {
        return contaOrigem.transferir(valor, contaDestino);
    }

}
