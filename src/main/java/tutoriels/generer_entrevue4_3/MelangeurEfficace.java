package tutoriels.generer_entrevue4_3;

import java.util.Random;

import tutoriels.entrevue4_3.Melangeur;
import tutoriels.entrevue4_3.MonTableau;
import tutoriels.entrevue4_3.Tableau;

public class MelangeurEfficace<C extends Comparable<C>> implements Melangeur<C> {
	
	private Random alea = new Random();

	@Override
	public Tableau<C> melanger(Tableau<C> entree) {
		
		Tableau<C> resultat = null;
		
		if(entree.longueur() <= 1) {
			
			resultat = entree;
			
		}else {

			resultat = melangerLongTableau(entree);

		}

		return resultat;
	}

	private Tableau<C> melangerLongTableau(Tableau<C> entree) {
		
		Tableau<C> resultat = null;
		
		int pivot = entree.longueur() / 2;
		
		Tableau<C> gauche = sousTableau(entree, 0, pivot);
		Tableau<C> droite = sousTableau(entree, pivot, entree.longueur());
		
		gauche = melanger(gauche);
		droite = melanger(droite);
		
		resultat = fusionner(gauche, droite);

		return resultat;
	}

	private Tableau<C> sousTableau(Tableau<C> tableau, int debutSegment, int finSegment){

		Tableau<C> resultat = new MonTableau<C>();
		
		for(int i = debutSegment; i < finSegment; i++) {
			resultat.ajouter(tableau.obtenirValeur(i));
		}
		
		return resultat;
	}

	private Tableau<C> fusionner(Tableau<C> gauche, Tableau<C> droite) {
		
		Tableau<C> resultat = new MonTableau<C>();
		
		while(!gauche.siVide() && !droite.siVide()) {
			if(alea.nextBoolean()) {
				resultat = deplacerPremierElement(gauche, resultat);
			}else {
				resultat = deplacerPremierElement(droite, resultat);
			}
		}
		
		if(!gauche.siVide()) {
			resultat = deplacerElementsRestants(gauche, resultat);
		}else {
			resultat = deplacerElementsRestants(droite, resultat);
		}
		
		return resultat;
	}

	private Tableau<C> deplacerPremierElement(Tableau<C> source, Tableau<C> destination) {
		destination.ajouter(source.obtenirValeur(0));
		source.retirer(0);
		
		return destination;
	}

	private Tableau<C> deplacerElementsRestants(Tableau<C> source, Tableau<C> destination) {
		while(!source.siVide()) {
			deplacerPremierElement(source, destination);
		}
		
		return destination;
	}

}
