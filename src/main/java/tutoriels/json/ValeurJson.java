package tutoriels.json;

@SuppressWarnings("rawtypes")
public abstract class ValeurJson<V extends Object> implements Chargeable {
	
	public abstract V valeurJava();

	@Override
	public boolean equals(Object autreObjet) {
		boolean siEgal = false;

		if(autreObjet instanceof ValeurJson) {
			ValeurJson autreValeurJson = (ValeurJson) autreObjet;
			
			if(valeurJava() == autreValeurJson.valeurJava()) {
				siEgal = true;
			}else if(valeurJava() != null) {
				siEgal = valeurJava().equals(autreValeurJson.valeurJava());
			}
		}

		return siEgal;
	}

	@Override
	public String toString() {
		return String.format("%s", valeurJava());
	}

}
