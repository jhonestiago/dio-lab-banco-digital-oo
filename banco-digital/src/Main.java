import model.Cliente;
import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import service.BancoService;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João Silva", "12345678900", "senha123");
        Cliente cliente2 = new Cliente("Maria Oliveira", "09876543211", "senha456");

        ContaBancaria contaCorrente = new ContaCorrente(cliente1);
        ContaBancaria contaPoupanca = new ContaPoupanca(cliente2);

        BancoService bancoService = new BancoService();

        bancoService.realizarDeposito(contaCorrente, 1000.0);
        bancoService.realizarDeposito(contaPoupanca, 500.0);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();

        boolean saqueRealizado = bancoService.realizarSaque(contaCorrente, 200.0, "senha123");
        if (saqueRealizado) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Falha no saque: senha incorreta.");
        }

        boolean transferenciaRealizada = bancoService.realizarTransferencia(contaCorrente, contaPoupanca, 200.0, "senha123");
        if (transferenciaRealizada) {
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Falha na transferência: senha incorreta.");
        }

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}