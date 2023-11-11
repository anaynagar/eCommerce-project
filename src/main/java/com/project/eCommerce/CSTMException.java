package com.project.eCommerce;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@EqualsAndHashCode(callSuper = true)
@Data
public class CSTMException extends Exception{


    public CSTMException(String message, HttpStatus httpStatus) {
        super(message);
    }

}
