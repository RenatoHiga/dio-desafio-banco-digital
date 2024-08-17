package contas;

import cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    protected static final int AGENCIA_PADRAO = 0001;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> extrato;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
    }

    public void sacar(double valor) {
        saldo = saldo - valor;
        extrato.add("Saque de R$ " + String.format("%.2f", valor) + " foi realizado");
    }

    public void pagarBoleto(int codigo, double valor) {
        boolean codigoNaoInformado = String.valueOf(codigo).isEmpty();

        if (codigoNaoInformado) {
            System.out.println("Código do boleto não informado");
            return;
        }

        saldo = saldo - valor;
        extrato.add("Boleto no valor de R$ " + String.format("%.2f", valor) + " foi pago");
    }

    public void depositar(double valor) {
        saldo = saldo + valor;
        extrato.add("Deposito de R$ " + String.format("%.2f", valor) + " foi realizado");
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        extrato.add("Transferencia de R$ " + String.format("%.2f", valor) +
                " foi realizada para conta: " + contaDestino.getNumero() + " , de agencia "
                + contaDestino.getAgencia());
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirInformacoesComuns() {
        System.out.println("Suas informações");
        System.out.println(String.format("Agência %d ", agencia));
        System.out.println(String.format("Número %d ", numero));
        System.out.println(String.format("Saldo %.2f", saldo));
    }

    public void imprimirExtrato() {
        System.out.println("Extrato de movimentações:");
        extrato.forEach(movimentacao -> {
            System.out.println(movimentacao);;
        });
    }
}