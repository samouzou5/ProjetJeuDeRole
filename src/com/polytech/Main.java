package com.polytech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Personnage> personnages = new ArrayList<Personnage>();
	static List<ArmeLourde> armesLourdes = new ArrayList<ArmeLourde>();
	static List<ArmeMagique> armesMagiques = new ArrayList<ArmeMagique>();
	static List<ArmeDistance> armesDistances = new ArrayList<ArmeDistance>();
	static List<Equipement> equipements = new ArrayList<Equipement>();
	static List<Personnage> perso_joueurs = new ArrayList<Personnage>();
	static List<Integer> perso_choisi = new ArrayList<Integer>();
	static List<Joueur> liste_joueurs = new ArrayList<Joueur>();
	private static final int NB_JOUEURS = 2;
	/*
	 * public static int afficherMenuPrincipal() { Scanner s = new
	 * Scanner(System.in);
	 * System.out.println("********************************");
	 * System.out.println("*************MENU***************");
	 * System.out.println("********************************");
	 * System.out.println("1. R�gles du jeu");
	 * System.out.println("2.Commencer le chargement de la partie");
	 * System.out.println("3.Quitter"); System.out.print("Votre choix : ");
	 * String choix = s.nextLine(); int chiffre = -1; try { chiffre =
	 * Integer.parseInt(choix); } catch (Exception e) {
	 * System.out.println("Le choix effectu� n'est pas bon. veuillez r�essayer"
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
		System.out.println("\t\t\t\tBienvenue dans le jeu de r�le \n");
		do {
			System.out.println("\t\t\t\t********************************");
			System.out.println("\t\t\t\t*************MENU***************");
			System.out.println("\t\t\t\t********************************");
			System.out.println("\t\t\t\t1. R�gles du jeu");
			System.out.println("\t\t\t\t2.Commencer le chargement de la partie");
			System.out.println("\t\t\t\t3.Quitter");
			System.out.println("\n");
			System.out.print("Votre choix : ");
			int choix_util = new Scanner(System.in).nextInt();
			switch (choix_util) {
			case 1:
				System.out.println("Les r�gles du jeu sont tr�s simples : ");
				System.out.println("- une partie se joue obligatoirement avec 2 joueurs.");
				System.out.println("- chaque joueur choisit un personnage ainsi qu'une arme et un �quipement");
				System.out.println("Une partie se d�roule en 3 tours maximum avec 2 tours gagnants.");
				System.out.println(
						"- Lors de l'attaque d'un personnage, le personnage adverse subit des dommages offensifs et d�fensifs.");
				System.out.println(
						"- Chaque joueur peut utiliser une capacit� sp�ciale de son personnage pour renverser la partie!");
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
				boolean quit = false;
				boolean replay = false;
				boolean control = false;
				int choix_perso = -1;
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
											+ " ce personnage a d�j� �t� choisi, veuillez en s�lectionner un autre!");
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
				System.out.println("R�capitulatif!");
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

					// cr�ation d'une partie
					Partie partie = new Partie();

					// Initialisation des personnages attaqu� et attaquant
					Personnage premierPersonnage = liste_joueurs.get(0).getPersonnage();
					Personnage secondPersonnage = liste_joueurs.get(1).getPersonnage();
					
					// On attribut les personnages attaquant et attaqu�
					Personnage attaquant = premierPersonnage;
					Personnage attaque = secondPersonnage;
					
					System.out.println("C'est � " + attaquant.getNom() + " de commencer");

					while (!premierPersonnage.getMort() && !secondPersonnage.getMort()) {

						if (partie.getNbTours() > 0) {
							System.out.println("Au tour de " + attaquant.getNom());
						}

						// On fait l'attaque + on demande l'arme
						int cptArme;
						for (int i = 0; i < attaquant.getArmesPersonnages().size(); i++) {
							cptArme = i + 1;
							Arme arme = attaquant.getArmesPersonnages().get(i);
							System.out.println("Arme " + cptArme + " - " + arme.getNomArme() + " : " + arme.getDegats()
									+ " d�gats");
							// AFFICHER LES MUNITIONS !!!!!!!!!!!!!!!!!!!
						}
						
						int choix_arme = -1;
						Arme arme_choisis = Arme();
						control = false;
						
						do {
							try {
								System.out.println(attaquant.getNom() + ", choisissez votre arme : ");
								choix_arme = new Scanner(System.in).nextInt();
								
								if (choix_arme >= 1 && choix_arme <= 2) {
									
										arme_choisis = attaquant.getArmesPersonnages().get(choix_arme - 1);
										System.out.println("Le personnage " + attaquant.getNom() + " a choisi l'arme : " + arme_choisis.getNomArme());
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
						
						// On lance l'attaque
						attaquant.lancerAttaque(attaque, arme_choisis);
						
						// Incr�mentation du tour
						partie.incrementerTour();

						// Attaquant et attaqu� inversent
						Personnage bufferAttaquant;
						bufferAttaquant = attaquant;
						attaquant = attaque;
						attaque = bufferAttaquant;					
					}

					// On r�capitule la partie
					System.out.println(attaquant.getNom() + " a gagn� la partie en " + partie.getNbTours() + " tours");
					
					// Incrementer victoire, d�faite et partie
					liste_joueurs.get(0).incrementerParties();
					liste_joueurs.get(1).incrementerParties();
					
					// Incr�menter victoire et d�faites
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
					
					// Remettre les munitions et mana par d�faut !!!!!!!!
					
					if (liste_joueurs.get(0).getNbVictoires() >= 2 || liste_joueurs.get(1).getNbVictoires() >= 2) {
						continuerMatch = false;
						
						/*
						 * fin du jeu possibilit� de recommencer un match (2-3 parties)
						 */
						do {
							System.out.println("Voulez-vous recommencer? (o/n) : ");
							String s = new Scanner(System.in).nextLine();

							if (!s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("o")) {
								quit = false;

							} else if (s.equalsIgnoreCase("n")) {
								quit = true;
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
				System.out.println("Merci d'avoir particip� au jeu, au revoir !");
				System.exit(0);
				break;
			}
		} while (!arret);

	}

	public static void creerPersonnages() {
		// Cr�ation des Armes
		ArmeDistance arc = new ArmeDistance("Arc", 8, 10);
		ArmeDistance arbalete = new ArmeDistance("Arbal�te", 6, 15);
		ArmeDistance couteaux = new ArmeDistance("Couteaux de lancer", 4, 5);

		ArmeLourde epee = new ArmeLourde("�p�e", 3, 15);
		ArmeLourde hache = new ArmeLourde("Hache", 1, 15);
		ArmeLourde fleau = new ArmeLourde("Fleau", 2, 15);
		ArmeLourde dague = new ArmeLourde("Dague", 4, 4);

		ArmeMagique baton = new ArmeMagique("B�ton magique", 8, 10);
		ArmeMagique feu = new ArmeMagique("Boules de feu", 8, 10);
		ArmeMagique glace = new ArmeMagique("Boules de glace", 8, 10);

		// Cr�ation des Equipements
		Equipement bouclier = new Equipement("Bouclier", 0, 6);
		Equipement casque = new Equipement("Casque", 0, 5);
		Equipement cheval = new Equipement("Cheval", 5, 1);

		// Cr�ation des Personnages
		Mage gandalf = new Mage("Gandalf le Blanc", 100, 1, 1);
		Mage sarouman = new Mage("Sarouman le Gris", 100, 1, 1);

		Archer legolas = new Archer("Legolas", 100, 1, 1);
		Archer tauriel = new Archer("Tauriel", 100, 1, 1);

		Guerrier bilbo = new Guerrier("Bilbo", 100, 1, 1);
		Guerrier aragorn = new Guerrier("Aragorn", 100, 1, 1);

		// On associe les armes et �quipements aux personnages
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

		// Cr�ation des listes
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

}
