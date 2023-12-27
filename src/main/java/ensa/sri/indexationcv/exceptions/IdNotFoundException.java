package ensa.sri.indexationcv.exceptions;

import java.util.Map;


public class IdNotFoundException extends BaseException{
    public IdNotFoundException(Map<String, Object> data) {
        super(ErrorCode.ID_NOT_FOUND, data);
    }
}
