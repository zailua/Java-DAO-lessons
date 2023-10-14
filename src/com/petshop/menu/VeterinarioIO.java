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

	public static int MenuVeterinario(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("Menu veterinario\n" + "1 - Cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar\n" + "0 - Sair");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				Veterinario veterinario = new Veterinario();
				System.out.println("Digite o nome do Veterinario");
				veterinario.setNomeVeterinario(scanner.nextLine());
				System.out.println("Digite o CRMV do Veterinario");
				veterinario.setCrmv(scanner.next());
				scanner.nextLine();
				System.out.println("Digite a horario disponivel no formato dd/MM/yyyy HH:mm:ss");
				String dataEhora = scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				veterinario.setHorariosDisponiveis(LocalDateTime.parse(dataEhora, formatter));
				System.out.println("Digite a Especialidade");
				veterinario.setEspecialidade(scanner.next());

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
				System.out.println("Digite o nome do Veterinario");
				veterinarioAtualizado.setNomeVeterinario(scanner.nextLine());
				System.out.println("Digite o CRMV do Veterinario");
				veterinarioAtualizado.setCrmv(scanner.next());
				scanner.nextLine();
				System.out.println("Digite a horario disponivel no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraUP = scanner.nextLine();
				DateTimeFormatter formatterUP = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				veterinarioAtualizado.setHorariosDisponiveis(LocalDateTime.parse(dataEhoraUP, formatterUP));
				System.out.println("Digite a Especialidade");
				veterinarioAtualizado.setEspecialidade(scanner.next());

				veterinarioDAO.createVeterinario(veterinarioAtualizado);

				break;
			case 4:

				System.out.println(
						"Digite o ID do Veterinario que deseja " + Colors.RED.get() + "DELETAR" + Colors.RESET.get());
				int idVeterinario = scanner.nextInt();
				veterinarioDAO.deleteVeterinario(idVeterinario);
			default:
			}

		} while (option != 0);

		return option;
	}

}
