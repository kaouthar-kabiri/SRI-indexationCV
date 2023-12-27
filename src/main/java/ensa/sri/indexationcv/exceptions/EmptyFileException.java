package ensa.sri.indexationcv.exceptions;

import java.util.Map;

public class EmptyFileException extends BaseException{
    public EmptyFileException(Map<String, Object> data) {
        super(ErrorCode.EMPTY_FILE, data);
    }
}
