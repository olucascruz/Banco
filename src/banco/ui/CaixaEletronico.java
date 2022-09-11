// a) (1,0 ponto) Faça as declarações iniciais da classe: package, import, class, e método main().
package banco.ui;

import java.util.ArrayList;

import banco.negocio.cliente.Cliente;
import banco.negocio.conta.ContaCorrente;
import banco.negocio.transacao.Transacao;

public class CaixaEletronico {
    public static void main(String[] args){

        // b) (0,25 ponto) Instancie um cliente, defina o seu estado e instancie uma conta corrente.

        // Criando um cliente
        Cliente cliente = new Cliente(
            "Marcos Paulo",
            "26489157",
            "Rua Azul nº 132 - Zona Leste"
        );

        // Criando uma conta corrente
        ContaCorrente conta = new ContaCorrente(
            cliente, // Uma conta possuí um clinete agregado a ela
            1001,
            254
        );

        // Cliente faz parte de uma conta
        cliente.setConta(conta);

        // c) (0,25 ponto) Deposite um valor na conta.
        conta.depositar(130.5f);

        // d) (0,25 ponto) Saque da conta uma fração do valor que você depositou no item anterior.
        conta.sacar(35.25f);

        // e) (0,25 ponto) Mostre o número da conta, a agência e o saldo.
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Número da agência: " + conta.getNumeroAgencia());
        System.out.println((String.format("Saldo da conta: R$%.02f", conta.getSaldo())));

        // f) (1,0 ponto) Mostre o extrato da conta-corrente do cliente. Você precisará utilizar pelo menos um
        // ArrayList e um loop for para isto.
        ArrayList<Transacao> transacoes = conta.getExtrato();

        System.out.println("\n---------------Extrato Bancário---------------");
        
        for(Transacao t: transacoes){
            System.out.println(t.operacao + " - " +
            (String.format("R$%.02f", t.valor)) + " - " +
            t.dataHora);
        }
    }
}
