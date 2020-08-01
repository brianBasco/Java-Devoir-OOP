package exercice3;

public class Nombre implements Calculable {

	private double nb;
	
	public Nombre(double nb) {
		this.nb = nb;
	}
	
	@Override
	public void afficher() {
		System.out.println(this);
	}

	@Override
	public double calculer() {
		return this.nb;

	}
	
	@Override
	public String toString() {
		return String.format("%s", nb);
	}

}
