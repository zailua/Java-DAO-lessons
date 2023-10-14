package com.petshop.dao;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petshop.model.Veterinario;
import com.petshop.utils.Colors;

public class VeterinarioDAO {

	private static String sql;

	private final Connection connection;

	public VeterinarioDAO(Connection connection) {

		this.connection = connection;

	}

	// CREATE
	public void createVeterinario(Veterinario veterinario) {
		sql = "INSERT INTO veterinario (nomeVeterinario,CRMV,especialidade,horariosDisponiveis) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, veterinario.getNomeVeterinario());
			stmt.setString(2, veterinario.getCrmv());
			stmt.setString(3, veterinario.getEspecialidade());

			// Lidando com Data
			Timestamp sqlHorario = Timestamp.valueOf(veterinario.getHorariosDisponiveis());
			stmt.setTimestamp(4, sqlHorario);

			stmt.executeUpdate();
			System.out.println("Cliente criado com sucesso! " + veterinario.toString());
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}

	}

	// READ
	public void readAllVeterinarios() {
		sql = "SELECT * FROM veterinario";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Veterinario veterinario = new Veterinario();
				veterinario.setIdVeterinario(r.getInt("idVeterinario"));
				veterinario.setNomeVeterinario(r.getString("nomeVeterinario"));
				veterinario.setCrmv(r.getString("CRMV"));
				veterinario.setEspecialidade(r.getString("especialidade"));

				veterinario.setHorariosDisponiveis(r.getTimestamp("horariosDisponiveis").toLocalDateTime());

				System.out.printf("ID: %d\n Nome: %s\n CRMV: %s\n Horario Disponivel: %s\n",
						veterinario.getIdVeterinario(), veterinario.getNomeVeterinario(), veterinario.getCrmv(),
						veterinario.getHorariosDisponiveis());

			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}

	}

	// UPDATE
	public void updateVeterinario(Veterinario veterinario) {

		sql = "UPDATE veterinario SET nomeVeterinario = ?, CRMV = ?, especialidade = ?, horariosDisponiveis = ? WHERE idVeterinario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, veterinario.getNomeVeterinario());
			stmt.setString(2, veterinario.getCrmv());
			stmt.setString(3, veterinario.getEspecialidade());

			// Lidando com Data
			Timestamp sqlHorario = Timestamp.valueOf(veterinario.getHorariosDisponiveis());
			stmt.setTimestamp(4, sqlHorario);
			stmt.setInt(5, veterinario.getIdVeterinario());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}
	
	
	
	// DELETE
	public void deleteVeterinario(int id) {
		sql = "DELETE FROM veterinario WHERE idVeterinario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}

}
