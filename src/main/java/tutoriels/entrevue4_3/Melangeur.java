package tutoriels.entrevue4_3;

public interface Melangeur<C extends Comparable<C>> {
	
	Tableau<C> melanger(Tableau<C> entree);

}
