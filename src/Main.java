import cliente.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        Cliente renato = new Cliente("Renato", "12345678901");
        Cliente raphael = new Cliente("Raphael", "34567892100");

        Conta contaCorrente = new ContaCorrente(renato);
        ContaPoupanca contaPoupanca = new ContaPoupanca(raphael);

        contaCorrente.depositar(100);
        contaCorrente.transferir(100, contaPoupanca);

        contaPoupanca.gerarJuros(0.50);

        contaCorrente.imprimirInformacoesComuns();
        System.out.println("-------------------");
        contaCorrente.imprimirExtrato();

        System.out.println("\n*******************\n");

        contaPoupanca.imprimirInformacoesComuns();
        System.out.println("-------------------");
        contaPoupanca.imprimirExtrato();
    }
}