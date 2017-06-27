package exceptions;


public class OperacaoException extends Exception{

    private String message;

    public OperacaoException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
