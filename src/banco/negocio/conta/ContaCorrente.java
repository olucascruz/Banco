package banco.negocio.conta;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter; 
import java.time.LocalDateTime;
import banco.negocio.cliente.Cliente;
import banco.negocio.transacao.Transacao;

public class ContaCorrente {
	private float saldo;
	private int numeroConta;
	private int numeroAgencia;
	private ArrayList<Transacao> transacoes;
	private Cliente cliente;
	
	public ContaCorrente(Cliente _cliente, int _numeroConta, int _numeroAgencia) {
		this.cliente = _cliente;
		this.numeroConta = _numeroConta;
		this.numeroAgencia = _numeroAgencia;
		this.saldo = 0.0f;	// b) saldo é inicializado com 0.0f.

		transacoes = new ArrayList<Transacao>();
	}
	
	
	// c) O método registrarTransacao() recebe como parâmetro um objeto da classe Transacao e adiciona 
	// este objeto na lista de transacoes da classe conta corrente.
	public void registrarTransacao(Transacao t) {
		this.transacoes.add(t);
	}
	
	// d) (1,0 ponto) O método depositar() recebe como parâmetro um valor float v e adiciona este valor ao
	// saldo da conta corrente.
	public void depositar(float valor) {
		//Adiciona o valor do deposito ao valor do saldo saldo
		this.saldo += valor;
		// Variavel usada para definir a formatação da data
		DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		//Variavel é definida com a data do deposito
		LocalDateTime dataAtual = LocalDateTime.now();
		
		// c) (1,0 ponto) Uma transação é registrada toda vez que ocorre um depósito  na conta.
		this.registrarTransacao(new Transacao("Deposito", valor, formatacaoData.format(dataAtual).toString())); 
																												
	}
	
	//e) (1,0 ponto) O método sacar() recebe como parâmetro um valor float v e subtrai este valor do saldo
	//da conta corrente.
	public boolean sacar(float valor) {
		//Verifica se o com o saque o valor ficaria negativo
		if(saldo - valor > 0) {
			//Se com a subtração o valor não ficar negativo a subtração é feita e retorna true
			this.saldo -= valor;
			// Variavel usada para definir a formatação da data
			DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			//Variavel é definida com a data do deposito
			LocalDateTime dataAtual = LocalDateTime.now();
			// c) (1,0 ponto) Uma transação é registrada toda vez que ocorre um saque na conta.
			this.registrarTransacao(new Transacao("Saque", valor, formatacaoData.format(dataAtual).toString()));
			return true;
		}else {
			//Se com a subtração o valor ficar negativo a subtração não é feita e retorna false
			return false;
		}
	
	}
	
	public ArrayList<Transacao> getExtrato(){
		//f) (1,0 ponto) O método getExtrato() retorna o “atributo” transacoes.
		return this.transacoes;
	}
	
	//g) (0,75 ponto) Implemente os métodos get para os atributos saldo, numeroConta e numeroAgencia.
	
	public float getSaldo() {
		return saldo;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public int getNumeroAgencia() {
		return numeroAgencia;
	}
	
	
}
