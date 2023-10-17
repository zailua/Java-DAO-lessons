package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petshop.model.Cliente;
import com.petshop.model.Pet;
import com.petshop.utils.Colors;

public class PetDAO {

	private static String sql;

	private final Connection connection;

	public PetDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createPet(Pet pet) {
		sql = "INSERT INTO Pet (nomePet, portePet, especiePet, racaPet, idadePet, idCliente) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, pet.getNomePet());
			stmt.setString(2, pet.getPortePet());
			stmt.setString(3, pet.getEspeciePet());
			stmt.setString(4, pet.getRacaPet());
			stmt.setInt(5, pet.getIdadePet());
			stmt.setInt(6, pet.getCliente().getIdCliente());

			stmt.executeUpdate();
			System.out.println("Pet criado com sucesso!" + pet.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// READ
	public void readAllPets() {
		sql = "SELECT * FROM pet as p " + "INNER JOIN cliente as c " + "ON p.idCliente = c.idCliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				// Pet
				Pet pet = new Pet();
				pet.setIdPet(r.getInt("idPet"));
				pet.setNomePet(r.getString("nomePet"));
				pet.setPortePet(r.getString("portePet"));
				pet.setEspeciePet(r.getString("especiePet"));
				pet.setRacaPet(r.getString("racaPet"));
				pet.setIdadePet(r.getInt("idadePet"));

				// Cliente do Pet
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefone(r.getString("telefone"));

				System.out.println("ID do Pet: " + pet.getIdPet() + "\nNome do Pet: "+ pet.getNomePet() + "\nID do Cliente: "
						+ cliente.getIdCliente() + "\nNome Cliente: " + cliente.getNomeCliente());

			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updatePet(Pet pet) {
		sql = "UPDATE pet SET nomePet = ?, portePet = ?, especiePet = ?, racaPet = ?, idadePet = ?, idCliente = ? WHERE idPet = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, pet.getNomePet());
			stmt.setString(2, pet.getPortePet());
			stmt.setString(3, pet.getEspeciePet());
			stmt.setString(4, pet.getRacaPet());
			stmt.setInt(5, pet.getIdadePet());
			stmt.setInt(6, pet.getCliente().getIdCliente());
			stmt.setInt(7, pet.getIdPet());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Pet atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ pet.getNomePet() + "\nPorte do Pet: " + pet.getPortePet());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o Pet." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deletePet(int id) {
		sql = "DELETE FROM pet WHERE idPet = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
