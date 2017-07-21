package vklvdm.elar.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import vklvdm.elar.exceptions.PasswordException;
import vklvdm.elar.services.PasswordService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vikulov.d on 20.07.2017.
 */
@Slf4j
@Service
public class PasswordServiceImpl implements PasswordService {

    public boolean checkPass(String pass, String userPass) {
        String md5Pass = DigestUtils.md5DigestAsHex(pass.getBytes());
        return md5Pass.equals(userPass);
    }

    public String getPassById(long id) throws PasswordException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("pass.txt");
        if (is != null) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    String[] part = line.split("\\t");
                    long userId = Long.valueOf(part[0]);
                    if (userId == id) return part[1];
                }
                log.warn("Пароль для пользователя с идентификатором {} не найден", id);
                throw new PasswordException("Пароль для пользователя не найден");
            } catch (IOException e) {
                log.warn(e.getMessage());
                throw new PasswordException(e.getMessage(), e);
            }
        } else {
            log.warn("Файл с паролями не найден");
            throw new PasswordException("Файл с паролями не найден");
        }
    }

}
