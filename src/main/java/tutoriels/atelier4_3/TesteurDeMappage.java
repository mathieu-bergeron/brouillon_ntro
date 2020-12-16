package tutoriels.atelier4_3;

import java.util.Map;

public interface TesteurDeMappage {

	Map<String, Integer> nouveauMap();

	void fairePlusieursAjoutsAleatoires(Map<String, Integer> map, String[] cles, int nombreOperations);

	void fairePlusieursModificationsAleatoires(Map<String, Integer> map, String[] cles, int nombreOperations);

	void fairePlusieursRetraitsAleatoires(Map<String, Integer> map, String[] cles, int nombreOperations);

	void accederAuClesDansOrdre(Map<String, Integer> map, int nombreOperations);

}
