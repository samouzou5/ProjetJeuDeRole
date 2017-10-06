package com.polytech;

import java.util.Scanner;

public class Main {

	/*public static int afficherMenuPrincipal() {
		Scanner s = new Scanner(System.in);
		System.out.println("********************************");
		System.out.println("*************MENU***************");
		System.out.println("********************************");
		System.out.println("1. Règles du jeu");
		System.out.println("2.Commencer le chargement de la partie");
		System.out.println("3.Quitter");
		System.out.print("Votre choix : ");
		String choix = s.nextLine();
		int chiffre = -1;
		try {
			chiffre = Integer.parseInt(choix);
		} catch (Exception e) {
			System.out.println("Le choix effectué n'est pas bon. veuillez réessayer");
			afficherMenuPrincipal();
		}
		return chiffre;

	}*/
	
	
	/*public static int replay(){
		Scanner s = new Scanner(System.in);
		System.out.println("Voulez-vous rejouer? (Taper 1 pour oui 0 pour non) : ");
		int choix_replay = -1;
		try{
			choix_replay = s.nextInt();
		}catch(Exception e){
			System.out.println("Veuillez saisir un choix valide!");
			System.out.println("\n");
			replay();
		}
		return choix_replay;
		
	}*/

	public static void main(String[] args) {
		boolean arret = false;
		System.out.println("Bienvenue dans le jeu de rôle \n");
		do {
			System.out.println("********************************");
			System.out.println("*************MENU***************");
			System.out.println("********************************");
			System.out.println("1. Règles du jeu");
			System.out.println("2.Commencer le chargement de la partie");
			System.out.println("3.Quitter");
			System.out.print("Votre choix : ");
			int choix_util = new Scanner(System.in).nextInt();
			switch (choix_util) {
			case 1:
				System.out.println("Les règles du jeu sont très simples : ");
				System.out.println("- une partie se joue obligatoirement avec 2 joueurs.");
				System.out.println("- chaque joueur choisit un personnage ainsi qu'une arme et un équipement");
				System.out.println("Une partie se déroule en 3 tours maximum avec 2 tours gagnants.");
				System.out.println(
						"- Lors de l'attaque d'un personnage, le personnage adverse subit des dommages offensifs et défensifs.");
				System.out.println(
						"- Chaque joueur peut utiliser une capacité spéciale de son personnage pour renverser la partie!");
				System.out.println("BON JEU!");
				System.out.println("\n");
				System.out.println("\n");
				break;
			case 2:
				boolean quit = false;
				boolean replay = false;
				System.out.println("Choisissez un personnage parmi la liste ci-dessous :");
				/*fin du jeu possibilité de recommencer*/
				do{
					System.out.println("Voulez-vous recommencer? (o/n) : ");
					String s = new Scanner(System.in).nextLine();
					if(!s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("o")){
						quit = false;
					}else if(s.equalsIgnoreCase("n")){
						quit = true;
						System.out.println("Vous quittez le jeu!");
						System.exit(0);
					}else if(s.equalsIgnoreCase("o")){
						replay = true;
					}
				}while(!replay && !quit );
				break;
			case 3:
				arret = true;
				System.out.println("Merci d'avoir participé au jeu, au revoir!");
				System.exit(0);
				break;
			}
		} while (!arret);
	}

}
