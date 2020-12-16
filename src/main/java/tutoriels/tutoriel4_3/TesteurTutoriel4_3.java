package tutoriels.tutoriel4_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import tutoriels.core.performance_app.PerformanceTestsDriver;
import tutoriels.core.performance_app.TestParameters;

public class TesteurTutoriel4_3 extends PerformanceTestsDriver {
	
	private static final Random alea = new Random();

	@Override
	public TestParameters getTestParametersFor(String providerMethodPrefix, String methodName) {

		TestParameters testsParameters = null;

		if(methodName.equals("fairePlusieursAjouts")) {
			
			testsParameters = new TestParameters((int) 1E6, (int) 1E7*2, 30, 0.6, true);

		} else if(methodName.equals("fairePlusieursInsertionsAuDebut")) {
			
			testsParameters = new TestParameters((int) 1E4, (int) 1E5, 30, 10.0, true);

		} else if(methodName.equals("fairePlusieursInsertionsAleatoires")) {
			
			testsParameters = new TestParameters((int) 1E4, (int) 1E5, 30, 20.0, true);

		} else if(methodName.equals("fairePlusieursModificationsAleatoires")) {
			
			testsParameters = new TestParameters((int) 1E4, (int) 1E5, 30, 10.0, true);

		} else if(methodName.equals("fairePlusieursRetraitsAleatoires")) {
			
			testsParameters = new TestParameters((int) 1E4, (int) 1E5, 30, 10.0, true);

		} else if(methodName.equals("fairePlusieursRetraitsAuDebut")) {
			
			testsParameters = new TestParameters((int) 1E4, (int) 1E5, 30, 3.0, true);
		}

		return testsParameters;
	}

	@Override
	public List<Object> generateArgumentsFor(String providerMethodPrefix, String methodName, int desiredInputSize) {
		List<Object> arguments = new ArrayList<>();

		if(methodName.equals("fairePlusieursAjouts")
				|| methodName.equals("fairePlusieursInsertionsAuDebut")
				|| methodName.equals("fairePlusieursInsertionsAleatoires")) {
			arguments.add(new ArrayList<>());
			arguments.add(desiredInputSize);

		} else if(methodName.equals("fairePlusieursModificationsAleatoires") 
				|| methodName.equals("fairePlusieursRetraitsAleatoires")
				|| methodName.equals("fairePlusieursRetraitsAuDebut")) {
			arguments.add(listeAleatoire(desiredInputSize));
			arguments.add(desiredInputSize);
		}

		return arguments;
	}
	
	private List<Integer> listeAleatoire(int taille){
		List<Integer> liste = new LinkedList<>();
		
		for(int i = 0; i < taille; i++) {
			liste.add(alea.nextInt(10));
		}
		
		return liste;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> adaptArgumentsFor(Object providedObject, String methodName, List<Object> arguments) {
		
		List<Object> adaptedArguments;

		if(methodName.equals("fairePlusieursAjouts") 
				|| methodName.equals("fairePlusieursInsertionsAleatoires") 
				|| methodName.equals("fairePlusieursModificationsAleatoires") 
				|| methodName.equals("fairePlusieursRetraitsAuDebut") 
				|| methodName.equals("fairePlusieursRetraitsAleatoires")) {
			
			adaptedArguments = new ArrayList<>();
			
			TesteurDeListe testeur = (TesteurDeListe) providedObject;
			
			List<Integer> listeAdaptee = testeur.nouvelleListe();
			List<Integer> listeOriginale = (List<Integer>) arguments.get(0);
			
			listeAdaptee.addAll(listeOriginale);
			
			adaptedArguments.add(listeAdaptee);
			adaptedArguments.add(arguments.get(1));

		}else {
			
			adaptedArguments = arguments;
			
		}

		return adaptedArguments;
	}

	@Override
	public List<String> desiredMethodOrder() {
		return new ArrayList<String>();
	}
}
