package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.petshop.model.Atendimento;
import com.petshop.model.Cliente;
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// READ
	public void readAllAtendimentos() {
		sql = "SELECT * FROM atendimento as a " + "INNER JOIN pet as p " + "ON a.idPet = p.idPet"
				+ "INNER JOIN Veterinario as v " + "ON a.idVeterinario = v.idVeterinario" + "INNER JOIN cliente as c "
				+ "ON p.idCliente = c.idCliente";

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
				pet.setIdPet(r.getInt("idPet"));
				pet.setNomePet(r.getString("nomePet"));
				pet.setPortePet(r.getString("portePet"));
				pet.setEspeciePet(r.getString("especiePet"));
				pet.setRacaPet(r.getString("racaPet"));
				pet.setIdadePet(r.getInt("idadePet"));
				Cliente clientePet = new Cliente();
				clientePet.setNomeCliente(r.getString("nomeCliente"));

				// Veterinario
				Veterinario veterinario = new Veterinario();
				veterinario.setIdVeterinario(r.getInt("idVeterinario"));
				veterinario.setNomeVeterinario(r.getString("nomeVeterinario"));
				veterinario.setCRMV(r.getString("CRMV"));
				veterinario.setEspecialidade(r.getString("especialidade"));
				veterinario.setHorariosDisponiveis(r.getTimestamp("horariosDisponiveis").toLocalDateTime());

				System.out.println("ID Atendimento: " + atendimento.getIdAtendimento() + "\nHorario Atendimento: "
						+ atendimento.getHorarioAtendimento() + "\nHorario Agendamento: "
						+ atendimento.getHorarioAgendamento() + "\nNome do Pet: " + pet.getNomePet()
						+ "\nNome do Cliente" + clientePet.getNomeCliente() + "\nNome do Veterinario: "
						+ veterinario.getNomeVeterinario());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// UPDATE
	public void updateAtendimento(Atendimento atendimento) {
		sql = "UPDATE Atendimento SET horarioAtendimento = ?,horarioAgendamento = ?,descricao = ?,idPet = ?,idVeterinario = ? WHERE idAtendimento = ?";
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
			stmt.setInt(6, atendimento.getIdAtendimento());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// DELETE
	public void deleteAtendimento(int id) {
		sql = "DELETE FROM atendimento WHERE idAtendimento = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
