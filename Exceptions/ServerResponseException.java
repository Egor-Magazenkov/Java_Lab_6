package Lab_6.Exceptions;

public class ServerResponseException extends Exception{
    private String message;
    private int status;
    public ServerResponseException(int status, String m){
        this.status=status;
        this.message = m;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
