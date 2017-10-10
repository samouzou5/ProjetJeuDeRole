/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polytech;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Statistiques extends javax.swing.JFrame {

	/**
	 * Creates new form Statistiques
	 */

	static List<Personnage> personnages = new ArrayList<Personnage>();
	static List<ArmeLourde> armesLourdes = new ArrayList<ArmeLourde>();
	static List<ArmeMagique> armesMagiques = new ArrayList<ArmeMagique>();
	static List<ArmeDistance> armesDistances = new ArrayList<ArmeDistance>();
	static List<Equipement> equipements = new ArrayList<Equipement>();

	public static void creerPersonnages() {
		// Cr�ation des Armes
		ArmeDistance arc = new ArmeDistance("Arc", 8);
		ArmeDistance arbalete = new ArmeDistance("Arbal�te", 6);
		ArmeDistance couteaux = new ArmeDistance("Couteaux de lancer", 4);

		ArmeLourde epee = new ArmeLourde("�p�e", 3, 15);
		ArmeLourde hache = new ArmeLourde("Hache", 1, 15);
		ArmeLourde fleau = new ArmeLourde("Fleau", 2, 15);
		ArmeLourde dague = new ArmeLourde("Dague", 4, 4);

		ArmeMagique baton = new ArmeMagique("B�ton magique", 8);
		ArmeMagique feu = new ArmeMagique("Boules de feu", 8);
		ArmeMagique glace = new ArmeMagique("Boules de glace", 8);

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

	public Statistiques() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		setTitle("Statistiques personnages");
		creerPersonnages();
		//System.out.println(personnages.size());
		String[] noms_perso = new String[personnages.size()];
		for (int i = 0; i < personnages.size(); i++) {
			noms_perso[i] = personnages.get(i).getNom();
		}

		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel1.setText("Statistiques personnages");

		jComboBox1.setModel(
				new javax.swing.DefaultComboBoxModel<>(noms_perso));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel2.setText("Personnage :");

		jButton1.setText("OK");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel3.setText("Nom :");

		jLabel4.setText("Vitesse :");

		jLabel5.setText("PV :");

		jLabel6.setText("Armes :");

		jLabel7.setText("Equipement :");

		jLabel14.setText("Niveau :");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING, layout
								.createSequentialGroup().addGap(0, 60, Short.MAX_VALUE).addComponent(jLabel1)
								.addGap(70, 70, 70))
						.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(55, 55, 55)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton1)))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5)
												.addComponent(jLabel6).addComponent(jLabel7))
										.addGap(23, 23, 23)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel12).addComponent(jLabel11).addComponent(jLabel10)
												.addComponent(jLabel9).addComponent(jLabel8)))
								.addComponent(jLabel14))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(39, 39, 39)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGap(18, 18, 18).addComponent(jButton1).addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel8))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(jLabel9))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jLabel10))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(jLabel11))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(jLabel12))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel14)
						.addContainerGap(14, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		for (Personnage p : personnages) {
			if (p.getNom().equals(jComboBox1.getSelectedItem().toString())) {
				jLabel3.setText("Nom : " + p.getNom());
				jLabel4.setText("Vitesse : " + p.getVitesse());
				jLabel5.setText("PV: " + p.getPointsVie());
				jLabel6.setText("Armes : " + p.getArmesPersonnages().get(1).getNomArme() + ", "
						+ p.getArmesPersonnages().get(0).getNomArme());
				jLabel7.setText("Equipement : " + p.getEquipement().getNom());
				jLabel14.setText("Niveau : " + p.getNiveau());

			}
		}
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Statistiques.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Statistiques.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Statistiques.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Statistiques.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Statistiques().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	// End of variables declaration
}
