package tutoriels.entrevue4_3;

public interface Tableau<C extends Comparable<C>> {

	boolean siVide();
	
	int longueur();

	C obtenirValeur(int indice);

	void modifierValeur(int indice, C nouvelleValeur);

	void ajouter(C nouvelleValeur);

	//void ajouterTout(Tableau<C> tableau);

	//void insererApres(int indice, C nouvelleValeur);

	void retirer(int indice);

	void retirer(C valeur);
	
	Tableau<C> cloner();

	//Tableau<C> sousTableau(int indiceDebut, int indiceFin);
}
