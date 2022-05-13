import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
public class xmlReadStudents {
    public static ArrayList<Students> readStudentsFromXml(String filepath){

        ArrayList<Students> students = new ArrayList<>();

        try{
            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(filepath);

            Element rootElement = document.getDocumentElement();

            NodeList childNodeList = rootElement.getChildNodes();
            Node node;          //Parent of element class

            for (int i = 0; i < childNodeList.getLength(); i++){
                node = childNodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    NodeList childNodesOfStudentTagList = node.getChildNodes();

                    String name ="", birthPlace="",birthDate="", address="", phoneNumber="",
                           email ="", nameOfCaretaker ="", numberOfCaretaker="";


                    for (int j = 0; j < childNodesOfStudentTagList.getLength(); j++) {

                        Node childNodeOfStudentTagNode = childNodesOfStudentTagList.item(j);

                        if (childNodeOfStudentTagNode.getNodeType() == Node.ELEMENT_NODE){
                            switch (childNodeOfStudentTagNode.getNodeName()){

                                case "name" -> name = childNodeOfStudentTagNode.getTextContent();
                                case "birthPlace" -> birthPlace = childNodeOfStudentTagNode.getTextContent();
                                case "birthDate" -> birthDate = childNodeOfStudentTagNode.getTextContent();
                                case "address" ->  address = childNodeOfStudentTagNode.getTextContent();
                                case "phoneNumber" -> phoneNumber = childNodeOfStudentTagNode.getTextContent();
                                case "email" -> email = childNodeOfStudentTagNode.getTextContent();
                                case "nameOfCaretaker" -> nameOfCaretaker = childNodeOfStudentTagNode.getTextContent();
                                case "numberOfCaretaker" -> numberOfCaretaker = childNodeOfStudentTagNode.getTextContent();
                            }
                        } //End of inner if (TagNode)
                    } //End of for j

                    students.add(new Students(
                            name, birthPlace, birthDate, address,
                            phoneNumber, email, nameOfCaretaker,
                            numberOfCaretaker)
                    );

                } //End of outer if (TagList)
            } //End of for i
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
