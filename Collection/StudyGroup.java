package Lab_6.Collection;

import java.io.Serializable;
import java.time.LocalDate;
import Lab_6.Exceptions.WrongFormatException;

public class StudyGroup implements Comparable<StudyGroup>, Serializable {
    private static int idCount = 0;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private int expelledStudents; //Значение поля должно быть больше 0
    private long averageMark; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null

    public StudyGroup(){
        this.creationDate = LocalDate.now();
        this.id = ++idCount;
    }
    public StudyGroup(String name, Coordinates coordinates, Long studentsCount, int expelledStudents, long averageMark, FormOfEducation formOfEducation, Person groupAdmin){
        this.averageMark = averageMark;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.expelledStudents = expelledStudents;
        this.formOfEducation = formOfEducation;
        this.groupAdmin = groupAdmin;
        this.name = name;
        
        this.creationDate = LocalDate.now();
        this.id = ++idCount;

    }

    
    /** 
     * @param averageMark the value of StudyGroup's average mark, should be more than 0
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setAverageMark(long averageMark) throws WrongFormatException {
        if (averageMark > 0){
            this.averageMark = averageMark;
        }
        else{
            throw new WrongFormatException("Требуется число типа long большее нуля.");
        }
    }
    /** 
     * @param coordinates the location coordinates of StudyGroup, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setCoordinates(Coordinates coordinates) throws WrongFormatException{
        if (coordinates != null){
        this.coordinates = coordinates;
        }
        else{
            throw new WrongFormatException("Требуется объект типа Coordinates, отличный от null.");
        }
    }
    /** 
     * @param expelledStudents the number of expelled student in the StudyGroup, should be more than 0
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setExpelledStudents(int expelledStudents) throws WrongFormatException{
       if (expelledStudents > 0){
           this.expelledStudents = expelledStudents;
        }
       else {
           throw new WrongFormatException("Требуется число типа int, большее нуля.");
        }
    }
    /** 
     * @param formOfEducation StudyGroup's form of education, should be not null
     */
    public void setFormOfEducation(FormOfEducation formOfEducation) throws WrongFormatException{
        if (formOfEducation != null){
            this.formOfEducation = formOfEducation;
        }
        else{
            throw new WrongFormatException("Требуется перечисляемый тип FormOfEducation, отличный от null.");
        }
    }
    /** 
     * @param groupAdmin the admin of the StudyGroup, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setGroupAdmin(Person groupAdmin) throws WrongFormatException{
        if (groupAdmin != null){
            this.groupAdmin = groupAdmin;
        }
        else{
            throw new WrongFormatException("Требуется объект типа Person, отличный от null.");
        }
    }
    /** 
     * @param name the name of the StudyGroup, should be not null and not empty
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setName(String name) throws WrongFormatException{
        if (name != null && !name.isEmpty()){
            this.name = name;
        }
        else{
            throw new WrongFormatException("Требуется непустая строка, отличная от null.");
        }
    }
    /** 
     * @param studentsCount the number of students studying in StudyGroup, should be not null and more than zero
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setStudentsCount(Long studentsCount) throws WrongFormatException{
        if (studentsCount != null && studentsCount > 0){
            this.studentsCount = studentsCount;
        }
        else{
            throw new WrongFormatException("Требуется число типа Long, отличное от null и большее нуля.");
        }
    }



    /** 
     * @return long
     */
    public long getAverageMark() {
        return averageMark;
    }
    /** 
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    /** 
     * @return LocalDate
     */
    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }
    /** 
     * @return int
     */
    public int getExpelledStudents() {
        return expelledStudents;
    }
    /** 
     * @return FormOfEducation
     */
    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }
    /** 
     * @return Person
     */
    public Person getGroupAdmin() {
        return groupAdmin;
    }
    /** 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }
    /** 
     * @return Long
     */
    public Long getStudentsCount() {
        return studentsCount;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%6s %10s %12s %20s %25s %35s %20s %60s %15s", this.id, this.name, this.coordinates, this.formOfEducation, this.studentsCount, this.expelledStudents,  this.averageMark, this.groupAdmin, this.creationDate);
    }

    
    @Override
    public int compareTo(StudyGroup o) {
        return Long.compare(o.getAverageMark(), this.averageMark);
    }
}

