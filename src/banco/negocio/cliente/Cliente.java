package banco.negocio.cliente;

import banco.negocio.conta.ContaCorrente;

public class Cliente {
    private String nome;
    private String rg;
    private String endereco;
    private ContaCorrente conta;

    public Cliente(String nome, String rg, String endereco){
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
    }

    public void setConta(ContaCorrente conta){
        this.conta = conta;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setRg(String rg){
        this.rg = rg;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getNome(){
        return this.nome;
    }

    public String getRg(){
        return this.rg;
    }

    public String getEndereco(){
        return this.endereco;
    }

}
