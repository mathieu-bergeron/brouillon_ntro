package tutoriels.generer_tutoriel4_3.solution;

import tutoriels.tutoriel4_3.TesteurDeListe;
import tutoriels.tutoriel4_3.Tutoriel4_3;

public class SolutionTutoriel4_3 extends Tutoriel4_3 {
	
	public static void main(String[] args) {
		
		new SolutionTutoriel4_3().valider();
	}

	@Override
	public TesteurDeListe fournirTesteurDeListeArray() {
		return new TesteurDeListeArray();
	}

	@Override
	public TesteurDeListe fournirTesteurDeListeLinked() {
		return new TesteurDeListeLinked();
	}

	/*
	@Override
	public TesteurDeListe fournirTesteurDeListeNaive() {
		return new TesteurDeListeNaive();
	}*/

}
