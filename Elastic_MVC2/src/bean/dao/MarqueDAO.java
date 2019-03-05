package bean.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Marque;

public class MarqueDAO implements DAO<Marque> {

	public Marque create(Marque obj) {
		return null;
	}

	public Marque delete(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marque update(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marque find(int id) {
		Marque marque = null;

		// requete
		String requete = ("SELECT * FROM fabricant WHERE ID_FABRICANT = " + id);

		try {

			// connexion à la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet marque avec les donnees trouvees
			if (result.first()) {
				marque = new Marque(id, result.getString("NOM_FABRICANT"));
				System.out.println("objet trouve");
			}
			// puis fermeture de la connexion

			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marque;
	}

	@Override
	public List<Marque> findAll() {
		ArrayList<Marque> listeMarque = new ArrayList<Marque>();

		String requete = "SELECT ID_FABRICANT FROM fabricant ORDER BY ID_FABRICANT";

		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que...
			while (result.next()) {
				listeMarque.add(this.find(result.getInt("ID_FABRICANT")));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMarque;
	}

}
