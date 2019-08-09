package ucacue.edu.ec.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SofiaException extends RuntimeException {

    private static final long serialVersionUID = 4956405604792374198L;

    public SofiaException(String message) {
        super(message);
    }

    public SofiaException(Exception ex) {
        super(ex);
    }

}
