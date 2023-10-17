package com.petshop.menu;

import java.util.Scanner;

import com.petshop.utils.Colors;

public class MenuIO {

	
	public static int menu(Scanner scanner) {
		System.out.println(Colors.CYAN_BOLD.get() + "Escolha uma opcao de 1 - 5\n" + Colors.RESET.get()
		+ "1 - Cliente\n" + "2 - Pet\n" + "3 - Veterinario\n" + "4 - Atendimento\n" + "5 - Sair");
		
		
		return scanner.nextInt();
		
	}
	
	
}
