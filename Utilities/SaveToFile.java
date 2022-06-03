package Lab_6.Utilities;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Lab_6.Collection.StudyGroup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;


/**
 * Command for saving to file
 */
public class SaveToFile{
    private HashSet<StudyGroup> groups;
    private File filename;

    public SaveToFile(HashSet<StudyGroup> groups){
        this.groups = groups;
        this.filename = new File("Result.xml");
    }

    public void activate() {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("groups");
            doc.appendChild(rootElement);
            for (StudyGroup studyGroup : groups) {
                Element group = doc.createElement("StudyGroup");
                rootElement.appendChild(group);
                Element group_name = doc.createElement("name");
                group_name.appendChild(doc.createTextNode(studyGroup.getName()));
                group.appendChild(group_name);
                Element coordinates = doc.createElement("coordinates");
                group.appendChild(coordinates);
                Element x = doc.createElement("x");
                Element y = doc.createElement("y");
                x.appendChild(doc.createTextNode(studyGroup.getCoordinates().getX().toString()));
                y.appendChild(doc.createTextNode(Float.toString(studyGroup.getCoordinates().getY())));
                coordinates.appendChild(x);
                coordinates.appendChild(y);
                Element count = doc.createElement("studentsCount");
                count.appendChild(doc.createTextNode(studyGroup.getStudentsCount().toString()));
                group.appendChild(count);
                Element expelled = doc.createElement("expelledStudents");
                expelled.appendChild(doc.createTextNode(Integer.toString(studyGroup.getExpelledStudents())));
                group.appendChild(expelled);
                Element averageMark = doc.createElement("averageMark");
                averageMark.appendChild(doc.createTextNode(Long.toString(studyGroup.getAverageMark())));
                group.appendChild(averageMark);
                Element formOfEducation = doc.createElement("formOfEducation");
                formOfEducation.appendChild(doc.createTextNode(studyGroup.getFormOfEducation().toString()));
                group.appendChild(formOfEducation);
                Element groupAdmin = doc.createElement("groupAdmin");
                group.appendChild(groupAdmin);
                Element adminName = doc.createElement("name");
                adminName.appendChild(doc.createTextNode(studyGroup.getGroupAdmin().getName()));
                groupAdmin.appendChild(adminName);
                Element birthday = doc.createElement("birthday");
                birthday.appendChild(doc.createTextNode(studyGroup.getGroupAdmin().getBirthday().toString()));
                groupAdmin.appendChild(birthday);
                Element eyeColor = doc.createElement("eyeColor");
                eyeColor.appendChild(doc.createTextNode(studyGroup.getGroupAdmin().getEyeColor().toString()));
                groupAdmin.appendChild(eyeColor);
                Element nationality = doc.createElement("nationality");
                nationality.appendChild(doc.createTextNode(studyGroup.getGroupAdmin().getNationality().toString()));
                groupAdmin.appendChild(nationality);
                Element location = doc.createElement("location");
                group.appendChild(location);
                Element x_loc = doc.createElement("x");
                Element y_loc = doc.createElement("y");
                Element loc_name = doc.createElement("name");
                x_loc.appendChild(doc.createTextNode(Double.toString(studyGroup.getGroupAdmin().getLocation().getX())));
                y_loc.appendChild(doc.createTextNode(studyGroup.getGroupAdmin().getLocation().getY().toString()));
                loc_name.appendChild(doc.createTextNode(studyGroup.getGroupAdmin().getLocation().getName()));
                location.appendChild(x_loc);
                location.appendChild(y_loc);
                location.appendChild(loc_name);



            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(filename);
            transformer.transform(source, result);

            System.out.println("Успешное сохранение в файл Results.xml");
        }
        catch(Exception e){
            System.out.println(e.getMessage());;
        }
    }

}
