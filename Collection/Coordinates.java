package Lab_6.Collection;
import Lab_6.Exceptions.WrongFormatException;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -549, Поле не может быть null
    private float y; //Значение поля должно быть больше -36

    public Coordinates(){
    }
    public Coordinates(Double x, float y){
        this.x = x;
        this.y = y;
    }

    
    /** 
     * @param x x coordinate of StudyGroup object, should be not null and more than -549
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setX(Double x) throws WrongFormatException{
        if (x != null && x > -549){
            this.x = x;
        }
        else{
            throw new WrongFormatException("Требуется число формата Double большее -549 и отличное от нуля.");
        }
    }
    
    /** 
     * @param y y coordinate of StudyGroup object, should be more than -36
     * @throws WrongFormatException if parameter don't follow restrictions
     */
    public void setY(float y) throws WrongFormatException{
        if(y > -36){
            this.y = y;
        }
        else{
            throw new WrongFormatException("Требуется число типа float большее -36.");
        }
    }
    
    /** 
     * @return Double
     */
    public Double getX() {
        return x;
    }
    
    /** 
     * @return float
     */
    public float getY() {
        return y;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "(" + this.x.toString() + " " + this.y + ")";
    }
}
