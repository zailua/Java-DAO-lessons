package com.petshop.model;

import java.time.LocalDateTime;

public class Veterinario {

	private int idVeterinario;

	private String nomeVeterinario;

	private String CRMV;

	private String especialidade;

	private LocalDateTime horariosDisponiveis;

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}

	public String getCRMV() {
		return CRMV;
	}

	public void setCRMV(String cRMV) {
		CRMV = cRMV;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDateTime getHorariosDisponiveis() {
		return horariosDisponiveis;
	}

	public void setHorariosDisponiveis(LocalDateTime horariosDisponiveis) {
		this.horariosDisponiveis = horariosDisponiveis;
	}

}
