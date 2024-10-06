package tp1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MaFrame extends JFrame{
	//liste des attributs de la vue (MaFrame)
	private JMenuBar barreMennus;
	private JMenu partie, couleurs,admin;
	private JMenuItem nouvelle, recherche,quitter, bleu,rose, mauve, joueurs;
	private JPanel inscriptionJ, jouer, administration;
	private JTabbedPane onglets;
	private JLabel imageLabel, bienv,labelPseudo, labelNom, labelPrenom, labelNaissance, labelGenre,imageLabelG, titre, bienve, nombre, nbEssai, chiffre, user;
	private ImageIcon male, female;
	private JTextField champPseudo,champPrenom, champNom, txtf, pseudo, nom, prenom;
	private JFormattedTextField champNaissance,dateNaissanceAdm;
	private JComboBox<String> comboBoxGenre, comboBoxGenreAdm;
	private JButton ajouterB, annulerB, validerB, supprimerB, modifierB, prev, next ;
	// constructeur 
	public MaFrame() {
		
		super("jeu de Devinette");
		initComponents();
		Font f = new Font("Serif", Font.BOLD,25);
		setFont(f);
		setSize(1600,1400);
		Image icon = Toolkit.getDefaultToolkit().getImage("img/dev-removebg-preview.png");
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		male= new ImageIcon("img/male-removebg-preview.png");
		female = new ImageIcon("img/female-removebg-preview.png");
		setVisible(true);
		}
	
	private void initComponents() {
			barreMennus= new JMenuBar();
			setJMenuBar(barreMennus);
			/*creation menu partie et ses options*/
			partie = new JMenu("Partie");
			barreMennus.add(partie);
			nouvelle = new JMenuItem("Nouvelle partie...");
			partie.add(nouvelle);
			recherche = new JMenuItem("Recherche joueur");
			partie.add(recherche);
			partie.addSeparator();
			quitter= new JMenuItem("Quitter");
			partie.add(quitter);
			/* creation menu couleurs et ses options*/
			couleurs = new JMenu("Couleurs");
			barreMennus.add(couleurs);
			bleu = new JMenuItem("Bleu");
			couleurs.add(bleu);
			rose = new JMenuItem("Rose");
			couleurs.add(rose);
			mauve= new JMenuItem("Mauve");
			couleurs.add(mauve);
			/*creation menu administration et ses options*/
			admin = new JMenu("Administration");
			barreMennus.add(admin);
			joueurs=  new JMenuItem("Joueurs");
			admin.add(joueurs);
			/*ajout de 3 onglets*/
			onglets = new JTabbedPane(JTabbedPane.TOP);
			inscriptionJ = new JPanel();
			onglets.add("Inscription Joueurs", inscriptionJ);
			jouer = new JPanel();
			onglets.add("Jouer", jouer);
			administration= new JPanel();
			onglets.add("Administration", administration);
			this.setLayout(new BorderLayout()); // pour qu'il s'affiche
			this.add(onglets, BorderLayout.CENTER);
			inscriptionPanneau();
			jouerPanneau();
			adminisPanneau();
			jouer.setVisible(false);
			administration.setVisible(false);
			/* ajout des evenements*/
			ajouterEvenements();
			
			
		}

	private void ajouterEvenements() {
		
		/* evenement pour nouvelle partie*/
		nouvelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pseudo = null;
                do {
                    pseudo = JOptionPane.showInputDialog(MaFrame.this, "Veuillez entrer un pseudo pour le joueur :");
                    if (pseudo == null) { 
                        return;
                    }
                } while (pseudo.trim().isEmpty()); 

                
                bienv.setText("Bienvenue, " + pseudo + "!"); 
                jouer.setVisible(true); 
            }
        });
		

		
		/* evenement pour quitter */
		
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/* evenement pour recherche joueur*/
		
		recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudo = null;
			       do {
	                    pseudo = JOptionPane.showInputDialog(MaFrame.this, "Veuillez entrer un pseudo du joueur");
	                    if (pseudo == null) { 
	                        return;
	                    }
	                } while (pseudo.trim().isEmpty()); 

	                
	                bienv.setText("Bienvenue, " + pseudo + "!"); 
	                jouer.setVisible(true); 
	            }
	        });
		
		
		
		
		
	}

	private void adminisPanneau() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints contraintes = new GridBagConstraints();
		administration.setLayout(layout);
		administration.setBackground(Color.BLUE);
		pseudo = new JTextField(18);
		prenom = new JTextField(18);
		nom = new JTextField(18);
		comboBoxGenreAdm = new JComboBox<>( new String[] {"Feminin", "Masculin"});
		dateNaissanceAdm = new JFormattedTextField(new java.text.SimpleDateFormat("YYYY-MM-DD"));
		dateNaissanceAdm.setPreferredSize(new Dimension(150,25));
		supprimerB = new JButton("Supprimer");
		modifierB = new JButton("Modifier");
		prev = new JButton("<");
		next = new JButton (">");
		
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.gridx=0;
		contraintes.gridy=0;
		administration.add(pseudo, contraintes);
		
		contraintes.gridx=1;
		contraintes.gridy=0;
		administration.add(nom, contraintes);
		
		contraintes.gridx=2;
		contraintes.gridy=0;
		administration.add(prenom, contraintes);
		
		contraintes.gridx=3;
		contraintes.gridy=0;
		administration.add(dateNaissanceAdm, contraintes);
		
		contraintes.gridx=4;
		contraintes.gridy=0;
		administration.add(comboBoxGenreAdm, contraintes);
		
		contraintes.gridx=1;
		contraintes.gridy=1;
		administration.add(prev, contraintes);
		
		contraintes.gridx=1;
		contraintes.gridy=2;
		administration.add(modifierB, contraintes);
		
		contraintes.gridx=3;
		contraintes.gridy=1;
		administration.add(next, contraintes);
		
		contraintes.gridx=3;
		contraintes.gridy=2;
		administration.add(supprimerB, contraintes);
		
		
		
		
		
	}

	private void jouerPanneau() {
		jouer.setLayout(new BorderLayout());
		
		/* panneau nord avec image gris */
		
		JPanel northPanel = new JPanel();
		ImageIcon img = new ImageIcon("img/dev-removebg-preview.png");
		northPanel.setBackground(Color.lightGray);
		Image image = img.getImage();
		Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		imageLabel = new JLabel(scaledIcon);
		northPanel.add(imageLabel);
		jouer.add(northPanel, BorderLayout.NORTH);
		/*changement de couleurs classe anonyme*/
		bleu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				northPanel.setBackground(Color.BLUE);
			}
		});
		rose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				northPanel.setBackground(Color.PINK);
				
			}
		});
		mauve.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				northPanel.setBackground(new Color(224,176,255));
			}
		});
		
		
		/* panneau central pink */
		
		JPanel centerPanel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints contraintes = new GridBagConstraints();
		centerPanel.setLayout(layout);
		
		titre = new JLabel("Jeu de Devinette");
		titre.setFont(new Font("Serif", Font.ITALIC,20));
		txtf = new JTextField(8);
		bienve = new JLabel("Bienvenu");
		
		nombre = new JLabel("Entrez le nombre à deviner entre 0 et 50 ");
		nbEssai = new JLabel("Nombre d'essais restants ");
		validerB = new JButton("Valider");
		user = new JLabel("Plus Petit!");
		user.setForeground(Color.RED);
		user.setFont(new Font("Serif", Font.ITALIC,20));
		chiffre = new JLabel("7");
		chiffre.setForeground(Color.BLUE);
		
		contraintes.insets = new Insets (10,10,10,10);
		contraintes.gridx=4;
		contraintes.gridy=0;
		centerPanel.add(titre, contraintes);
		
		contraintes.gridx=4;
		contraintes.gridy=1;
		centerPanel.add(bienve, contraintes);
		
		contraintes.gridx=2;
		contraintes.gridy=2;
		centerPanel.add(nombre, contraintes);
		
		contraintes.gridx=5;
		centerPanel.add(txtf, contraintes);
		
		contraintes.gridx=5;
		contraintes.gridy=3;
		centerPanel.add(validerB, contraintes);
		
		contraintes.gridx=2;
		contraintes.gridy=4;
		centerPanel.add(nbEssai, contraintes);
		
		contraintes.gridx=6;
		contraintes.gridy=3;
		centerPanel.add(user, contraintes);
		
		contraintes.gridx=4;
		contraintes.gridy=4;
		centerPanel.add(chiffre, contraintes);
		
		centerPanel.setBackground(Color.PINK);
		jouer.add(centerPanel, BorderLayout.CENTER);
		
		
		
		
		
		
		
		
	}

	private void inscriptionPanneau() {
		inscriptionJ.setLayout(new BorderLayout());
		
		// panneau nord 
		
		JPanel northPanel = new JPanel();
		imageLabel = new JLabel(new ImageIcon("img/inscrire-removebg-preview.png"));
		northPanel.add(imageLabel);
		northPanel.setBackground(Color.BLUE);
		inscriptionJ.add(northPanel, BorderLayout.NORTH);
		bleu.addActionListener(new ActionListener(){
			/* changement de couleur classe anonyme */
			public void actionPerformed(ActionEvent e) {
				northPanel.setBackground(Color.BLUE);
			}});
		rose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				northPanel.setBackground(Color.PINK);
			}
		});
		mauve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				northPanel.setBackground(new Color(224,176,255));
			}
		});
		
		
		// panneau central
		
		JPanel centerPanel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints contraintes = new GridBagConstraints();
		centerPanel.setLayout(layout);
		bienv = new JLabel ("Bienvenu, merci de vous inscrire pour pouvoir jouer!");
		labelPseudo = new JLabel ("Pseudo ");
		champPseudo = new JTextField(8);
		labelPrenom = new JLabel("Prénom ");
		champPrenom = new JTextField(15);
		labelNom = new JLabel("Nom ");
		champNom = new JTextField(15);
		labelGenre = new JLabel("Genre ");
		comboBoxGenre = new JComboBox<>( new String[] {"Masculin","Feminin"});
		comboBoxGenre.addActionListener(new comboBoxListener());
		imageLabelG = new JLabel ( new ImageIcon("img/male-removebg-preview.png"));
		labelNaissance = new JLabel("Date de naissance ");
		champNaissance = new JFormattedTextField(new java.text.SimpleDateFormat("yyyy-MM-DD"));
		champNaissance.setPreferredSize(new Dimension(150,25));
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		centerPanel.add(bienv, contraintes);
		
		contraintes.gridx =0;
		contraintes.gridy = 1;
		centerPanel.add(labelPseudo, contraintes);
		
		contraintes.gridx = 1;
		centerPanel.add(champPseudo, contraintes);
		
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		centerPanel.add(labelGenre, contraintes);
		
		contraintes.gridx = 1;
		centerPanel.add(comboBoxGenre, contraintes);
		
		contraintes.gridx = 5;
		contraintes.gridy = 2;
		centerPanel.add(imageLabelG, contraintes);
		
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		centerPanel.add(labelNom, contraintes);
		
		contraintes.gridx = 1;
		centerPanel.add(champNom, contraintes);
		
		contraintes.gridx = 5;
		contraintes.gridy = 3;
		centerPanel.add(labelPrenom, contraintes);
		
		contraintes.gridx = 6;
		contraintes.gridy = 3;
		centerPanel.add(champPrenom, contraintes);
		
		contraintes.gridx= 0;
		contraintes.gridy= 5;
		centerPanel.add(labelNaissance, contraintes);
		
		contraintes.gridx = 1;
		centerPanel.add(champNaissance, contraintes);
		
		inscriptionJ.add(centerPanel, BorderLayout.CENTER);
		
		/*le panneau est*/
		JPanel estPanel = new JPanel(new FlowLayout());
		ajouterB = new JButton ("Ajouter");
		annulerB = new JButton ("Annuler");
		
		estPanel.add(ajouterB);
		estPanel.add(annulerB);
		estPanel.setBackground(Color.white);
		
		inscriptionJ.add(estPanel, BorderLayout.EAST);
		
		
		
		
		
		
		
		
		
		
		
	}
	/* changement d'image classe interne*/
	class comboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				String chang = (String) comboBoxGenre.getSelectedItem();
				if("Masculin".equals(chang)) {
					imageLabelG.setIcon(male);
				}else {
					imageLabelG.setIcon(female);
				}
		}
	}
		
		
		
	

	}
