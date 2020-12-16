package tutoriels.generer_entrevue4_3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ca.ntro.core.system.debug.T;
import tutoriels.core.TestCaseGenerator;
import tutoriels.entrevue4_3.Tableau;
import tutoriels.entrevue4_3.TesteurEntrevue4_3;

public class GenerateurEntrevue4_3 extends TestCaseGenerator {

	static {
		// XXX: this provokes initialization
		new SolutionEntrevue4_3();
	}
	
	public static void main(String[] args) {
		T.call(GenerateurEntrevue4_3.class);

		TestCaseGenerator.generateTestCases(GenerateurEntrevue4_3.class, SolutionEntrevue4_3.class);
	}

	@Override
	public List<List<Object>> generateMultipleInputArguments(String providerMethodName, Object providedObject,
			Method methodToTest) {
		
		List<List<Object>> listOfInputArguments = new ArrayList<>();
		
		if(methodToTest.getName().equals("melanger")) {
			
			//int maxSize = (int) 1E6;
			//int minSize = (int) 1E4;
			int maxSize = (int) 20;
			int minSize = (int) 4;
			int numberOfSamples = 10;
			int step = (maxSize - minSize) / numberOfSamples;
			
			for(int i = minSize; i < maxSize; i += step) {
				List<Object> arguments = new ArrayList<>();
				
				System.out.println("Generating for size: " + i);

				Tableau<Integer> tableau = TesteurEntrevue4_3.sortedArray(i);
				arguments.add(tableau);
				
				listOfInputArguments.add(arguments);
			;}
		}

		return listOfInputArguments;
	}
}
