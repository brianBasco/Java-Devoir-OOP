package exercice3;


public class Log implements Calculable {

	private Calculable nb;
	
	public Log(Calculable nb) {
		this.nb = nb;
	}
	
	@Override
	public void afficher() {
		System.out.println("Log(" + nb + ")");
	}

	@Override
	public double calculer() {
		return Math.log10(nb.calculer());		
	}
	
	@Override
	public String toString() {
		return "Log(" + nb + ")";
	}

}
