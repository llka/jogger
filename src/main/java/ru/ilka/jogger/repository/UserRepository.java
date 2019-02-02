package ru.ilka.jogger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ilka.jogger.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long id);

    @Override
    List<User> findAll();

    User findByLoginIgnoreCase(String login);

    @Override
    User save(User user);

    @Override
    void deleteAll();

    void deleteById(Long id);

    @Override
    <S extends User> List<S> saveAll(Iterable<S> users);

    @Override
    boolean existsById(Long aLong);

    @Override
    List<User> findAllById(Iterable<Long> ids);

    @Override
    long count();

    @Override
    void delete(User user);

    @Override
    void deleteAll(Iterable<? extends User> users);
}
