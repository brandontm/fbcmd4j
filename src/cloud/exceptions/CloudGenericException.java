package cloud.exceptions;

public class CloudGenericException extends Exception {
    private static final long serialVersionUID = 1L;

    public CloudGenericException() {
        super();
    }

    public CloudGenericException(String mensaje) {
        super(mensaje);
    }
}