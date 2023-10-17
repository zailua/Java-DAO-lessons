package com.petshop;

import java.util.Scanner;

import com.petshop.menu.AtendimentoIO;
import com.petshop.menu.ClienteIO;
import com.petshop.menu.MenuIO;
import com.petshop.menu.PetIO;
import com.petshop.menu.VeterinarioIO;
import com.petshop.utils.Colors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ClienteIO.SubMenuCliente(scanner);
				break;
			case 2:
				PetIO.SubMenuPet(scanner);
				break;
			case 3:
				VeterinarioIO.SubMenuVeterinario(scanner);
				break;
			case 4:
				AtendimentoIO.SubMenuAtendimento(scanner);
				break;
			default:
				System.out.println(Colors.RED.get() + "Digite uma opcao valida!" + Colors.RED.get());

			}

		} while (option != 5);
		scanner.close();

	}

}
