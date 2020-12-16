package tutoriels.generer_atelier4_3.solution;

import java.util.Map;
import java.util.Random;

import tutoriels.atelier4_3.TesteurDeMappage;

public abstract class TesteurDeMappageAbstrait implements TesteurDeMappage {
	
	private static final Random alea = new Random();

	@Override
	public void fairePlusieursAjoutsAleatoires(Map<String, Integer> map, String[] cles, int nombreOperations) {
		for(int i = 0; i < cles.length; i++) {
			map.put(cles[i],alea.nextInt(cles.length));
		}
	}

	@Override
	public void fairePlusieursModificationsAleatoires(Map<String, Integer> map, String[] cles, int nombreOperations) {
		for(int i = 0; i < cles.length; i++) {
			map.put(cles[i],alea.nextInt(cles.length));
		}
	}

	@Override
	public void fairePlusieursRetraitsAleatoires(Map<String, Integer> map, String[] cles, int nombreOperations) {
		for(int i = 0; i < cles.length; i++) {
			map.remove(cles[i]);
		}
	}


}
