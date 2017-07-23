package vklvdm.elar.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

/**
 * Сущность пользователя
 *
 * Created by vikulov.d on 20.07.2017.
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String name;

    @Transient
    private final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    @Transient
    private String password;

}
