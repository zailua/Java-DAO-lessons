package com.petshop.model;

import java.time.LocalDateTime;

public class Atendimento {

	private int idAtendimento;

	private LocalDateTime horarioAtendimento;

	private LocalDateTime horarioAgendamento;

	private String descricao;

	private Pet pet;

	private Veterinario veterinario;

	public int getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public LocalDateTime getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(LocalDateTime horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	public LocalDateTime getHorarioAgendamento() {
		return horarioAgendamento;
	}

	public void setHorarioAgendamento(LocalDateTime horarioAgendamento) {
		this.horarioAgendamento = horarioAgendamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

}
