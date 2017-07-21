package vklvdm.elar.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vklvdm.elar.exceptions.PasswordException;
import vklvdm.elar.exceptions.UserException;
import vklvdm.elar.model.User;
import vklvdm.elar.repo.UserRepository;
import vklvdm.elar.services.PasswordService;
import vklvdm.elar.services.UserService;

/**
 * Created by vikulov.d on 20.07.2017.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final PasswordService passwordService;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordService passwordService, UserRepository userRepository) {
        this.passwordService = passwordService;
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login) throws PasswordException, UserException {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            long userId = user.getId();
            String password = passwordService.getPassById(userId);
            user.setPassword(password);
            return user;
        } else {
            log.warn("Пользователь не найден - {}", login);
            throw new UserException("Нет такого пользователя");
        }
    }

}
