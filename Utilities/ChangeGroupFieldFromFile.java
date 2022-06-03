package Lab_6.Utilities;

import Lab_6.Collection.*;
import Lab_6.Exceptions.SetResultException;
import Lab_6.Exceptions.WrongFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeGroupFieldFromFile {
    private StudyGroup group;
    Scanner sc;
    public ChangeGroupFieldFromFile(StudyGroup group, Scanner sc){
        this.sc =sc;
        this.group = group;
    }

    public void change_name() throws SetResultException{
            String name = sc.nextLine();
            try {
                group.setName(name);
            } catch (Exception e) {
                throw new SetResultException("Ошибка!");
            }
    }

    public void change_coordinate() throws  SetResultException{
        Coordinates coords = new Coordinates();

        Double x;
            try {
                x = sc.nextDouble();
                coords.setX(x);
            } catch (Exception e){
                throw new SetResultException("Ошибка!");
        }
            try {
                float y = sc.nextFloat();
                coords.setY(y);
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            try {
                group.setCoordinates(coords);
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            }

    public void change_StudentsCount()throws SetResultException{
            try {
                Long studentsCount = sc.nextLong();
                group.setStudentsCount(studentsCount);
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
    }


    public void change_ExpelledStudents() throws  SetResultException{
            try {
                int expelledStudents = sc.nextInt();
                group.setExpelledStudents(expelledStudents);
            } catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
    }

    public void change_AverageMark() throws SetResultException{
            try {
                int averageMark = sc.nextInt();
                group.setAverageMark(averageMark);
                sc.nextLine();
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
    }
    public void change_FormOfEducation() throws SetResultException{
                String formOfEducation = sc.nextLine();
                try {
                    group.setFormOfEducation(FormOfEducation.valueOf(formOfEducation));
                } catch (Exception e){
                    throw new SetResultException("Ошибка!");
                }
        }

    public void change_Admin() throws SetResultException{
        Person admin = new Person();
            String name = sc.nextLine();
            try {
                admin.setName(name);
            } catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            String birthday = sc.nextLine();
            try {
                admin.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));;
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            String color = sc.nextLine().toUpperCase();
            try {
                admin.setEyeColor(Color.valueOf(color.toUpperCase()));
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            String nationality = sc.nextLine().toUpperCase();
            try {
                admin.setNationality(Country.valueOf(nationality.toUpperCase()));
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
        Location location = new Location();
            try {
                double x = sc.nextDouble();
                location.setX(x);
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            try {
                Double y = sc.nextDouble();
                location.setY(y);
                sc.nextLine();
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            String name_ = sc.nextLine();
            try {
                location.setName(name_);;
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
            try {
                admin.setLocation(location);;
            }catch (Exception e){
                throw new SetResultException("Ошибка!");
            }
        try {
            group.setGroupAdmin(admin);
        }catch (Exception e){
            throw new SetResultException("Ошибка!");
        }

    }



}
