package service;

import java.util.ArrayList;

import bean.Famille;
import bean.Filtre;
import bean.Marque;
import bean.SousFamille;
import bean.dao.FamilleDAO;
import bean.dao.MarqueDAO;
import bean.dao.SousFamilleDAO;

public class MakingFiltre {
	// attributs

	// constructeur
	/**
	 * 
	 * @param choix 0 : famille 1 : sous famille 2 : marque
	 * @return
	 * 		une liste de filtre selon la categorie
	 */
	public static ArrayList<Filtre> init(int choix) {
		// j'instancie un nouvel objet filtre
		// Filtre filtre = new Filtre();

		// j'instancie une nouvelle ArrayList de Filtre
		ArrayList<Filtre> listFiltre = new ArrayList<Filtre>();

		switch (choix) {
		case 0:
			// je recupere tout les elements de la category
			// "Famille"--------------------------------
			// creation d'un objet liste pour recuperer les elements de la table famille
			FamilleDAO famDAO = new FamilleDAO();
			ArrayList<Famille> listFamille = (ArrayList<Famille>) famDAO.findAll();

			// je recupere les elements 1 par 1 (de type famille donc un id (int) et un nom
			// (String)
			for (Famille f : listFamille) {
				int i = 0;
				// je construit un objet filtre avec l'objet famille
				Filtre filtre = new Filtre();
				filtre.setId(i);
				filtre.setCategory("famille");
				// je n'affiche que l'intitulé pour le label
				filtre.setLabel(f.getIntitule());
				// par defaut unchecked
				filtre.setChecked(false);

				// j'ajoute cet objet dans ma liste de filtre
				listFiltre.add(filtre);
			}break;

		case 1:
			// je recupere tout les elements de la category
			// "SousFamille"--------------------------------
			// creation d'un objet liste pour recuperer les elements de la table famille
			SousFamilleDAO sFamDAO = new SousFamilleDAO();
			ArrayList<SousFamille> listSousFamille = (ArrayList<SousFamille>) sFamDAO.findAll();

			// je recupere les elements 1 par 1 (de type famille donc un id (int) et un nom
			// (String)
			for (SousFamille sf : listSousFamille) {
				int i = 0;
				// je construit un objet filtre avec l'objet famille
				Filtre filtre = new Filtre();
				filtre.setId(i);
				filtre.setCategory("sous_famille");
				// je n'affiche que l'intitulé pour le label
				filtre.setLabel(sf.getIntitule_ssFamille());
				// par defaut unchecked
				filtre.setChecked(false);

				// j'ajoute cet objet dans ma liste de filtre
				listFiltre.add(filtre);
			}break;

		case 2:
			// je recupere tout les elements de la category
			// "Marque"--------------------------------
			// creation d'un objet liste pour recuperer les elements de la table famille
			MarqueDAO marqueDAO = new MarqueDAO();
			ArrayList<Marque> listMarque = (ArrayList<Marque>) marqueDAO.findAll();

			// je recupere les elements 1 par 1 (de type famille donc un id (int) et un nom
			// (String)
			for (Marque m : listMarque) {
				int i = 0;
				// je construit un objet filtre avec l'objet famille
				Filtre filtre = new Filtre();
				filtre.setId(i);
				filtre.setCategory("marque");
				// je n'affiche que l'intitulé pour le label
				filtre.setLabel(m.getLabel());
				// par defaut unchecked
				filtre.setChecked(false);

				// j'ajoute cet objet dans ma liste de filtre
				listFiltre.add(filtre);
			}break;

		}

		// test console
		// System.out.println(listFiltre);
		return listFiltre;

	}

}
