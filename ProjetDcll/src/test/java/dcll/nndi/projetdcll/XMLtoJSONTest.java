package dcll.nndi.projetdcll;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**test de la classe XMLtoJSON
 * @author Ndèye Mariane NDIAYE & Mohamed Amine LOUHIDI
 */

public class XMLtoJSONTest {
	private XMLtoJSON testfic=null;
	@Before
	public void setUp() throws Exception {
		testfic=new XMLtoJSON();
	}

	@After
	public void tearDown() throws Exception {
		testfic=null;
	}

	@Test
	/**
	 * test de la methode permettant de parser le fichier au format json
	 * on fait appel à la methode convertXmlToJson puis on verifie que le 
	 * fichier contenant le resultat a bien été crée
	 * @throws XMLStreamException
	 * @throws IOException
	 */
	public void testconvertXmlToJson() throws XMLStreamException, IOException {
		
		testfic.convertXmlToJson("ExempleXml.xml");
		 File dir = new File("ConversionXMLToJSON.json");
		assertTrue(dir.isFile());
	}

}
