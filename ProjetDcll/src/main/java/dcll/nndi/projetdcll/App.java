package dcll.nndi.projetdcll;

<<<<<<< HEAD
/**
 * Classe pour tester les convertions.
 * @author abddiallo amelGrim
 */
public enum App {;
    /**
     * Methode static main qui permet de convertir un fichier json en xml a.
     * l'aide de la classe Json_To_Xml on appelle la methode qui permet de faire
     * la conversion
     * @param args
     *          les arguments de la methode main
     * @throws Exception
     *          lexception de la methode convertJsonToXml
     */
    public static void main(final String[] args) throws Exception {
        System.out.println("Conversion JSON To XML");
        JsonToXML convjsonxml = new JsonToXML();
        convjsonxml.convertJsonToXml("fichier.json", "sortie.xml");
    }
=======
public class App {
	public static void main(String[] args) {
		System.out.println( "Conversion JSON To XML " );   
		JsonToXML convjsonxml=new JsonToXML();
		convjsonxml.convertJsonToXml("fichier.json","sortie.xml"); 
>>>>>>> c8cd36f922930f8b13b8a38bce78cf257786fb8e
}
