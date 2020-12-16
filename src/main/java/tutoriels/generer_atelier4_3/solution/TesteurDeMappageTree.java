package tutoriels.generer_atelier4_3.solution;

import java.util.Map;
import java.util.TreeMap;

public class TesteurDeMappageTree extends TesteurDeMappageAbstrait {

	@Override
	public Map<String, Integer> nouveauMap() {
		return new TreeMap<>();
	}

	@Override
	public void accederAuClesDansOrdre(Map<String, Integer> map, int nombreOperations) {
		for(String cle : map.keySet()) {
			System.out.println("TREE: " + cle);
		}
	}

}
