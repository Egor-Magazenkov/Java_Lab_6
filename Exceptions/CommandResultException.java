package Lab_6.Exceptions;

public class CommandResultException extends Exception{
    private String message;
    private int status;
        public CommandResultException(int status, String m){
            this.status=status;
            if (status == 0){
                this.message = "Команда выполнена успешно!\n" + m;
            }
            else{
                this.message = "Возникла ошибка! Команда не выполнена!\n" + m;
            }
        }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
