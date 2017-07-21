package vklvdm.elar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vklvdm.elar.exceptions.PasswordException;
import vklvdm.elar.exceptions.UserException;
import vklvdm.elar.model.User;
import vklvdm.elar.services.PasswordService;
import vklvdm.elar.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikulov.d on 20.07.2017.
 */
@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordService passwordService;

    @Autowired
    public UserAuthenticationProvider(UserService userService, PasswordService passwordService) {
        this.userService = userService;
        this.passwordService = passwordService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        //Получаем пользователя
        User user;
        try {
            user = userService.getUserByLogin(login);
        } catch (UserException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (PasswordException e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        //Проверяем пароль
        if (!passwordService.checkPass(password, user.getPassword())) throw new BadCredentialsException("Неверный пароль");

        final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

        log.info("Вошел пользователь - {}", login);
        return new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
