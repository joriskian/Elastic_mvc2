package bean.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Couleur;

public class CouleurDAO implements DAO<Couleur> {

	@Override
	public Couleur create(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur delete(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur update(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur find(int id) {
		Couleur couleur = null;
		
		//requete 
		String requete = ("SELECT * FROM couleur WHERE ID_COULEUR = " + id);

		try {
			
			//connexion à la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet marque avec les donnees trouvees
			if (result.first()) {
				couleur = new Couleur(id, result.getString("INTITULE_COULEUR"));
				System.out.println("objet trouve");
			}
			// puis fermeture de la connexion

			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return couleur;
	}

	@Override
	public List<Couleur> findAll() {
		ArrayList<Couleur> listeCouleur = new ArrayList<Couleur>();

		String requete = "SELECT ID_COULEUR FROM couleur ORDER BY ID_COULEUR";

		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que...
			while (result.next()) {
				listeCouleur.add(this.find(result.getInt("ID_COULEUR")));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeCouleur;
	}

	
}
