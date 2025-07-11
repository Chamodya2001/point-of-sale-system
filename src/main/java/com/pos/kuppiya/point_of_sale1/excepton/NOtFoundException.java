package com.pos.kuppiya.point_of_sale1.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NOtFoundException extends RuntimeException{
    public NOtFoundException(String message){
        super(message);
    }
}
