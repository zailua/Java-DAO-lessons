package com.petshop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.petshop.utils.Colors;

public class DatabaseConnection {

	private static final String url = "jdbc:mysql://localhost:3306/Petshop";

	private static final String user = "root";

	private static final String password = "root";

	


	public static Connection createConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(Colors.GREEN.get() + "Driver encontrado!\u001B[0m" + Colors.RESET.get());

		} catch (ClassNotFoundException e) {
			System.out.println(Colors.RED.get() + "Driver nao encontrado!. Mensagem:\n%s .\n" + Colors.RESET.get()
					);
		}

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(Colors.GREEN.get() + "Conectado com sucesso!" + Colors.RESET.get());
			return connection;

		} catch (SQLException e) {

			System.out.println(Colors.RED.get() + "Nao foi possivel conectar ao banco. Mensagem:\n%s .\n" + e.getMessage() +
					Colors.RESET.get());
			return null;
		}

	}

}
