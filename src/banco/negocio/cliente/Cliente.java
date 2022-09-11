package banco.negocio.cliente;

import banco.negocio.conta.ContaCorrente;

public class Cliente {
    public String nome;
    public String rg;
    public String endereco;
    private ContaCorrente conta;

    public Cliente(String nome, String rg, String endereco){
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
    }

    public void setContaCorrent(ContaCorrente conta){
        this.conta = conta;
    }

    public void setConta(ContaCorrente conta){
        this.conta = conta;
    }

}
