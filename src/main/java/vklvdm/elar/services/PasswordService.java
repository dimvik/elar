package vklvdm.elar.services;

import vklvdm.elar.exceptions.PasswordException;

/**
 * Created by vikulov.d on 20.07.2017.
 */
public interface PasswordService {

    /**
     * Проверка правильности пароля
     * @param pass пароль на вход
     * @param userPass пароль пользователя
     * @return true - верный пароль, false - неверный пароль
     */
    boolean checkPass(String pass, String userPass);

    /**
     * Получить хэшированый пароль по идентификатору пользователя
     * @param id идентификатор пользователя
     * @return хэшированый пароль
     */
    String getPassById(long id) throws PasswordException;

}
