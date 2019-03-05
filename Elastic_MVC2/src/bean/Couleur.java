package bean;

public class Couleur {
	//attributs
	private int id_couleur;
	private String intitule_couleur,hexa_rouge,hexa_vert,hexa_bleu,rvb_rouge, rvb_vert,rvb_bleu,ref_hexa;
	
	/**
	 * constructeur sans parametre
	 */
	public Couleur() {
	}
	
	/**
	 * constructeur qui créé l'objet en lui attribuant un nom
	 * @param intitule
	 * 			nom de la couleur
	 * 			
	 */
	public Couleur(String intitule) {
		this.intitule_couleur = intitule;
	}
	
	public Couleur(int i, String intitule) {
		this.id_couleur			=	i;
		this.intitule_couleur	=	intitule;
	}
	
	/**
	 * Constructeur avec tous les parametres
	 * @param i
	 * 			id_couleur
	 * @param intitule
	 * 			nom de la couleur
	 * @param hr
	 * 			hexa rouge
	 * @param hv
	 * 			hexa vert
	 * @param hb
	 * 			hexa bleu
	 * @param rr
	 * 			rvb rouge
	 * @param rv
	 * 			rvb	vert
	 * @param rb
	 * 			rvb bleu
	 * @param refHexa
	 * 			referende hexa decimal
	 */
	public Couleur(int i,String intitule,String hr,String hv,String hb,String rr, String rv, String rb, String refHexa) {
		this.id_couleur			=	i;
		this.intitule_couleur	=	intitule;
		this.hexa_rouge         =	hr;
		this.hexa_vert          =	hv;
		this.hexa_bleu          =	hb;
		this.rvb_rouge          =	rr;
		this.rvb_vert           =	rv;
		this.rvb_bleu           =	rb;
		this.ref_hexa           =	refHexa;
	}

	public int getId_couleur() {
		return id_couleur;
	}

	public void setId_couleur(int id_couleur) {
		this.id_couleur = id_couleur;
	}

	public String getIntitule_couleur() {
		return intitule_couleur;
	}

	public void setIntitule_couleur(String intitule_couleur) {
		this.intitule_couleur = intitule_couleur;
	}

	public String getHexa_rouge() {
		return hexa_rouge;
	}

	public void setHexa_rouge(String hexa_rouge) {
		this.hexa_rouge = hexa_rouge;
	}

	public String getHexa_vert() {
		return hexa_vert;
	}

	public void setHexa_vert(String hexa_vert) {
		this.hexa_vert = hexa_vert;
	}

	public String getHexa_bleu() {
		return hexa_bleu;
	}

	public void setHexa_bleu(String hexa_bleu) {
		this.hexa_bleu = hexa_bleu;
	}

	public String getRvb_rouge() {
		return rvb_rouge;
	}

	public void setRvb_rouge(String rvb_rouge) {
		this.rvb_rouge = rvb_rouge;
	}

	public String getRvb_vert() {
		return rvb_vert;
	}

	public void setRvb_vert(String rvb_vert) {
		this.rvb_vert = rvb_vert;
	}

	public String getRvb_bleu() {
		return rvb_bleu;
	}

	public void setRvb_bleu(String rvb_bleu) {
		this.rvb_bleu = rvb_bleu;
	}

	public String getRef_hexa() {
		return ref_hexa;
	}

	public void setRef_hexa(String ref_hexa) {
		this.ref_hexa = ref_hexa;
	}

	@Override
	public String toString() {
		return "Couleur [id_couleur=" + id_couleur + ", intitule_couleur=" + intitule_couleur + ", hexa_rouge="
				+ hexa_rouge + ", hexa_vert=" + hexa_vert + ", hexa_bleu=" + hexa_bleu + ", rvb_rouge=" + rvb_rouge
				+ ", rvb_vert=" + rvb_vert + ", rvb_bleu=" + rvb_bleu + ", ref_hexa=" + ref_hexa + "]";
	}
	

}
