package banco.negocio.transacao;


public class Transacao {    
	private String operacao;
    private float valor;
    private String dataHora;

    public Transacao(String operacao, float valor, String dataHora){
        this.operacao = operacao;
        this.valor = valor;
        this.dataHora = dataHora;
    }
    
    public String getOperacao() {
		return operacao;
	}

	public float getValor() {
		return valor;
	}

	public String getDataHora() {
		return dataHora;
	}
}
