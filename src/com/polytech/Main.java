package com.polytech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int afficherMenuPrincipal() {
		Scanner s = new Scanner(System.in);
		System.out.println("********************************");
		System.out.println("*************MENU***************");
		System.out.println("********************************");
		System.out.println("1. Règles du jeu");
		System.out.println("2.Commencer le chargement de la partie");
		System.out.println("3.Quitter");
		System.out.print("Votre choix : ");
		String choix = s.nextLine();
		s.nextLine();
		int chiffre = -1;
		try {
			chiffre = Integer.parseInt(choix);
		} catch (Exception e) {
			System.out.println("Le choix effectué n'est pas bon. veuillez réessayer");
			afficherMenuPrincipal();
		}
		return chiffre;

	}
	
	
	public static int replay(){
		Scanner s = new Scanner(System.in);
		System.out.println("Voulez-vous rejouer? (Taper 1 pour oui 0 pour non) : ");
		int choix_replay = -1;
		try{
			choix_replay = s.nextInt();
			s.nextLine();
		}catch(Exception e){
			System.out.println("Veuillez saisir un choix valide!");
			System.out.println("\n");
			replay();
		}
		return choix_replay;
		
	}

	public static void main(String[] args) {
		do {
			System.out.println("Bienvenue dans le jeu de rôle \n");
			int choix_util = afficherMenuPrincipal();
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
				afficherMenuPrincipal();
				break;
			case 2:
				System.out.println("Choisissez un personnage parmi la liste ci-dessous :");
				/*fin du jeu possibilité de recommencer*/
				int repl = replay();
				if(repl == 1){
					afficherMenuPrincipal();
				}else{
					System.out.println("Merci d'avoir participé au jeu, au revoir!");
					System.exit(0);
				}
				break;
			case 3:
				System.out.println("Merci d'avoir participé au jeu, au revoir!");
				System.exit(0);
				break;
			}
		} while (true);
	}
	
	public static void creerPersonnages() {

	    // Création des Armes
	       ArmeDistance arc = new ArmeDistance("Arc", 8, 10);
	       ArmeDistance arbalete = new ArmeDistance("Arbalète", 6, 15);
	       ArmeDistance couteaux = new ArmeDistance("Couteaux de lancer", 4, 5);

	       ArmeLourde epee = new ArmeLourde("Épée", 3, 15);
	       ArmeLourde hache = new ArmeLourde("Hache", 1, 15);
	       ArmeLourde fleau = new ArmeLourde("Fleau", 2, 15);
	       ArmeLourde dague = new ArmeLourde("Dague", 4, 4);

	       ArmeMagique baton = new ArmeMagique("Bâton magique", 8, 10);
	       ArmeMagique feu = new ArmeMagique("Boules de feu", 8, 10);
	       ArmeMagique glace = new ArmeMagique("Boules de glace", 8, 10);


	       // Création des Equipements
	       Equipement bouclier = new Equipement("Bouclier", 0, 6);
	       Equipement casque = new Equipement("Casque", 0, 5);
	       Equipement cheval = new Equipement("Cheval", 5, 1);


	       // Création des Personnages
	       Mage gandalf = new Mage("Gandalf le Blanc", 100, 1, 1);
	       Mage sarouman = new Mage("Sarouman le Gris", 100, 1, 1);

	       Archer legolas = new Archer("Legolas", 100, 1, 1);
	       Archer tauriel = new Archer("Tauriel", 100, 1, 1);

	       Guerrier bilbo = new Guerrier("Bilbo", 100, 1, 1);
	       Guerrier aragorn = new Guerrier("Aragorn", 100, 1, 1);
	       
	       // On associe les armes et équipements aux personnages
	       gandalf.ajouterArme(baton);
	       gandalf.ajouterArme(feu);
	       gandalf.setEquipement(cheval);
	       
	       sarouman.ajouterArme(baton);
	       sarouman.ajouterArme(glace);
	       sarouman.setEquipement(bouclier);
	       
	       legolas.ajouterArme(arc);
	       legolas.ajouterArme(couteaux);
	       legolas.setEquipement(bouclier);
	       
	       tauriel.ajouterArme(arc);
	       tauriel.ajouterArme(arbalete);
	       tauriel.setEquipement(cheval);
	       
	       bilbo.ajouterArme(hache);
	       bilbo.ajouterArme(dague);
	       bilbo.setEquipement(bouclier);
	       
	       aragorn.ajouterArme(epee);
	       aragorn.ajouterArme(dague);
	       aragorn.setEquipement(cheval);
	       
	       
	       // Création des listes
	       List<Personnage> personnages = new ArrayList<Personnage>();
	       personnages.add(gandalf);
	       personnages.add(sarouman);
	       personnages.add(legolas);
	       personnages.add(tauriel);
	       personnages.add(bilbo);
	       personnages.add(aragorn);

	       List<ArmeLourde> armesLourdes = new ArrayList<ArmeLourde>();
	       armesLourdes.add(epee);
	       armesLourdes.add(hache);
	       armesLourdes.add(fleau);
	       armesLourdes.add(dague);

	       List<ArmeMagique> armesMagiques = new ArrayList<ArmeMagique>();
	       armesMagiques.add(baton);
	       armesMagiques.add(feu);
	       armesMagiques.add(glace);

	       List<ArmeDistance> armesDistances = new ArrayList<ArmeDistance>();
	       armesDistances.add(arc);
	       armesDistances.add(arbalete);
	       armesDistances.add(couteaux);

	       List<Equipement> equipements = new ArrayList<Equipement>();
	       equipements.add(bouclier);
	       equipements.add(casque);
	       equipements.add(cheval);
	}


}
