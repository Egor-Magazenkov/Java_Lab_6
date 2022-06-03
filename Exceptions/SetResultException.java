package Lab_6.Exceptions;

public class SetResultException extends Exception{
    private String message;
    public SetResultException(String m){
        this.message = m + "\nПопробуйте еще раз";

    }

    @Override
    public String getMessage() {
        return message;
    }

}
