package com.petshop.model;

public class Pet {

	private int idPet;

	private String nomePet;

	public enum PortePet {
		PEQUENO, MEDIO, GRANDE
	}

	private PortePet portePet;

	private String especiePet;

	private String racaPet;

	private int idadePet;

	private Cliente cliente;

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public String getPortePet() {
		return portePet.name();
	}

	public void setPortePet(String portePet) {
		if ("PEQUENO".equalsIgnoreCase(portePet)) {
			this.portePet = PortePet.PEQUENO;
		} else if ("MEDIO".equalsIgnoreCase(portePet)) {
			this.portePet = PortePet.MEDIO;
		} else if ("GRANDE".equalsIgnoreCase(portePet)) {
			this.portePet = PortePet.GRANDE;
		} else {
			System.out.println("Valor invalido: " + portePet);
		}
	}

	public String getEspeciePet() {
		return especiePet;
	}

	public void setEspeciePet(String especiePet) {
		this.especiePet = especiePet;
	}

	public String getRacaPet() {
		return racaPet;
	}

	public void setRacaPet(String racaPet) {
		this.racaPet = racaPet;
	}

	public int getIdadePet() {
		return idadePet;
	}

	public void setIdadePet(int idadePet) {
		this.idadePet = idadePet;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pet [idPet=" + idPet + ", nomePet=" + nomePet + ", portePet=" + portePet + ", especiePet=" + especiePet
				+ ", racaPet=" + racaPet + ", idadePet=" + idadePet + ", cliente=" + cliente + "]";
	}

}
