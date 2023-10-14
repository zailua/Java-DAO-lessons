package com.petshop.model;

import java.time.LocalDateTime;



public class Veterinario {

	private int idVeterinario;

	private String nomeVeterinario;

	private String crmv;

	private String especialidade;

	private LocalDateTime horariosDisponiveis;
	
	

	public Veterinario() {
		super();
		
	}

	public Veterinario(String nomeVeterinario, String crmv, String especialidade, LocalDateTime horariosDisponiveis) {
		super();
		this.nomeVeterinario = nomeVeterinario;
		this.crmv = crmv;
		this.especialidade = especialidade;
		this.horariosDisponiveis = horariosDisponiveis;
	}

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

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
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
