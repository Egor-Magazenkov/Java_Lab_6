package Lab_6.Exceptions;

public class WrongFormatException extends Exception{
    private final String message;
    public WrongFormatException (String m){
        this.message = m;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
