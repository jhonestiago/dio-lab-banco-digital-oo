import model.Cliente;
import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import service.BancoService;

public class Main {

    public static void main(String[] args) {
        // Criação de clientes
        Cliente cliente1 = new Cliente("João Silva", "12345678900", "1234");
        Cliente cliente2 = new Cliente("Maria Oliveira", "09876543211", "5678");

        // Criação de contas bancárias
        ContaBancaria contaCorrente = new ContaCorrente(cliente1);
        ContaBancaria contaPoupanca = new ContaPoupanca(cliente2);

        // Criação do serviço bancário
        BancoService bancoService = new BancoService();

        // Realização de depósitos
        bancoService.realizarDeposito(contaCorrente, 1000.0);
        bancoService.realizarDeposito(contaPoupanca, 500.0);

        // Impressão dos extratos
        bancoService.imprimirExtrato(contaCorrente);
        bancoService.imprimirExtrato(contaPoupanca);

        // Realização de saques
        bancoService.realizarSaque(contaCorrente, 200.0, "1234");

        // Realização de transferências
        bancoService.realizarTransferencia(contaCorrente, contaPoupanca, 200.0, "1234");

        // Impressão dos extratos após operações
        bancoService.imprimirExtrato(contaCorrente);
        bancoService.imprimirExtrato(contaPoupanca);
    }
}
