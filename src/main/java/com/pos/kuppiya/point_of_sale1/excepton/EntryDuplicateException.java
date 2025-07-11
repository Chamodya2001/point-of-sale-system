package com.pos.kuppiya.point_of_sale1.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED )
public class EntryDuplicateException extends RuntimeException
{
    public EntryDuplicateException(String message){
        super(message);
    }
}
