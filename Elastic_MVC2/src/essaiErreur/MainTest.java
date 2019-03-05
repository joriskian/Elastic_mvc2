package essaiErreur;

import java.util.ArrayList;

import bean.Filtre;
import service.MakingFiltre;

public class MainTest {

	public static void main(String[] args) {
//		// test pour la class MarqueDAO
//
//		MarqueDAO mDAO = new MarqueDAO();
//
//		ArrayList<Marque> listMarque = new ArrayList<Marque>();
//
//		listMarque = (ArrayList<Marque>) mDAO.findAll();
//		System.out.println(listMarque);
//
//		// test pour la class CouleurDAO
//		CouleurDAO cDAO = new CouleurDAO();
//		ArrayList<Couleur> listCouleur = new ArrayList<Couleur>();
//		listCouleur = (ArrayList<Couleur>) cDAO.findAll();
//		System.out.println(listCouleur);
////		Couleur couleur = new Couleur();
////		couleur = cDAO.find(5);
////		System.out.println(couleur);
//
////		//test pour la class FamilleDAO
////		FamilleDAO famDAO = new FamilleDAO();
////		ArrayList<Famille> listFamille = new ArrayList<Famille>();
////		
////		listFamille = (ArrayList<Famille>) famDAO.findAll();
////		System.out.println(listFamille);

//		//j'instancie une nouvelle list de filtre avec la methode init de la class MakingFiltre
//		ArrayList<Filtre> listFiltre = MakingFiltre.init();
//		
//		//j'affiche chaques filtres les uns sous les autres$
//		//separer par categorie
//		for(Filtre f:listFiltre) {
//			if(f.getCategory().contentEquals("famille")) {
//				System.out.println(f);
//			};
//		}
//			
//		for(Filtre s:listFiltre) {
//			if(s.getCategory().contentEquals("sous_famille")) {
//					System.out.println(s);
//			};
//
//		}
//		
//		for(Filtre s:listFiltre) {
//			if(s.getCategory().contentEquals("marque")) {
//					System.out.println(s);
//			};
//		}
		for (Filtre f : MakingFiltre.init(1)) {
			System.out.println(f.getCategory() + " " + f.getLabel());
		}

		for (Filtre f : MakingFiltre.init(0)) {
			System.out.println(f.getCategory() + " " + f.getLabel());
		}

		for (Filtre f : MakingFiltre.init(2)) {
			System.out.println(f.getCategory() + " " + f.getLabel());
		}

	}

}
