package com.polytech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Main {
	private static List<Personnage> personnages = new ArrayList<Personnage>();
	private static List<ArmeLourde> armesLourdes = new ArrayList<ArmeLourde>();
	private static List<ArmeMagique> armesMagiques = new ArrayList<ArmeMagique>();
	private static List<ArmeDistance> armesDistances = new ArrayList<ArmeDistance>();
	private static List<Equipement> equipements = new ArrayList<Equipement>();
	private static List<Personnage> perso_joueurs = new ArrayList<Personnage>();
	private static List<Integer> perso_choisi = new ArrayList<Integer>();
	private static List<Joueur>liste_joueurs = new ArrayList<Joueur>();
	private static final int NB_JOUEURS = 2;
	/*
	 * public static int afficherMenuPrincipal() { Scanner s = new
	 * Scanner(System.in);
	 * System.out.println("********************************");
	 * System.out.println("*************MENU***************");
	 * System.out.println("********************************");
	 * System.out.println("1. Règles du jeu");
	 * System.out.println("2.Commencer le chargement de la partie");
	 * System.out.println("3.Quitter"); System.out.print("Votre choix : ");
	 * String choix = s.nextLine(); int chiffre = -1; try { chiffre =
	 * Integer.parseInt(choix); } catch (Exception e) {
	 * System.out.println("Le choix effectué n'est pas bon. veuillez réessayer"
	 * ); afficherMenuPrincipal(); } return chiffre;
	 * 
	 * }
	 */

	/*
	 * public static int replay(){ Scanner s = new Scanner(System.in);
	 * System.out.
	 * println("Voulez-vous rejouer? (Taper 1 pour oui 0 pour non) : "); int
	 * choix_replay = -1; try{ choix_replay = s.nextInt(); }catch(Exception e){
	 * System.out.println("Veuillez saisir un choix valide!");
	 * System.out.println("\n"); replay(); } return choix_replay;
	 * 
	 * }
	 */

	public static void main(String[] args) {
		boolean arret = false; 
		boolean controle_choix = false;
		int choix_util = -1;
		//Menu principal du jeu
		System.out.println("\t\t\t\tBienvenue dans le jeu de rôle \n");
		do {
			System.out.println("\t\t\t\t********************************");
			System.out.println("\t\t\t\t*************MENU***************");
			System.out.println("\t\t\t\t********************************");
			System.out.println("\t\t\t\t1. Règles du jeu");
			System.out.println("\t\t\t\t2.Commencer le chargement de la partie");
			System.out.println("\t\t\t\t3.Quitter");
			System.out.println("\t\t\t\t4.Statistiques personnages");
			System.out.println("\n");
			do{
				System.out.print("Votre choix : ");//l'utilisateur doit effectuer son choix
				try{
					choix_util = new Scanner(System.in).nextInt();
				controle_choix = true;
				if(choix_util < 1 || choix_util > 4){
					controle_choix = false;
					choix_util = -1;
					System.out.println("Votre choix est invalide! Veuillez réessayer!");
				}
				}catch(Exception e){
					controle_choix = false;
					choix_util = -1;
					System.out.println("Votre choix est invalide! Veuillez réessayer!");
				}
			}while(choix_util == -1 || !controle_choix);
			switch (choix_util) {
			case 1:
				System.out.println("Les règles du jeu sont très simples : ");
				System.out.println("- une partie se joue obligatoirement avec 2 joueurs.");
				System.out.println("- chaque joueur choisit un personnage ainsi qu'une arme et un équipement");
				System.out.println("Une partie se déroule en 3 parties maximum avec 2 parties gagnants.");
				System.out.println(
						"- Lors de l'attaque d'un personnage, le personnage adverse subit des dommages offensifs et défensifs.");
				System.out.println(
						"- Chaque joueur peut utiliser une capacité spéciale de son personnage pour renverser la partie!");
				System.out.println("BON JEU!");
				System.out.println("\n");
				System.out.println("\n");
				// test
				/*
				 * creerPersonnages(); for(Equipement e : equipements){
				 * System.out.println(e.getPointsAttaque()); }
				 */
				break;
			case 2:
				boolean quit = false; //booleen de controle pour quitter la partie
				boolean replay = false;//booleen de controle pour rejouer la partie
				boolean control = false;//booleen de controle dans les boucles
				int choix_perso = -1;//choix utilisateur
				Joueur joueur;
				creerPersonnages();
				for (int i = 1; i <= NB_JOUEURS; i++) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Quel est votre nom ? ");
					String nom = sc.nextLine();
					joueur = new Joueur(nom, 0, 0, 0);
					liste_joueurs.add(joueur);
					System.out.println("\n");
					int cpt = 1;
					System.out.println("Bonjour " + nom + ", choisissez un personnage parmi la liste ci-dessous :");
					for (Personnage p : personnages) {
						System.out.println(cpt + "-> " + "Nom : " + p.getNom() + "\n  Arme principale : "
								+ p.getArmesPersonnages().get(1).getNomArme() + "\n  PV : " + p.getPointsVie()
								+ "\n Tapez " + cpt + " pour le choisir");
						cpt++;
					}
					do {
						try {
							System.out.print("Votre choix : ");
							choix_perso = new Scanner(System.in).nextInt();
							if (choix_perso >= 1 && choix_perso <= 6) {
								if (perso_choisi.contains(choix_perso)) {
									System.out.println(nom
											+ " ce personnage a déjà été choisi, veuillez en sélectionner un autre!");
									control = false;
								} else {
									perso_choisi.add(choix_perso);
									System.out.println("Le joueur " + nom + " a choisi comme personnage : "
											+ personnages.get(choix_perso - 1).getNom());
									joueur.setPersonnage(personnages.get(choix_perso - 1));
									control = true;
								}
							} else {
								System.out.println("Mauvais choix! Veuillez effectuer un autre choix");
							}

						} catch (Exception e) {
							System.out.println("Vous devez choisir un personnage entre 1 et 6");
						}
						System.out.println("Tapez une touche pour continuer");
						new Scanner(System.in).nextLine();
					} while (!control);
				}
				System.out.println("*********************************");
				System.out.println("Récapitulatif!");
				System.out.println("*********************************");
				System.out.println("\n");
				// int index = 0;
				for (int k = 0; k < NB_JOUEURS; k++) {
					System.out.println("Le joueur " + liste_joueurs.get(k).getNom() + " a choisi le personnage : "
							+ personnages.get(k).getNom());
				}
				System.out.println("C'est l\'heure du duel");

				boolean continuerMatch = true;

				while (continuerMatch) {

					// création d'une partie
					Partie partie = new Partie();

					// Initialisation des personnages attaqué et attaquant
					Personnage premierPersonnage = liste_joueurs.get(0).getPersonnage();
					Personnage secondPersonnage = liste_joueurs.get(1).getPersonnage();
					
					// On attribut les personnages attaquant et attaqué
					Personnage attaquant = premierPersonnage;
					Personnage attaque = secondPersonnage;
					
					System.out.println("C'est à " + attaquant.getNom() + " de commencer");

					while (!premierPersonnage.getMort() && !secondPersonnage.getMort()) {

						if (partie.getNbTours() > 0) {
							System.out.println("Au tour de " + attaquant.getNom());
						}

						// On fait l'attaque + on demande l'arme
						int cptArme;
						for (int i = 0; i < attaquant.getArmesPersonnages().size(); i++) {
							cptArme = i + 1;
							Arme arme = attaquant.getArmesPersonnages().get(i);
							int munitions = 0;
							
							if(arme instanceof ArmeDistance) {
								System.out.println("Arme " + cptArme + " - " + arme.getNomArme() + " : " + arme.getDegats()
								+ " dégats - " + munitions + " flèches");
							}
							
							if(arme instanceof ArmeMagique) {
								munitions = ((ArmeMagique) arme).getNbMana();
								System.out.println("Arme " + cptArme + " - " + arme.getNomArme() + " : " + arme.getDegats()
								+ " dégats - " + munitions + " de mana");
							}
							
							if(arme instanceof ArmeLourde) {
								System.out.println("Arme " + cptArme + " - " + arme.getNomArme() + " : " + arme.getDegats()
								+ " dégats");
							}
						}
						
						int choix_arme = -1;
						control = false;
						
						do {
							try {
								System.out.println(attaquant.getNom() + ", choisissez votre arme : ");
								choix_arme = new Scanner(System.in).nextInt();
								
								Arme arme_choisie;
								
								if (choix_arme >= 1 && choix_arme <= 2) {
									
										arme_choisie = attaquant.getArmesPersonnages().get(choix_arme - 1);
										System.out.println("Le personnage " + attaquant.getNom() + " a choisi l'arme : " + arme_choisie.getNomArme());
										
										// On lance l'attaque
										attaquant.lancerAttaque(attaque, arme_choisie);
										
										control = true;
									
								} else {
									System.out.println("Mauvais choix! Veuillez effectuer un autre choix");
									control = false;
								}

							} catch (Exception e) {
								System.out.println("Vous devez choisir une arme entre 1 et 2");
							}

							// System.out.println("Tapez une touche pour continuer");
							// new Scanner(System.in).nextLine();

						} while (!control);
						
						// Incrémentation du tour
						partie.incrementerTour();

						// Attaquant et attaqué inversent
						Personnage bufferAttaquant;
						bufferAttaquant = attaquant;
						attaquant = attaque;
						attaque = bufferAttaquant;					
					}

					// On récapitule la partie
					System.out.println(attaquant.getNom() + " a gagné la partie en " + partie.getNbTours() + " tours");
					
					// Incrementer victoire, défaite et partie
					liste_joueurs.get(0).incrementerParties();
					liste_joueurs.get(1).incrementerParties();
					
					// Incrémenter victoire et défaites
					if(liste_joueurs.get(0).getPersonnage().getMort()) {
						liste_joueurs.get(0).incrementerDefaites();
						liste_joueurs.get(1).incrementerVictoires();
					} else {
						liste_joueurs.get(0).incrementerVictoires();
						liste_joueurs.get(1).incrementerDefaites();
					}

					// Premier et second personnages inversent
					Personnage bufferPremier;
					bufferPremier = premierPersonnage;
					premierPersonnage = secondPersonnage;
					secondPersonnage = bufferPremier;
					
					premierPersonnage.setPointsVie(100);
					secondPersonnage.setPointsVie(100);
					
					// Remettre les munitions et mana par défaut (cas ArmeDistance et ArmeMagique)
					for(Arme arme : premierPersonnage.getArmesPersonnages()) {
						arme.remiseAZero();
					}
					
					for(Arme arme : secondPersonnage.getArmesPersonnages()) {
						arme.remiseAZero();
					}
					
					if (liste_joueurs.get(0).getNbVictoires() >= 2 || liste_joueurs.get(1).getNbVictoires() >= 2) {
						continuerMatch = false;
						
						/*
						 * fin du jeu possibilité de recommencer un match (2-3 parties)
						 */
						do {
							System.out.println("Voulez-vous recommencer? (o/n) : ");
							String s = new Scanner(System.in).nextLine();

							if (!s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("o")) {
								quit = false;

							} else if (s.equalsIgnoreCase("n")) {
								quit = true;
								continuerMatch = false;
								System.out.println("Vous quittez le jeu!");
								System.exit(0);

							} else if (s.equalsIgnoreCase("o")) {
								replay = true;
								continuerMatch = true;
							}
						} while (!replay && !quit);
					}
				}

				break;
			case 3:
				arret = true;
				System.out.println("Merci d'avoir participé au jeu, au revoir !");
				System.exit(0);
				break;
			case 4:
				Statistiques s = new Statistiques();
				s.setAlwaysOnTop(true);
				s.setVisible(true);
				break;
			}
		} while (!arret);

	}

	public static void creerPersonnages() {
		// Création des Armes
		ArmeDistance arc = new ArmeDistance("Arc", 8);
		ArmeDistance arbalete = new ArmeDistance("Arbalète", 6);
		ArmeDistance couteaux = new ArmeDistance("Couteaux de lancer", 4);

		ArmeLourde epee = new ArmeLourde("Épée", 3, 15);
		ArmeLourde hache = new ArmeLourde("Hache", 1, 15);
		ArmeLourde fleau = new ArmeLourde("Fleau", 2, 15);
		ArmeLourde dague = new ArmeLourde("Dague", 4, 4);

		ArmeMagique baton = new ArmeMagique("Bâton magique", 8);
		ArmeMagique feu = new ArmeMagique("Boules de feu", 8);
		ArmeMagique glace = new ArmeMagique("Boules de glace", 8);

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
		// List<Personnage> personnages = new ArrayList<Personnage>();
		personnages.add(gandalf);
		personnages.add(sarouman);
		personnages.add(legolas);
		personnages.add(tauriel);
		personnages.add(bilbo);
		personnages.add(aragorn);

		// List<ArmeLourde> armesLourdes = new ArrayList<ArmeLourde>();
		armesLourdes.add(epee);
		armesLourdes.add(hache);
		armesLourdes.add(fleau);
		armesLourdes.add(dague);

		// List<ArmeMagique> armesMagiques = new ArrayList<ArmeMagique>();
		armesMagiques.add(baton);
		armesMagiques.add(feu);
		armesMagiques.add(glace);

		// List<ArmeDistance> armesDistances = new ArrayList<ArmeDistance>();
		armesDistances.add(arc);
		armesDistances.add(arbalete);
		armesDistances.add(couteaux);

		// List<Equipement> equipements = new ArrayList<Equipement>();
		equipements.add(bouclier);
		equipements.add(casque);
		equipements.add(cheval);
	}
	
	public static void supprimerListes() {
		personnages.clear();
		armesLourdes.clear();
		armesMagiques.clear();
		armesDistances.clear();
		equipements.clear();
	}

}
