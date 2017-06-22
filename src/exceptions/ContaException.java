package exceptions;

/**
 * Created by daviv on 22/06/2017.
 */
public class ContaException extends Exception{

    private String message;

    public ContaException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
