package dcll.nndi.projetdcll;

public class App {
	public static void main(String[] args) {
		System.out.println( "Conversion JSON To XML " );   
		JsonToXML convjsonxml=new JsonToXML();
		convjsonxml.convertJsonToXml("fichier.json","sortie.xml"); 
}
