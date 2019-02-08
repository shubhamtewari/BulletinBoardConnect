package exceptions;

public class DuplicateConnectionToDatabaseException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Connection already present.");
    }
}
