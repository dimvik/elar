package vklvdm.elar.services;

import vklvdm.elar.exceptions.PasswordException;
import vklvdm.elar.exceptions.UserException;
import vklvdm.elar.model.User;

/**
 * Created by vikulov.d on 20.07.2017.
 */
public interface UserService {

    /**
     * Получить пользователя по логину
     * @param login логин пользователя
     * @return сущность пользователя
     */
    User getUserByLogin(String login) throws PasswordException, UserException;

}
