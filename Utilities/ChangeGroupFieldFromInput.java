package Lab_6.Utilities;

import Lab_6.Collection.*;
import Lab_6.Exceptions.SetResultException;
import Lab_6.Exceptions.WrongFormatException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ChangeGroupFieldFromInput {
    private StudyGroup group;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    public ChangeGroupFieldFromInput(StudyGroup group, ObjectInputStream ois, ObjectOutputStream oos){
        this.group = group;
        this.ois = ois;
        this.oos = oos;
    }

    public void change_name(){
        try {
            oos.writeObject("Введите имя группы");
        } catch (IOException e) {
            System.out.println("sdjfhosa");
        }
        while (true) {
            
            try {


                String name = ois.readObject().toString();
                group.setName(name);
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch(Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            } catch (Exception e){
                try {
                    oos.writeObject("Ошибка с вводом.");
                } catch (IOException ex) {
                    System.out.println(ex.getStackTrace());
                }
            }
        }
    }

    public void change_coordinate() {

        Coordinates coords = new Coordinates();
        try {
            oos.writeObject("Введите x координату группы");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {

            Double x;
            try {
                x = Double.parseDouble(ois.readObject().toString());
                coords.setX(x);
                break;
            } catch (WrongFormatException e) {
                try {
                    oos.writeObject(e.getMessage());
                } catch (Exception ex) {
                    System.out.println("Smth");
                }
            } catch (Exception e) {
                try {
                    oos.writeObject("Требуется число типа Double.");
                } catch (Exception ex) {
                    System.out.println("smth");
                }
            }
        }
            try {
                oos.writeObject("Введите y координату группы");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            float y;
            while (true) {
                try {
                    y= Float.parseFloat(ois.readObject().toString());
                    coords.setY(y);
                    break;
                } catch (WrongFormatException e) {
                    try {
                        oos.writeObject(e.getMessage());
                    } catch (Exception ex) {
                        System.out.println("smth");
                    }
                } catch (Exception e) {
                    try {
                        oos.writeObject("Требуется число типа float.");
                    } catch (Exception ex) {
                        System.out.println("smth");
                    }
                }
            }
            while (true) {
                try {
                    group.setCoordinates(coords);
                    break;
                } catch (WrongFormatException e) {
                    try {
                        oos.writeObject(e.getMessage());
                    } catch (Exception ex) {
                        System.out.println("smth");
                    }
                }
            }
        }


    public void change_StudentsCount(){
        try {
            oos.writeObject("Введите количество студентов в группе");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                Long studentsCount = Long.parseLong(ois.readObject().toString());
                group.setStudentsCount(studentsCount);
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch(Exception ex){
                    System.out.println(Arrays.toString(ex.getStackTrace()));
                }
            }catch (Exception e){
                try{
                    oos.writeObject("Требуется число типа Long.");
                }catch (Exception ex){
                    System.out.println(Arrays.toString(ex.getStackTrace()));
                }
            }
        }
    }


    public void change_ExpelledStudents(){
        try {
            oos.writeObject("Введите количество отчисленных студентов в группе");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                int expelledStudents = Integer.parseInt(ois.readObject().toString());
                group.setExpelledStudents(expelledStudents);
                break;
            } catch (WrongFormatException e) {
                try {
                    oos.writeObject(e.getMessage());
                } catch (IOException ex) {
                    System.out.println("bad");
                }
            }catch (Exception e){
                try{
                    oos.writeObject("Требуется число типа int.");
                }catch (Exception ex){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void change_AverageMark() {
        try {
            oos.writeObject("Введите среднюю оценку по группе");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                int averageMark = Integer.parseInt(ois.readObject().toString());
                group.setAverageMark(averageMark);
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }catch (Exception e){
                try {
                    oos.writeObject("Попробуйте ещё раз.");
                } catch (IOException ex) {
                    System.out.println(ex.getStackTrace());
                }
            }
        }
    }
    public void change_FormOfEducation(){
        try {
            oos.writeObject("Выберите форму обучения группы из предложенных: \nDISTANCE_EDUCATION,\nFULL_TIME_EDUCATION,\nEVENING_CLASSES");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
                try {

                    String formOfEducation = ois.readObject().toString();
                    group.setFormOfEducation(FormOfEducation.valueOf(formOfEducation));
                    break;
                } catch (WrongFormatException e) {
                    try{
                        oos.writeObject(e.getMessage());
                    }catch(Exception ex){
                        System.out.println(ex.getStackTrace());
                    }
                } catch (Exception e) {
                    try{
                        oos.writeObject("Выберите форму обучения  группы ТОЛЬКО из предложенных: \nDISTANCE_EDUCATION,\nFULL_TIME_EDUCATION,\nEVENING_CLASSES");
                    }catch(Exception ex){
                        System.out.println(ex.getStackTrace());
                    }
                }
            }
        }

    public void change_Admin() {
        Person admin = new Person();
        try {
            oos.writeObject("Введите имя админа группы");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                String name = ois.readObject().toString();
                admin.setName(name);;
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            } catch (Exception e){
                try {
                    oos.writeObject("Попробуйте ещё раз.");
                } catch (IOException ex) {
                    System.out.println(ex.getStackTrace());
                }
            }
        }
        try {
            oos.writeObject("Введите дату рождения админа в формате dd.mm.YYYY");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                String birthday = ois.readObject().toString();
                admin.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));;
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }catch (Exception e){
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        }
        try {
            oos.writeObject("Выберите цвет глаз админа из предложенных: \nRED,\nYELLOW,\nORANGE");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                String color = ois.readObject().toString().toUpperCase();
                admin.setEyeColor(Color.valueOf(color));
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            } catch (Exception e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        }
        try {
            oos.writeObject("Выберите национальность админа из предложенных: \nJAPAN,\nUSA,\nVATIKAN");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                String nationality = ois.readObject().toString().toUpperCase();
                admin.setNationality(Country.valueOf(nationality));
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            } catch (Exception e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        }
        try {
            oos.writeObject("Введите x координату");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Location location = new Location();

        while (true) {
            try {
                double x = Double.parseDouble(ois.readObject().toString());
                location.setX(x);
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            } catch (Exception e){
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        }
        try {
            oos.writeObject("Введите y координату");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                Double y = Double.parseDouble(ois.readObject().toString());
                location.setY(y);
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }catch (Exception e){
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        }
        try {
            oos.writeObject("Введите название города");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                String name = ois.readObject().toString();
                location.setName(name);;
                break;
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            } catch (Exception e){
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        }

            try {
                admin.setLocation(location);
            } catch (WrongFormatException e) {
                try{
                    oos.writeObject(e.getMessage());
                }catch (Exception ex){
                    System.out.println(ex.getStackTrace());
                }
            }
        try {
            group.setGroupAdmin(admin);
        } catch (WrongFormatException e) {
            try{
                oos.writeObject(e.getMessage());
            }catch (Exception ex){
                System.out.println(ex.getStackTrace());
            }
        }

    }



}
