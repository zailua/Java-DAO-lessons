package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.petshop.model.Atendimento;
import com.petshop.model.Pet;
import com.petshop.model.Veterinario;

public class AtendimentoDAO {

	private static String sql;

	private final Connection connection;

	public AtendimentoDAO(Connection connection) {

		this.connection = connection;

	}

	// CREATE
	public void createAtendimento(Atendimento atendimento) {
		sql = "INSERT INTO Atendimento (horarioAtendimento,horarioAgendamento,descricao,idPet,idVeterinario) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Lidando com Datas
			Timestamp sqlAtendimento = Timestamp.valueOf(atendimento.getHorarioAtendimento());
			Timestamp sqlAgendamento = Timestamp.valueOf(atendimento.getHorarioAgendamento());
			stmt.setTimestamp(1, sqlAtendimento);
			stmt.setTimestamp(2, sqlAgendamento);
			// Lidando com Datas

			stmt.setString(3, atendimento.getDescricao());
			stmt.setInt(4, atendimento.getPet().getIdPet());
			stmt.setInt(5, atendimento.getVeterinario().getIdVeterinario());

			stmt.executeUpdate();
			System.out.println("Agendamento criado com sucesso! ");
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}

	}

	// READ
	public void readAllAgendamentos() {
		sql = "SELECT * FROM Atendimento as a " + "INNER JOIN pet as p " + "ON a.idPet = p.idPet"
				+ "INNER JOIN veterinario as v" + "ON a.idVeterinario = v.idVeterinario";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Atendimento atendimento = new Atendimento();

				atendimento.setIdAtendimento(r.getInt("idAtendimento"));
				atendimento.setHorarioAtendimento(r.getTimestamp("horarioAtendimento").toLocalDateTime());
				atendimento.setHorarioAgendamento(r.getTimestamp("horarioAgendamento").toLocalDateTime());
				atendimento.setDescricao(r.getString("descricao"));

				// Pet
				Pet pet = new Pet();
				pet.setNomePet(r.getString("nomePet"));
				pet.setPortePet(r.getString("portePet"));
				pet.setEspeciePet(r.getString("especiePet"));
				pet.setRacaPet(r.getString("racaPet"));
				pet.setIdadePet(r.getInt("idadePet"));

				// Veterinario
				Veterinario veterinario = new Veterinario();
				;
				veterinario.setIdVeterinario(r.getInt("idVeterinario"));
				veterinario.setNomeVeterinario(r.getString("nomeVeterinario"));
				veterinario.setCrmv(r.getString("CRMV"));
				veterinario.setEspecialidade(r.getString("especialidade"));
				veterinario.setHorariosDisponiveis(r.getTimestamp("horariosDisponiveis").toLocalDateTime());

				System.out.println("ID Atendimento: " + atendimento.getIdAtendimento() + "\nHorario Atendimento: "
						+ atendimento.getHorarioAtendimento() + "\nHorario Agendamento: "
						+ atendimento.getHorarioAgendamento() + "\nDetalhes: " + atendimento.getDescricao()
						+ "Nome do Pet: " + pet.getNomePet() + "\nVeterinario: " + veterinario.getNomeVeterinario());

			}
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}

	//UPDATE
	public void updateAtendimento(Atendimento atendimento) {
		sql = "UPDATE atendimento SET horarioAtendimento = ?, horarioAgendamento = ?, descricao = ?, idPet = ?, idVeterinario = ? WHERE idPet = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Lidando com Datas
			Timestamp sqlAtendimento = Timestamp.valueOf(atendimento.getHorarioAtendimento());
			Timestamp sqlAgendamento = Timestamp.valueOf(atendimento.getHorarioAgendamento());
			stmt.setTimestamp(1, sqlAtendimento);
			stmt.setTimestamp(2, sqlAgendamento);
			// Lidando com Datas

			stmt.setString(3, atendimento.getDescricao());
			stmt.setInt(4, atendimento.getPet().getIdPet());
			stmt.setInt(5, atendimento.getVeterinario().getIdVeterinario());

			stmt.executeUpdate();
			System.out.println("Agendamento criado com sucesso! ");
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}

	}

}
