package contas;

import cliente.Cliente;

public class ContaCorrente extends Conta {
    private static int SEQUENCIAL = 1;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.agencia = Conta.AGENCIA_PADRAO;
        super.numero = SEQUENCIAL++;
    }

}
