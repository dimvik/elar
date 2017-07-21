package vklvdm.elar.exceptions;

import java.io.IOException;

/**
 * Created by vikulov.d on 20.07.2017.
 */
public class PasswordException extends Exception {

    public PasswordException(String message, IOException e) {
        super(message, e);
    }

    public PasswordException(String message) {
        super(message);
    }
}
