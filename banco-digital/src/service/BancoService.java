package service;

import model.ContaBancaria;

public class BancoService {

    // Realizar Deposito
    public void realizarDeposito(ContaBancaria conta, double valor) {
        conta.depositar(valor);
    }

    // Realizar Saque
    public boolean realizarSaque(ContaBancaria conta, double valor, String senha) {
        if (conta.getCliente().validarSenha(senha)) {
            return conta.sacar(valor);
        }
        return false;
    }

    // Realizar Transferencia
    public boolean realizarTransferencia(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor, String senha) {
        if (contaOrigem.getCliente().validarSenha(senha)) {
            return contaOrigem.transferir(valor, contaDestino);
        }
        return false;
    }

}
