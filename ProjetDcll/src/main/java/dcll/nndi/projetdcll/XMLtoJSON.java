package dcll.nndi.projetdcll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLOutputFactory;

/**
 * convertir un fichier du format Moodle_XML au format JSON utilisation de l'API
 * StAX
 * 
 * @author Ndèye Mariane NDIAYE & Mohamed Amine LOUHIDI *
 */

public class XMLtoJSON {

	/**
	 * Méthode effectuant le parse d'un fichier du format Moodle XML au format
	 * Json Le resulat de la conversion est redirigé dans le fichier
	 * ConversionXMLToJSON.json
	 * 
	 * @param ficXml
	 *            nom du fichier XML à parser en Json
	 * @throws XMLStreamException
	 * @throws IOException
	 */
	public void convertXmlToJson(String ficXml) throws XMLStreamException,
			IOException {
		InputStream input = XMLtoJSON.class.getResourceAsStream(ficXml);
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(
				"ConversionXMLToJSON.json")));
		/*
		 * Mise en place de la configuration du parseur Json to XML
		 */
		JsonXMLConfig config = new JsonXMLConfigBuilder().autoArray(true)
				.autoPrimitive(true).prettyPrint(true).build();
		try {
			/*
			 * Création d'un lecteur de fichier XML qui va lire le fichier xml
			 * recu en entrée
			 */
			XMLEventReader reader = XMLInputFactory.newInstance()
					.createXMLEventReader(input);

			/*
			 * Création d'un ecrivain de fichier JSON qui se chargera de
			 * traduire le fichier XML au format Json .
			 */
			XMLEventWriter writer = new JsonXMLOutputFactory(config)
					.createXMLEventWriter(output);

			/*
			 * Copie des événements du lecteur à l'écrivain.
			 */
			writer.add(reader);

			/*
			 * Fermeture du lecteur et de l'écrivain.
			 */
			reader.close();
			writer.close();
		} finally {
			/*
			 * Fermeture du fichier dans lequel se trouve le resultat du
			 * traitement effectué. Fermeture également du fichier qui a été
			 * parsé.
			 */
			output.close();
			input.close();
		}
	}
}
