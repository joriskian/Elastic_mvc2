package bean;

public class Marque {

	private int id;
	private String label;

	/**
	 * Constructeur sans paramètre
	 */
	public Marque() {
	}

	/**
	 * Constructeur qui cree l'objet en lui attribuant un nom
	 * 
	 * @param nomMarque
	 */
	public Marque(String nomMarque) {
		this.label = nomMarque;
	}

	/**
	 * Constructeur avec tous les attributs comme parametre
	 * 
	 * @param id, nomMarque
	 */
	public Marque(int id, String nomMarque) {
		this.id = id;
		this.label = nomMarque;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label le label à introduire
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public String toString() {
		return this.id + " - " + this.label + " - ";
	}
}
