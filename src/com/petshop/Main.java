package com.petshop;

import java.util.Scanner;

import com.petshop.menu.ClienteIO;
import com.petshop.menu.MenuIO;
import com.petshop.menu.VeterinarioIO;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		var option = Integer.MAX_VALUE;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ClienteIO.MenuCliente(scanner);
				break;
			case 2:
				VeterinarioIO.MenuVeterinario(scanner);
				break;
//			case 3:
//				
//			case 4:
//				
//				break;
//			case 5:
//				Pet pet = new Pet();
//				Cliente clientePet = new Cliente();
//				System.out.println("Digite o nome do PET: \n");
//				pet.setNomePet(scanner.next());
//				System.out.println("Digite o nome do Porte do Pet entre esse valores Pequeno, Medio e Grande: \n");
//				pet.setPortePet(scanner.next().toUpperCase());
//				System.out.println("Digite a especie do pet: \n");
//				pet.setEspeciePet(scanner.next());
//				System.out.println("Digite a raca do pet: \n");
//				pet.setRacaPet(scanner.next());
//				System.out.println("Digite a Idade do Pet: \n");
//				pet.setIdadePet(scanner.nextInt());
//				System.out.println("Digite o ID do Dono do Pet: \n");
//				clientePet.setIdCliente(scanner.nextInt());
//				pet.setCliente(clientePet);
//
//				petDAO.createPet(pet);
//
//				break;
//
//			case 6:
//				petDAO.readAllPets();
//
//				break;
//			case 7:
//				Pet petAtualizado = new Pet();
//				Cliente clientePetAtualizado = new Cliente();
//				System.out.println("Digite o ID do PET a ser atualizado: ");
//				petAtualizado.setIdPet(scanner.nextInt());
//				scanner.nextLine();
//				System.out.println("Nome do Pet: ");
//				petAtualizado.setNomePet(scanner.nextLine());
//				System.out.println("Escolha entre os tamanhos Pequeno, Medio e Grande");
//				petAtualizado.setPortePet(scanner.next());
//				System.out.println("Escolha a Especie do Pet");
//				petAtualizado.setEspeciePet(scanner.next());
//				System.out.println("Escolha a Raca do Pet: ");
//				petAtualizado.setRacaPet(scanner.next());
//				System.out.println("Idade do Pet");
//				petAtualizado.setIdadePet(scanner.nextInt());
//				System.out.println("Digite o numero do Cliente");
//				clientePetAtualizado.setIdCliente(scanner.nextInt());
//				petAtualizado.setCliente(clientePetAtualizado);
//				
//
//				petDAO.updatePet(petAtualizado);
//				break;
			}

		} while (option != 0);
		scanner.close();
	}

}
