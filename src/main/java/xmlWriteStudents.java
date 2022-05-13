import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class xmlWriteStudents {
    public static void saveToXml(ArrayList<Students> students,String file){
        try{
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("students");
            document.appendChild(rootElement);

            for(Students student: students){
                Element studentElement = document.createElement("student");

                rootElement.appendChild(studentElement);

                createChildElement(document,studentElement,"name",student.getName());
                createChildElement(document,studentElement,"birthPlace",student.getBirthPlace());
                createChildElement(document,studentElement,"birthDate",student.getBirthDate());
                createChildElement(document,studentElement,"address",student.getAddress());
                createChildElement(document,studentElement,"phoneNumber",student.getPhoneNumber());
                createChildElement(document,studentElement,"email",student.getEmail());
                createChildElement(document,studentElement,"nameOfCaretaker",student.getNameOfCaretaker());
                createChildElement(document,studentElement,"numberOfCaretaker",student.getNumberOfCaretaker());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(file));
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.transform(source,result);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void createChildElement(Document document, Element parent, String tagName, String text) {
        Element element = document.createElement(tagName);
        element.setTextContent(text);
        parent.appendChild(element);
    }
}
