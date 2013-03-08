package dcll.nndi.projetdcll;


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
}
