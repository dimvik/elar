package vklvdm.elar.repo;

import org.springframework.data.repository.Repository;
import vklvdm.elar.model.User;

/**
 * Репозиторий пользователей
 *
 * Created by vikulov.d on 20.07.2017.
 */
@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Long> {

	User findByLogin(String name);

}
