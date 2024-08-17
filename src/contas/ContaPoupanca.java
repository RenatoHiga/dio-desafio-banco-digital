package contas;

import cliente.Cliente;

public class ContaPoupanca extends Conta {
    private static int SEQUENCIAL = 2;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.agencia = Conta.AGENCIA_PADRAO;
        super.numero = SEQUENCIAL++;
    }

    public void gerarJuros(double valorJuros) {
        saldo = saldo + valorJuros;
        extrato.add("Sua conta gerou R$ " + String.format("%.2f", valorJuros) + " de juros");
    }
}
