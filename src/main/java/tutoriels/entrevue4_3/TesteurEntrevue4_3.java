package tutoriels.entrevue4_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tutoriels.core.performance_app.PerformanceTestsDriver;
import tutoriels.core.performance_app.TestParameters;

public class TesteurEntrevue4_3 extends PerformanceTestsDriver {

	private static Random random = new Random();

	@Override
	public TestParameters getTestParametersFor(String providerMethodPrefix, String methodName) {
		
		TestParameters testsParameters = null;

		if(methodName.equals("melanger")) {
			
			testsParameters = new TestParameters((int) 1E3, (int) 1E4*5, 30, 10, false);
		}
		
		return testsParameters;
	}

	@Override
	public List<Object> generateArgumentsFor(String providerMethodPrefix, String methodName, int desiredInputSize) {
		
		List<Object> arguments = new ArrayList<>();
		
		if(methodName.equals("melanger")) {

			Tableau<Integer> tableau = sortedArray(desiredInputSize);
			arguments.add(tableau);
		}

		return arguments;
	}

	public static Tableau<Integer> sortedArray(int size){
		
		
		Integer[] result = new Integer[size];
		
		result[0] = random.nextInt(1);
		
		for(int i = 1; i < size; i++) {
			result[i] = result[i-1] + random.nextInt(5);
		}
		
		return new MonTableau<>(result);
	}

	@Override
	public List<Object> adaptArgumentsFor(Object providedObject, String methodName, List<Object> arguments) {
		return arguments;
	}

	@Override
	public List<String> desiredMethodOrder() {
		return new ArrayList<String>();
	}


}
