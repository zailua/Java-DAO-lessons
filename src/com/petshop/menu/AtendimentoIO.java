package com.petshop.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.petshop.dao.AtendimentoDAO;
import com.petshop.database.DatabaseConnection;
import com.petshop.model.Atendimento;
import com.petshop.model.Pet;
import com.petshop.model.Veterinario;
import com.petshop.utils.Colors;

public class AtendimentoIO {
	static Connection connection = DatabaseConnection.createConnection();
	static AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connection);

	public static int SubMenuAtendimento(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("MENU ATENDIMENTO\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Atendimento atendimento = new Atendimento();
				System.out.println("Digite o horario do atendimento no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAtendimento = scanner.nextLine();
				atendimento.setHorarioAtendimento(LocalDateTime.parse(dataEhoraAtendimento, formatter));
				System.out.println("Digite o horario do agendamento no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAgendamento = scanner.nextLine();
				atendimento.setHorarioAgendamento(LocalDateTime.parse(dataEhoraAgendamento, formatter));
				System.out.println("Digite os Detalhes: ");
				atendimento.setDescricao(scanner.nextLine());
				System.out.println("Digite o ID do Pet: ");
				Pet petAtendimento = new Pet();
				petAtendimento.setIdPet(scanner.nextInt());
				atendimento.setPet(petAtendimento);
				System.out.println("Digite o ID do Veterinario");
				Veterinario veterinarioAtendimento = new Veterinario();
				veterinarioAtendimento.setIdVeterinario(scanner.nextInt());
				atendimento.setVeterinario(veterinarioAtendimento);

				atendimentoDAO.createAtendimento(atendimento);
				break;
			case 2:

				atendimentoDAO.readAllAtendimentos();
				break;
			case 3:
				Atendimento atendimentoAtualizado = new Atendimento();
				System.out.println("Digite o ID do Atendimento a ser atualizado: ");
				atendimentoAtualizado.setIdAtendimento(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Digite o horario do atendimento no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAtendimentoAtualizado = scanner.nextLine();
				atendimentoAtualizado
						.setHorarioAtendimento(LocalDateTime.parse(dataEhoraAtendimentoAtualizado, formatter));
				System.out.println("Digite o horario do agendamento no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAgendamentoAtualizado = scanner.nextLine();
				atendimentoAtualizado
						.setHorarioAgendamento(LocalDateTime.parse(dataEhoraAgendamentoAtualizado, formatter));
				System.out.println("Digite os Detalhes: ");
				atendimentoAtualizado.setDescricao(scanner.nextLine());
				System.out.println("Digite o ID do Pet: ");
				Pet petAtendimentoAtualizado = new Pet();
				petAtendimentoAtualizado.setIdPet(scanner.nextInt());
				atendimentoAtualizado.setPet(petAtendimentoAtualizado);
				System.out.println("Digite o ID do Veterinario");
				Veterinario veterinarioAtendimentoAtualizado = new Veterinario();
				veterinarioAtendimentoAtualizado.setIdVeterinario(scanner.nextInt());
				atendimentoAtualizado.setVeterinario(veterinarioAtendimentoAtualizado);

				atendimentoDAO.updateAtendimento(atendimentoAtualizado);
				break;
			case 4:
				System.out.println(
						"Digite o ID do Atendimento a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int idAtendimento = scanner.nextInt();
				atendimentoDAO.deleteAtendimento(idAtendimento);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
}
