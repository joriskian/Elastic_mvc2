package service;

import java.util.ArrayList;
import java.util.List;

import bean.BlocFiltre;
import bean.LigneFiltre;

/**
 * 
 * @author bruno
 *
 *         Class regroupant les 3 filtres : Fam, SSFam, Marque remplir filtres,
 *         et lignes de CB
 *
 */
public class ServicesFiltres {

	public static final int FAMILLE = 0;
	public static final int SSFAMILLE = 1;
	public static final int MARQUE = 2;

	private static List<BlocFiltre> filtres = new ArrayList<BlocFiltre>();

	public static void init() {
		BlocFiltre monBloc1 = new BlocFiltre("Famille");

		for (int i = 0; i < 10; i++) {
			monBloc1.addLigne(new LigneFiltre(i, "famille" + 1, false));
		}

		filtres.add(monBloc1);

	}

	public static List<BlocFiltre> getFiltres() {
		return filtres;

	}

	public static List<LigneFiltre> getFamille() {
		List<LigneFiltre> liste = new ArrayList<LigneFiltre>();
		for (int i = 0; i < 10; i++) {
			liste.add(new LigneFiltre(i, "famille" + 1, false));
		}
		return liste;
	}
}
