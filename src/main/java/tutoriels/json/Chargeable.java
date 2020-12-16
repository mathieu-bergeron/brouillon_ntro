package tutoriels.json;

public interface Chargeable {

	String chargerEtRetournerResteDuTexte(ChargeurJson chargeur, String texteJson) throws ErreurDeChargement;

}
