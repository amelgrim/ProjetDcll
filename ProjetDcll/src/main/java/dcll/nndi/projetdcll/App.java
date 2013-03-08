package dcll.nndi.projetdcll;

/**
 * App est la classe permettant de lancer la conversion d'un fichier au format
 * Moodle XML au format Json et inversement.
 * @author Ndèye Mariane NDIAYE & Mohamed Amine LOUHIDI
 */
public class App {
	/**1.On crait une instance de la classe effectuant la conversion souhaitée
	 * 2.On fait appel à la méthode permettant d'effectuer le parse en lui
	 * donnant en paramètre le fichier à traiter 3.On exécute le code 4.On
	 * raffraichit le projet 5.Le resultat de la conversion pourra être 
	 * consulté dans le fichier créé apres execution.
	 * ConversionXMLToJSON.json pour une conversion de Moodle XML à Json
	 * @param args
	 * @throws Exception
	 */
	public App(){}
	public static void main(String[] args) throws Exception {
		XMLtoJSON testXml = new XMLtoJSON();
		testXml.convertXmlToJson("ExempleXml.xml");
		System.out.println("Conversion XML To JSON : resultat disponible dans"+
				" le fichier ConversionXMLToJSON.json");
	}
}
