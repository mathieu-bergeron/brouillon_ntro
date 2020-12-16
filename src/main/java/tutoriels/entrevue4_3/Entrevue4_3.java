package tutoriels.entrevue4_3;

import tutoriels.core.app.Atelier;
import tutoriels.core.app.InitializerExercise;
import tutoriels.core.performance_app.PerformanceTestsDriver;

public abstract class Entrevue4_3 extends Atelier {

	static {

		new InitializerExercise().initialize(Entrevue4_3.class);
	}

	@Override 
	public boolean siExecutable() {return false;}

	@Override 
	public void executer() {}

	@Override
	public PerformanceTestsDriver createPerformanceTestsDriver() {
		return new TesteurEntrevue4_3();
	}

	public abstract <C extends Comparable<C>> Melangeur<C> fournirMelangeurNaif();
	public abstract <C extends Comparable<C>> Melangeur<C> fournirMelangeurEfficace();

}
