package tutoriels.tutoriel4_3;

import tutoriels.core.app.Atelier;
import tutoriels.core.app.InitializerExercise;
import tutoriels.core.performance_app.PerformanceTestsDriver;

public abstract class Tutoriel4_3 extends Atelier {

	static {

		new InitializerExercise().initialize(Tutoriel4_3.class);
	}

	@Override 
	public boolean siExecutable() {return false;}

	@Override 
	public void executer() {}

	@Override
	public PerformanceTestsDriver createPerformanceTestsDriver() {
		return new TesteurTutoriel4_3();
	}
	
	//public abstract TesteurDeListe fournirTesteurDeListeNaive();
	public abstract TesteurDeListe fournirTesteurDeListeArray();
	public abstract TesteurDeListe fournirTesteurDeListeLinked();
	

}
