package vklvdm.elar.exceptions;

import java.io.IOException;

/**
 * Created by vikulov.d on 20.07.2017.
 */
public class UserException extends Exception {

    public UserException(String message, IOException e) {
        super(message, e);
    }

    public UserException(String message) {
        super(message);
    }
}
