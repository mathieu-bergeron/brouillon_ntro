package tutoriels.atelier4_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import tutoriels.core.performance_app.PerformanceTestsDriver;
import tutoriels.core.performance_app.TestParameters;

public class TesteurAtelier4_3 extends PerformanceTestsDriver {
	
	private static final Random alea = new Random();
	private static final int TAILLE_CLES = 128;
	private static final char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t', 'u', 'v','w','x', 'y', 'z',
			                                           'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T', 'U', 'V','W','X', 'Y', 'Z',
			                                           '0','1','2','3','4','5','6','7','8','9','_'};

	@Override
	public TestParameters getTestParametersFor(String providerMethodPrefix, String methodName) {

		TestParameters testsParameters = null;

		if(methodName.equals("fairePlusieursAjoutsAleatoires")) {
			
			testsParameters = new TestParameters((int) 1E5, (int) 1E6, 30, 3.0, true);

		} else if(methodName.equals("fairePlusieursModificationsAleatoires")) {
			
			testsParameters = new TestParameters((int) 1E5, (int) 1E6, 30, 10.0, true);

		} else if(methodName.equals("fairePlusieursRetraitsAleatoires")) {
			
			testsParameters = new TestParameters((int) 1E5, (int) 1E6, 30, 10.0, true);

		} else if(methodName.equals("accederAuClesDansOrdre")) {
			
			testsParameters = new TestParameters((int) 1E5, (int) 1E6, 30, 20.0, true);

		}

		return testsParameters;
	}

	@Override
	public List<Object> generateArgumentsFor(String providerMethodPrefix, String methodName, int desiredInputSize) {
		List<Object> arguments = new ArrayList<>();

		if(methodName.equals("fairePlusieursAjoutsAleatoires")) {

			arguments.add(new HashMap<>());
			arguments.add(clesAleatoires(desiredInputSize));
			arguments.add(desiredInputSize);

		} else if(methodName.equals("fairePlusieursModificationsAleatoires") 
				|| methodName.equals("fairePlusieursRetraitsAleatoires")) {
			
			String[] cles = clesAleatoires(desiredInputSize);

			arguments.add(mapAleatoire(cles));
			arguments.add(cles);
			arguments.add(desiredInputSize);

		} else if(methodName.equals("accederAuClesDansOrdre")) {

			String[] cles = clesAleatoires(desiredInputSize);

			arguments.add(mapAleatoire(cles));
			arguments.add(desiredInputSize);
		}

		return arguments;
	}

	private String[] clesAleatoires(int taille){
		
		String[] cles = new String[taille];
		
		for(int i = 0; i < taille; i++) {
			cles[i] = cleAleatoire(TAILLE_CLES);
		}
		
		return cles;
	}
	
	private String cleAleatoire(int tailleCle) {
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < tailleCle; i++) {
			builder.append(alphabet[alea.nextInt(alphabet.length)]);
		}
		
		return builder.toString();
	}
	
	private Map<String, Integer> mapAleatoire(String[] cles){
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < cles.length; i++) {
			map.put(cles[i], alea.nextInt(cles.length));
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> adaptArgumentsFor(Object providedObject, String methodName, List<Object> arguments) {
		
		List<Object> adaptedArguments;

		if(methodName.equals("fairePlusieursAjoutsAleatoires") 
				|| methodName.equals("fairePlusieursModificationsAleatoires") 
				|| methodName.equals("fairePlusieursRetraitsAleatoires") ) {
			
			adaptedArguments = new ArrayList<>();
			
			TesteurDeMappage testeur = (TesteurDeMappage) providedObject;
			
			Map<String, Integer> mapAdapte = testeur.nouveauMap();
			Map<String, Integer> mapOriginal = (Map<String, Integer>) arguments.get(0);
			
			mapAdapte.putAll(mapOriginal);

			adaptedArguments.add(mapAdapte);
			adaptedArguments.add(arguments.get(1));
			adaptedArguments.add(arguments.get(2));

		} else if(methodName.equals("accederAuClesDansOrdre") ) {
			
			adaptedArguments = new ArrayList<>();
			
			TesteurDeMappage testeur = (TesteurDeMappage) providedObject;
			
			Map<String, Integer> mapAdapte = testeur.nouveauMap();
			Map<String, Integer> mapOriginal = (Map<String, Integer>) arguments.get(0);
			
			mapAdapte.putAll(mapOriginal);

			adaptedArguments.add(mapAdapte);
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
