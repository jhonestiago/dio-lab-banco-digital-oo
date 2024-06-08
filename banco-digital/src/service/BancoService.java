package service;

import model.ContaBancaria;

public class BancoService {

    // Realizar Depósito
    public void realizarDeposito(ContaBancaria conta, double valor) {
        if (valor > 0) {
            conta.depositar(valor);
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta " + conta.getNumero());
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    // Realizar Saque
    public void realizarSaque(ContaBancaria conta, double valor, String senha) {
        if (conta.getCliente().validarSenha(senha)) {
            if (valor > 0) {
                boolean sucesso = conta.sacar(valor);
                if (sucesso) {
                    System.out.println("Saque de " + valor + " realizado com sucesso na conta " + conta.getNumero());
                } else {
                    System.out.println("Saldo insuficiente para saque.");
                }
            } else {
                System.out.println("Valor de saque deve ser positivo.");
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    // Realizar Transferência
    public void realizarTransferencia(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor, String senha) {
        if (contaOrigem.getCliente().validarSenha(senha)) {
            if (valor > 0) {
                boolean sucesso = contaOrigem.transferir(valor, contaDestino);
                if (sucesso) {
                    System.out.println("Transferência de " + valor + " realizada com sucesso da conta " + contaOrigem.getNumero() + " para a conta " + contaDestino.getNumero());
                } else {
                    System.out.println("Saldo insuficiente para transferência.");
                }
            } else {
                System.out.println("Valor de transferência deve ser positivo.");
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }
    
    // Imprimir Extrato
    public void imprimirExtrato(ContaBancaria conta) {
        conta.imprimirExtrato();
    }
}
