package Lab_6.Collection;
import Lab_6.Exceptions.WrongFormatException;



public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDate birthday; //Поле может быть null
    private Color eyeColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null

    public Person(){

    }
    public Person(String name, java.time.LocalDate birthday, Color eyeColor, Country nationality, Location location){
        this.name = name;
        this.birthday = birthday;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
        this.location = location;
    }

    /**
     * @param name the name of the Person, should be not null and not empty
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setName(String name) throws WrongFormatException {
        if (name != null && !name.isEmpty()){
            this.name = name;
        }
        else{
            throw new WrongFormatException("Требуется непустая строка, отличная от null.");
        }
    }

    /**
     * @param birthday the date of birth of the Person, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setBirthday(java.time.LocalDate birthday) throws WrongFormatException{
        if (birthday != null) {
            this.birthday = birthday;
        }
        else{
            throw new WrongFormatException("Требуется объект типа Date, отличный от null.");
        }
    }
    /**
     * @param eyeColor the color of eyes of Person, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setEyeColor(Color eyeColor) throws WrongFormatException {
        if (eyeColor != null){
            this.eyeColor = eyeColor;
        }
        else{
            throw new WrongFormatException("Требуется перечисляемый тип Color, отличный от null.");
        }
    }
    /**
     * @param location current location of Person, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setLocation(Location location) throws WrongFormatException {
        if (location != null){
            this.location = location;
        }
        else {
            throw new WrongFormatException("Требуется объект типа Location, отличный от null.");
        }
    }
    /**
     * @param nationality Person's nationality, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setNationality(Country nationality) throws WrongFormatException {
        if (nationality!=null){
            this.nationality = nationality;
        }
        else{
            throw new WrongFormatException("Требуется перечисляемый тип Nationality, отличный от null.");
        }
    }


    /**
     * @return Date
     */
    public java.time.LocalDate getBirthday() {
        return birthday;
    }
    /**
     * @return Color
     */
    public Color getEyeColor() {
        return eyeColor;
    }
    /**
     * @return Location
     */
    public Location getLocation() {
        return location;
    }
    /**
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * @return Country
     */
    public Country getNationality() {
        return nationality;
    }


    /**
     * @return String
     */
    @Override
    public String toString() {
        return name + " " + birthday + " " + nationality + " " + eyeColor + " " + location;
    }
}
