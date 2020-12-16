package tutoriels.atelier4_3;

import tutoriels.core.app.Atelier;
import tutoriels.core.app.InitializerExercise;
import tutoriels.core.performance_app.PerformanceTestsDriver;

public abstract class Atelier4_3 extends Atelier {

	static {

		new InitializerExercise().initialize(Atelier4_3.class);
	}

	@Override 
	public boolean siExecutable() {return false;}

	@Override 
	public void executer() {}

	@Override
	public PerformanceTestsDriver createPerformanceTestsDriver() {
		return new TesteurAtelier4_3();
	}
	
	public abstract TesteurDeMappage fournirTesteurHash();
	public abstract TesteurDeMappage fournirTesteurTree();
	

}
