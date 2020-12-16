package tutoriels.generer_atelier4_3.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TesteurDeMappageHash extends TesteurDeMappageAbstrait {

	@Override
	public Map<String, Integer> nouveauMap() {
		return new HashMap<>();
	}

	@Override
	public void accederAuClesDansOrdre(Map<String, Integer> map, int nombreOperations) {
		List<String> cles = new ArrayList<>();
		cles.addAll(map.keySet());

		Collections.sort(cles);

		for(String cle : cles) {
			System.out.println("MAP: " + cle);
		}
	}

}
