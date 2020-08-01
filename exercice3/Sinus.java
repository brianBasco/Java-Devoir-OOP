package exercice3;
/**
 *Précisions
 *<p>On suppose que l'utilisateur écrit en degrés.
 *Cependant, la méthode Math.sin(double) de JAVA
 *attend un double en radian.
 *Le DoubleC passé en paramètre dans le constructeur est ainsi converti en radians.
 *Ex : sin(90) retournera 1
 *</p> 
 */
public class Sinus implements Calculable {

	private Calculable nb, nbRad;
	
	public Sinus(Calculable nb) {
		//On suppose que l'utilisateur écrit en degrés.
		//transformation de nb en radians
		this.nb = nb;
		this.nbRad = new Nombre((nb.calculer() * Math.PI) / 180);
	}
	
	@Override
	public void afficher() {
		System.out.println("sin(" + nb + ")");
	}

	@Override
	public double calculer() {
				
		//prend un double (radian) en argument
		return Math.sin(nbRad.calculer());
	}
	
	@Override
	public String toString() {
		return "sin(" + nb + ")";
	};

}
