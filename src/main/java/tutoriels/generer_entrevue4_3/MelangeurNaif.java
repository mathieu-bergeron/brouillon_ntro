package tutoriels.generer_entrevue4_3;

import java.util.Random;

import tutoriels.entrevue4_3.Melangeur;
import tutoriels.entrevue4_3.MonTableau;
import tutoriels.entrevue4_3.Tableau;

public class MelangeurNaif<C extends Comparable<C>> implements Melangeur<C> {
	
	private Random alea = new Random();

	@Override
	public Tableau<C> melanger(Tableau<C> entree) {
		Tableau<C> resultat = new MonTableau<>();
		
		while(!entree.siVide()) {
			
			C valeur = entree.obtenirValeur(alea.nextInt(entree.longueur()));
			
			resultat.ajouter(valeur);
			
			entree.retirer(valeur);
		}

		return resultat;
	}

}
