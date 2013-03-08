package dcll.nndi.projetdcll;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;
/**
* cette classe permet de faire la conversion d'un fichier Json en un fichier Xml
* 1- elle prend comme paramètre un fichier Json et elle rend en sortie un fichier Xml
* 2-au début on récupère le fichier json passé en paramètre 
* 3-on crée un nouveau fichier de sortie, qui contiendra le xml généré
* 4-on configure le parseur json xml
* 5-on cree le lecteur json ainsi que le rédacteur xml
* 6-on recopie les events du fichier json dans le fichier xml
* 7-a la fin on ferme tous les fichiers et on ferme les input et output stream
*/

public class Json_To_Xml {
	/**
	 * Copy/format JSON as XML using {@link XMLEventWriter#add(XMLEventReader)}.
	 * @param ficJson : le fichier json a convertir
	 * @param sortie: le fichier genere
	 * @throws XMLStreamException
	 */
	public void convertJsonToXml(String ficJson,String sortie) throws Exception {
    	/*
		 * On recupere le fichier json a convertir
		 */
		InputStream input = Json_To_Xml.class.getResourceAsStream(ficJson);
		/*
		 * On redirige la sortie standard sur le second parametre de la methode
		 */
		PrintWriter  output =  new PrintWriter(new BufferedWriter(new FileWriter(sortie)));
		 /*
		   * On configure le build de xml et json 
		 */
		JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).build();
		try {
			/*
			 * On cree le lecteur json
			 */
			XMLEventReader reader = new JsonXMLInputFactory(config).createXMLEventReader(input);
			/*
			 * On cree le redacteur du xml
			 */
			XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(output);
			writer = new PrettyXMLEventWriter(writer); // format output
			/*
			 * On copie les events du fichier json dans le fichier xml.
			 */
			writer.add(reader);
			/*
			 * On ferme les fichiers xml et json.
			 */
			reader.close();
			writer.close();
		} finally {
			/*
			 * On ferme les streams dans tous les cas meme s'il y a une exception
			 */
			output.close();
			input.close();
		}
	}

}
