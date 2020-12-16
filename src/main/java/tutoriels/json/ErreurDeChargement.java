package tutoriels.json;

public class ErreurDeChargement extends Exception {
	private static final long serialVersionUID = -2479336672646901036L;
	
	public ErreurDeChargement(String message) {
		super(message);
	}
}
