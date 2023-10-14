package com.petshop.model;

public class Cliente {

	private int idCliente;

	private String nomeCliente;

	private String cpfCliente;

	private String enderecoCliente;

	private String telefone;
	
	
	
	
	
	

	public Cliente() {
		super();
	}

	public Cliente(String nomeCliente, String cpfCliente, String endereco, String telefone) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.enderecoCliente = endereco;
		this.telefone = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String endereco) {
		this.enderecoCliente = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
				+ ", enderecoCliente=" + enderecoCliente + ", telefone=" + telefone + "]";
	}

}
