package Lab_6.Collection;
import Lab_6.Exceptions.WrongFormatException;

public class Location {
    private double x;
    private Double y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле может быть null

    public Location(){

    }
    public Location(double x, Double y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }


    /**
     * @param x x coordinate of Locaion
     */
    public void setX(double x) throws WrongFormatException{
        this.x = x;
    }

    /**
     * @param y y coordinate of Location, should be not null
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setY(Double y) throws WrongFormatException{
        if(y != null){
            this.y = y;
        }
        else{
            throw new WrongFormatException("Требуется число типа Double, отличное от null.");
        }
    }
    /**
     * @param name the name of the Location place, should be not null and not empty
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
     * @return Double
     */
    public double getX() {
        return x;
    }

    /**
     * @return float
     */
    public Double getY() {
        return y;
    }
    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return name + " (" + this.x + " " + this.y.toString() + ")";
    }
}

