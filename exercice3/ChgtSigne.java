package exercice3;

public class ChgtSigne implements Calculable {

	private Calculable nb;
	
	public ChgtSigne(Calculable nb) {
		this.nb = nb;
	}
	
	@Override
	public void afficher() {
		System.out.println("-" + nb);
	}

	@Override
	public double calculer() {
		return -nb.calculer();
	}
	
	@Override
	public String toString() {
		return String.format("-%s", nb);
	}

}
