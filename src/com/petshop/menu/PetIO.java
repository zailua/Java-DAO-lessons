package com.petshop.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.petshop.dao.PetDAO;
import com.petshop.database.DatabaseConnection;
import com.petshop.model.Cliente;
import com.petshop.model.Pet;
import com.petshop.utils.Colors;

public class PetIO {

	static Connection connection = DatabaseConnection.createConnection();
	static PetDAO petDAO = new PetDAO(connection);

	public static int SubMenuPet(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU PET\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Pet pet = new Pet();
				Cliente clientePet = new Cliente();
				System.out.println("Digite o nome do Pet: ");
				pet.setNomePet(scanner.nextLine());
				System.out.println("Digite o nome do Porte: ");
				pet.setPortePet(scanner.next().toUpperCase().trim());
				System.out.println("Digite a Especia do Pet: ");
				pet.setEspeciePet(scanner.next().trim());
				System.out.println("Digite a Raca do Pet: ");
				pet.setRacaPet(scanner.next().trim());
				System.out.println("Digite a Idade do Pet");
				pet.setIdadePet(scanner.nextInt());
				System.out.println("Digite o ID do dono: ");
				clientePet.setIdCliente(scanner.nextInt());
				pet.setCliente(clientePet);

				petDAO.createPet(pet);

				break;
			case 2:
				petDAO.readAllPets();
				break;
			case 3:
				Pet petAtualizado = new Pet();
				Cliente clientePetAtualizado = new Cliente();
				System.out.println("Digite o ID do Pet a ser atualizado: ");
				petAtualizado.setIdPet(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Digite o nome do Pet: ");
				petAtualizado.setNomePet(scanner.nextLine());
				System.out.println("Digite o nome do Porte: ");
				petAtualizado.setPortePet(scanner.next().toUpperCase().trim());
				System.out.println("Digite a Especia do Pet: ");
				petAtualizado.setEspeciePet(scanner.next().trim());
				System.out.println("Digite a Raca do Pet: ");
				petAtualizado.setRacaPet(scanner.next().trim());
				System.out.println("Digite a Idade do Pet");
				petAtualizado.setIdadePet(scanner.nextInt());
				System.out.println("Digite o ID do dono: ");
				clientePetAtualizado.setIdCliente(scanner.nextInt());
				petAtualizado.setCliente(clientePetAtualizado);

				break;
			case 4:
				System.out.println("Digite o ID do Pet a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int idPet = scanner.nextInt();
				petDAO.deletePet(idPet);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
}
