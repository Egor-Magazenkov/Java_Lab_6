package Lab_6.Utilities;

import Lab_6.Collection.*;
import Lab_6.Exceptions.WrongFormatException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class ParseXML {
    private File filepath;
    private HashSet<StudyGroup> result;
    public ParseXML(File filepath){
        this.filepath= filepath;
    }
    public void parseGroups() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            GroupHandler groupHandler = new GroupHandler(saxParser);
            saxParser.parse(filepath, groupHandler);
            result = groupHandler.getGroups();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public HashSet<StudyGroup> getResult() {
        return result;
    }
}

class GroupHandler extends DefaultHandler{
    private SAXParser saxParser;
    private HashSet<StudyGroup> groups;

    private StudyGroup group;
    private Coordinates coord;
    private Person admin;
    private Location loc;
    private String content;

    public GroupHandler(SAXParser saxParser){
        this.saxParser = saxParser;
    }

    @Override
    public void startDocument() throws SAXException {
        groups = new HashSet<StudyGroup>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("StudyGroup")){
            group = new StudyGroup();
        } else if (qName.equals("coordinates")) {
            coord = new Coordinates();
        } else if (qName.equals("groupAdmin")) {
            admin = new Person();
        } else if (qName.equals("admin_location")) {
            loc = new Location();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("StudyGroup")){
            groups.add(group);
        } else if (qName.equals("name")) {
            try {
                group.setName(content);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("coordinates")) {
            try {
                group.setCoordinates(coord);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("x_coord")) {
            try {
                coord.setX(Double.parseDouble(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("y_coord")) {
            try {
                coord.setY(Float.parseFloat(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("studentsCount")) {
            try {
                group.setStudentsCount(Long.parseLong(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("expelledStudents")) {
            try {
                group.setExpelledStudents(Integer.parseInt(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("averageMark")) {
            try {
                group.setAverageMark(Long.parseLong(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("formOfEducation")) {
            try {
                group.setFormOfEducation(FormOfEducation.valueOf(content));
            } catch (WrongFormatException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("groupAdmin")) {
            try {
                group.setGroupAdmin(admin);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("admin_name")) {
            try {
                admin.setName(content);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("admin_birthday")) {
            try {
                admin.setBirthday(LocalDate.parse(content, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("admin_eyecolor")) {
            try {
                admin.setEyeColor(Color.valueOf(content.toUpperCase()));
            } catch (WrongFormatException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("admin_nationality")) {
            try {
                admin.setNationality(Country.valueOf(content.toUpperCase()));
            } catch (WrongFormatException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("admin_location")) {
            try {
                admin.setLocation(loc);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        }  else if (qName.equals("x_loc")) {
            try {
                loc.setX(Double.parseDouble(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("y_loc")) {
            try {
                loc.setY(Double.parseDouble(content));
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (qName.equals("location_name")) {
            try {
                loc.setName(content);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new String(ch, start, length);
    }

    public HashSet<StudyGroup> getGroups() {
        return groups;
    }
}

