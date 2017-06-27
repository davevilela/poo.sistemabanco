package exceptions;


public class ClienteException extends Exception {

    private String message;

    public ClienteException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

}
