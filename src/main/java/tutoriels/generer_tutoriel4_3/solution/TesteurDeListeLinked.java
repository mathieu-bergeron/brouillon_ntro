package tutoriels.generer_tutoriel4_3.solution;

import java.util.LinkedList;
import java.util.List;

public class TesteurDeListeLinked extends TesteurDeListeAbstrait {

	@Override
	public List<Integer> nouvelleListe() {
		return new LinkedList<>();
	}
}
