package ensa.sri.indexationcv.exceptions;

import java.util.Map;

public class BadFormatException extends BaseException{
    public BadFormatException(Map<String, Object> data){
        super(ErrorCode.BAD_FILE_EXTENSION, data);
    }
}
