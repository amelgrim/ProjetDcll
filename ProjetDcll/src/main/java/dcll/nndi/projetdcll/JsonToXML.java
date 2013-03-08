package dcll.nndi.projetdcll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;

/**
 * Cette classe permet de convertir un fichier json en un fichier xml.
 * @author abddiallo amelGrim
 *
 */
@SuppressWarnings("restriction")
public class JsonToXML {

    /**
     * Copy/format JSON as XML using {@link XMLEventWriter#add(XMLEventReader)}.
     * @param ficJson
     *            le fichier json a convertir
     * @param sortie
     *            le fichier genere (converti)
     * @throws XMLStreamException
     *            capture de lexception xmlstream
     */
    public void convertJsonToXml(final String ficJson, final String sortie)
            throws Exception {

        /*
         * On recupere le fichier json a convertir
         */
        InputStream input = JsonToXML.class.getResourceAsStream(ficJson);

        /*
         * On redirige la sortie standard sur le second parametre de la methode
         */

        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(
                sortie)));

        /*
         * On configure le build de xml et json
         */

        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false)
                .build();

        try {
            /*
             * On cree le lecteur json
             */
            XMLEventReader reader = new JsonXMLInputFactory(config)
                    .createXMLEventReader(input);

            /*
             * On cree le redacteur du xml
             */
            XMLEventWriter writer = XMLOutputFactory.newInstance()
                    .createXMLEventWriter(output);
            writer = new PrettyXMLEventWriter(writer); // format output

            /*
             * On copie les events du fichier xml dans le fichier json.
             */
            writer.add(reader);

            /*
             * On ferme les fichiers xml et json.
             */
            reader.close();
            writer.close();
        } finally {
            /*
             * On ferme les streams dans tous les cas meme s'il y a une
             * exception
             */
            output.close();
            input.close();
        }
    }

}
