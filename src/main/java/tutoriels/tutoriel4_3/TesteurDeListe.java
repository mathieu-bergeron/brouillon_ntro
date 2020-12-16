package tutoriels.tutoriel4_3;

import java.util.List;

public interface TesteurDeListe {
	
	List<Integer> nouvelleListe();
	
	void fairePlusieursAjouts(List<Integer> liste, int nombreOperations);

	void fairePlusieursInsertionsAuDebut(List<Integer> liste, int nombreOperations);

	void fairePlusieursInsertionsAleatoires(List<Integer> liste, int nombreOperations);

	void fairePlusieursModificationsAleatoires(List<Integer> liste, int nombreOperations);

	void fairePlusieursRetraitsAleatoires(List<Integer> liste, int nombreOperations);

	void fairePlusieursRetraitsAuDebut(List<Integer> liste, int nombreOperations);

}
