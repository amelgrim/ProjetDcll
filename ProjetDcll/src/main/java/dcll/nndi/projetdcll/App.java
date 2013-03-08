package dcll.nndi.projetdcll;

public class App {
	public static void main(String[] args) {
		System.out.println( "Conversion JSON To XML " );   
		Json_To_Xml convjsonxml=new Json_To_Xml();
		convjsonxml.convertJsonToXml("fichier.json","sortie.xml"); 
}
