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
		this.saldo = 0.0f;
	}
	
	
	public void registrarTransacao(Transacao t) {
		this.transacoes.add(t);
	}
	
	public void depositar(float valor) {
		this.saldo += valor;
		DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime dataAtual = LocalDateTime.now();
		this.registrarTransacao(new Transacao("Deposito", valor, formatacaoData.format(dataAtual).toString()));
	}
	
	public boolean sacar(float valor) {
		if(saldo - valor > 0) {
			this.saldo -= valor;
			DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
			LocalDateTime dataAtual = LocalDateTime.now();
			this.registrarTransacao(new Transacao("Deposito", valor, formatacaoData.format(dataAtual).toString()));
			return true;
		}else {
			return false;
		}
	
	}
	
	public ArrayList<Transacao> getExtrato(){
		return this.transacoes;
	}
	
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
