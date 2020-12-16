package tutoriels.generer_entrevue4_3;

import tutoriels.entrevue4_3.Entrevue4_3;
import tutoriels.entrevue4_3.Melangeur;

public class SolutionEntrevue4_3 extends Entrevue4_3 {
	
	public static void main(String[] args) {
		
		new SolutionEntrevue4_3().valider();
	}

	@Override
	public <C extends Comparable<C>> Melangeur<C> fournirMelangeurNaif() {
		return new MelangeurNaif<C>();
	}

	@Override
	public <C extends Comparable<C>> Melangeur<C> fournirMelangeurEfficace() {
		return new MelangeurEfficace<C>();
	}
}
