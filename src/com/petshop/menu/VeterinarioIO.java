package com.petshop.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.petshop.dao.VeterinarioDAO;
import com.petshop.database.DatabaseConnection;
import com.petshop.model.Veterinario;
import com.petshop.utils.Colors;

public class VeterinarioIO {

	static Connection connection = DatabaseConnection.createConnection();
	static VeterinarioDAO veterinarioDAO = new VeterinarioDAO(connection);

	public static int SubMenuVeterinario(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("MENU VETERINRIO\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Veterinario veterinario = new Veterinario();
				System.out.println("Nome Completo: ");
				veterinario.setNomeVeterinario(scanner.nextLine());
				System.out.println("CRMV: ");
				veterinario.setCRMV(scanner.nextLine().trim());
				System.out.println("Digite a especialidade");
				veterinario.setEspecialidade(scanner.next().trim());
				System.out.println("Digite o horario disponivel no formato dd/MM/yyyy HH:mm:ss");
				String dataEhora = scanner.nextLine();
				veterinario.setHorariosDisponiveis(LocalDateTime.parse(dataEhora, formatter));

				veterinarioDAO.createVeterinario(veterinario);
				break;
			case 2:
				veterinarioDAO.readAllVeterinarios();
				break;
			case 3:
				Veterinario veterinarioAtualizado = new Veterinario();
				System.out.println("Digite o ID do Veterinario a ser atualizado: ");
				veterinarioAtualizado.setIdVeterinario(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome Completo: ");
				veterinarioAtualizado.setNomeVeterinario(scanner.nextLine());
				System.out.println("CRMV: ");
				veterinarioAtualizado.setCRMV(scanner.next().trim());
				System.out.println("Digite a especialidade");
				veterinarioAtualizado.setEspecialidade(scanner.next().trim());
				System.out.println("Digite o horario disponivel no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAtualizado = scanner.nextLine();
				veterinarioAtualizado.setHorariosDisponiveis(LocalDateTime.parse(dataEhoraAtualizado, formatter));

				veterinarioDAO.updateVeterinario(veterinarioAtualizado);
				break;
			case 4:
				System.out.println(
						"Digite o ID do Veterinario a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int idVeterinario = scanner.nextInt();
				veterinarioDAO.deleteVeterinario(idVeterinario);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}

}
