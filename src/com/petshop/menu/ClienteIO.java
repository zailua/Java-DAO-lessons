package com.petshop.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.petshop.dao.ClienteDAO;
import com.petshop.database.DatabaseConnection;
import com.petshop.model.Cliente;
import com.petshop.utils.Colors;

public class ClienteIO {
	static Connection connection = DatabaseConnection.createConnection();
	static ClienteDAO clienteDAO = new ClienteDAO(connection);

	public static int MenuCliente(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("Menu Cliente\n" + "1 - Cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar\n" + "0 - Sair");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Cliente cliente = new Cliente();
				System.out.println("Nome Completo: ");
				cliente.setNomeCliente(scanner.nextLine());
				System.out.println("CPF: ");
				cliente.setCpfCliente(scanner.next());
				System.out.println("Endereco: ");
				cliente.setEnderecoCliente(scanner.next());
				System.out.println("Telefone: ");
				cliente.setTelefone(scanner.next());

				clienteDAO.createClient(cliente);

				break;
			case 2:
				clienteDAO.readAllClients();
				break;

			case 3:
				Cliente clienteAtualizado = new Cliente();
				System.out.println("Digite o ID do cliente a ser atualizado: ");
				clienteAtualizado.setIdCliente(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome Completo: ");
				clienteAtualizado.setNomeCliente(scanner.nextLine());
				System.out.println("CPF: ");
				clienteAtualizado.setCpfCliente(scanner.next());
				System.out.println("Endereco: ");
				clienteAtualizado.setEnderecoCliente(scanner.next());
				System.out.println("Telefone: ");
				clienteAtualizado.setTelefone(scanner.next());

				clienteDAO.updateCliente(clienteAtualizado);
				break;
			case 4:
				System.out.println(
						"Digite o ID do Cliente que deseja " + Colors.RED.get() + "DELETAR" + Colors.RESET.get());
				int idCliente = scanner.nextInt();
				clienteDAO.deleteClient(idCliente);

			default:
			}

		} while (option != 0);

		return option;
	}

}
