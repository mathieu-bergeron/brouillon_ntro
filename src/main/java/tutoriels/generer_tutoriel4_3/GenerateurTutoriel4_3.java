package tutoriels.generer_tutoriel4_3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ca.ntro.core.system.debug.T;
import tutoriels.core.TestCaseGenerator;
import tutoriels.generer_tutoriel4_3.solution.SolutionTutoriel4_3;

public class GenerateurTutoriel4_3 extends TestCaseGenerator {

	static {
		// XXX: this provokes initialization
		new SolutionTutoriel4_3();
	}
	
	public static void main(String[] args) {
		T.call(GenerateurTutoriel4_3.class);

		TestCaseGenerator.generateTestCases(GenerateurTutoriel4_3.class, SolutionTutoriel4_3.class);
	}

	private Random random = new Random();

	@Override
	public List<List<Object>> generateMultipleInputArguments(String providerMethodName, Object providedObject,
			Method methodToTest) {
		
		System.out.println("METHOD" + methodToTest.getName());
		
		List<List<Object>> listOfInputArguments = new ArrayList<>();
		
		if(methodToTest.getName().equals("chargerValeur")) {

			String[] inputs = new String[] {"null", 
										    "true", 
										    "false", 
										    "23", 
										    "0", 
										    "0.234", 
										    "-2", 
										    "-3.34", 
										    "\"\"", 
										    "\"asdf\"",
											"[[]]", 
											"[]", 
											"[3,34,3]", 
											"[3,[3,4,3],3]", 
											"[3,[3,[4,3,2],3],3]", 
											"[3,[3,[4,3,2],3],[2,4]]", 
											"[-2.4,null,true,\"asdf\",\"\"]"}; 

			for(String input : inputs) {
				
				List<Object> arguments = new ArrayList<>();
				arguments.add(input);
				
				listOfInputArguments.add(arguments);
			}
			
		}

		else if(methodToTest.getName().equals("chargerListe")) {

			String[] inputs = new String[] {};
			
			for(String input : inputs) {
				
				List<Object> arguments = new ArrayList<>();
				arguments.add(input);
				
				listOfInputArguments.add(arguments);
			}
			
		}

		else if(methodToTest.getName().equals("resteDuTexteJson")) {
			
		}

		return listOfInputArguments;
	}
}
