package banco.negocio.transacao;


public class Transacao {
    public String operacao;
    public float valor;
    public String dataHora;

    public Transacao(String operacao, float valor, String dataHora){
        this.operacao = operacao;
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
