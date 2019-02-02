package ru.ilka.jogger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ilka.jogger.entity.Workout;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {
    @Override
    <S extends Workout> S save(S entity);

    @Override
    <S extends Workout> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Workout> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    List<Workout> findAll();

    List<Workout> findByStartDateTimeBetween(Date startDateMin, Date startDateMax);

    @Override
    List<Workout> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Workout entity);

    @Override
    void deleteAll(Iterable<? extends Workout> entities);

    @Override
    void deleteAll();
}
