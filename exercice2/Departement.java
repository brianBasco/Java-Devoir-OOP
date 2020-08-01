package exercice2;

import java.util.HashSet;

/**
 * 
 * @author bast
 * 
 * utilisation de HashSet pour éviter l'ajout de doublons dans
 * les départements limitrophes
 *
 */
public class Departement {

	private int numero;
	private String nom;
	private HashSet<Departement> limitrophes;
	
	public Departement(int numero, String nom) {
		this.numero = numero;
		this.nom = nom;
		this.limitrophes = new HashSet<Departement>();	
	}
	
	public void ajouterLimitrophe(Departement limitrophe) {
		
		this.ajouter(limitrophe);
		limitrophe.ajouter(this);
	}
	
	private void ajouter(Departement dp) {
		this.limitrophes.add(dp);
	}
	
	public void afficher() {
		System.out.println("Cartographie du : " + this);
		afficherLimitrophes();
	}
	
	private void afficherLimitrophes() {
		if(!limitrophes.isEmpty()) {
			System.out.println("Limitrophes : ");
			for(Departement dp : limitrophes) {
				System.out.println(dp);
			}
			System.out.println();
		}
	}
	
	@Override
	public String toString() {
		return String.format("dpt[%s,%s]", numero, nom);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	//Comparaison sur le numero de département
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Departement))
			return false;
		Departement other = (Departement) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		Departement gironde = new Departement(33, "gironde");
		Departement dordogne = new Departement(47, "dordogne");
		Departement charente = new Departement(16, "charentes");
		
		gironde.ajouterLimitrophe(charente);
		gironde.ajouterLimitrophe(dordogne);
		
		gironde.afficher();
		dordogne.afficher();
	}
	
}
