package vklvdm.elar.model;

import lombok.Data;

import javax.persistence.*;

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
    private String password;

}
