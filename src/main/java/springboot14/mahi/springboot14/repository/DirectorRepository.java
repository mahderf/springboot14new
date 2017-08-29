package springboot14.mahi.springboot14.repository;

import org.springframework.data.repository.CrudRepository;
import springboot14.mahi.springboot14.models.Director;
import springboot14.mahi.springboot14.models.Movie;

public interface DirectorRepository extends CrudRepository<Director, Long> {
    Iterable<Director>findDirectorById(long Long);
}
