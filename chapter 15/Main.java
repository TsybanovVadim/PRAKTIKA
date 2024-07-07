import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) throws Exception {
        Source xsltSource = new StreamSource(new File("medications.xsl"));
        Source xmlSource = new StreamSource(new File("medications.xml"));

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsltSource);

        StreamResult result = new StreamResult(new FileWriter("medications.html"));
        transformer.transform(xmlSource, result);

    }
}