package kg.megacom.NewsBlog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FilterNotFoundException extends RuntimeException{
    public FilterNotFoundException(String message){
        super(message);
    }
}
