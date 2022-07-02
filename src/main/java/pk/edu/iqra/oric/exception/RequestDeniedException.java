package pk.edu.iqra.oric.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class RequestDeniedException extends RuntimeException{
    public RequestDeniedException(String message){
        super(message);
    }
}
