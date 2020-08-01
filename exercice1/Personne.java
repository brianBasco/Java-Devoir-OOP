package exercice1;
import java.util.ArrayList;

class MineurException extends Exception {

	private static final long serialVersionUID = 1L;

}

class DejaMarieException extends Exception {

	private static final long serialVersionUID = 1L;

}

class PasMarieException extends Exception {

	private static final long serialVersionUID = 1L;

}


class MemeSexeException extends Exception {

	private static final long serialVersionUID = 1L;
	
}


public class Personne {
	

	private String nom;
	private int age;
	private char sexe;
	private Personne conjoint;
	private final Personne mere;
	private final Personne pere;
	private ArrayList<Personne> enfants;

	public Personne(String nom, int age, char sexe, Personne mere, Personne pere) {
		this.nom = nom;
		this.age = age;   
		this.sexe = sexe;
		this.mere = mere;
		this.pere = pere;
		this.enfants = new ArrayList<Personne>();
		//Vérification que les parents soient connus
		if(this.pere != null ) this.pere.ajouterEnfant(this);
		if(this.mere != null ) this.mere.ajouterEnfant(this);
	}
	
	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {
	this.nom = nom;
	}
    
    
	public void setAge(int age) {
	this.age = age;
	}
    
    
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}


	public int getAge() {
		return age;
	}

	public char getSexe() {
		return sexe;
	}

	public Personne getConjoint() {
		return conjoint;
	}

	private void setConjoint(Personne conjoint) {
		this.conjoint = conjoint;
	}

	public void marier(Personne p) throws MineurException, DejaMarieException, MemeSexeException {

		if (getSexe() == p.getSexe())
			throw new MemeSexeException();
		if (getAge() < 18 || p.getAge() < 18)
			throw new MineurException();
		if (getConjoint() != null || p.getConjoint() != null)
			throw new DejaMarieException();
		this.setConjoint(p);
		p.setConjoint(this);
	}

	public void divorcer() throws PasMarieException {
		if (getConjoint() == null)
			throw new PasMarieException();
		conjoint.setConjoint(null);
		this.conjoint = null;		
	}
	
	//devoir	
	//question 2
	public Personne getMere() {
		return this.mere;
	}
	
	public Personne getPere() {
		return this.pere;
	}
	
	public ArrayList<Personne> getGrandsParents() {
		
		ArrayList<Personne> tab = new ArrayList<>();		
		tab.add(mere.getMere());
		tab.add(mere.getPere());
		tab.add(pere.getMere());
		tab.add(pere.getPere());
		return tab;
	}
	
	//Question 3.
	//Ajoutez à chaque personne une structure de données pour mémoriser les enfants.
	public ArrayList<Personne> getEnfants() {
		return this.enfants;
	}
	
	public void ajouterEnfant(Personne enfant) {
		//contrôle de l'ajout de doublons
		//on aurait pû utiliser un HashSet pour éviter le contrôle
		for(Personne e  : getEnfants()) {
			if(enfant.equals(e)) return;
		}
		getEnfants().add(enfant);
	}
	
	public void afficherEnfants() {
		for (Personne e : getEnfants()) {
			System.out.println(e);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((conjoint == null) ? 0 : conjoint.hashCode());
		//result = prime * result + ((enfants == null) ? 0 : enfants.hashCode());
		result = prime * result + ((mere == null) ? 0 : mere.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pere == null) ? 0 : pere.hashCode());
		result = prime * result + sexe;
		return result;
	}

	//comparaison avec equals sur tous les attributs
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Personne))
			return false;
		Personne other = (Personne) obj;
		if (age != other.age)
			return false;
		if (conjoint == null) {
			if (other.conjoint != null)
				return false;
		} else if (!conjoint.equals(other.conjoint))
			return false;
		if (enfants == null) {
			if (other.enfants != null)
				return false;
		} else if (!enfants.equals(other.enfants))
			return false;
		if (mere == null) {
			if (other.mere != null)
				return false;
		} else if (!mere.equals(other.mere))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pere == null) {
			if (other.pere != null)
				return false;
		} else if (!pere.equals(other.pere))
			return false;
		if (sexe != other.sexe)
			return false;
		return true;
	}
	
	public String toString() {
		return String.format("[%s, %s]", nom, age);
	}
	
}


