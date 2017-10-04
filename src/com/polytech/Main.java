package com.polytech;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Bienvenue dans le jeu de rôle \n");
		System.out.println("********************************");
		System.out.println("*************MENU***************");
		System.out.println("********************************");
		System.out.println("1. Règles du jeu");
		System.out.println("2.Commencer le chargement de la partie");
		System.out.println("3.Quitter");
		System.out.print("Votre choix : ");
		String choix = s.nextLine();

		switch (choix) {
		case "1":
			System.out.println("");
			break;
		case "2":
			do {
				System.out.println("Choisissez un personnage :");
			} while (s.nextLine().equals("o"));
			
		case "3":
			System.exit(0);
			break;
		}
		s.close();

	}
	
}
