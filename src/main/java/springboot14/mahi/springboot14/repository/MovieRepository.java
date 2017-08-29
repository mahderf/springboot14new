package springboot14.mahi.springboot14.repository;

import org.springframework.data.repository.CrudRepository;
import springboot14.mahi.springboot14.models.Movie;

public interface MovieRepository extends CrudRepository<Movie,Long>{
    Iterable<Movie>findAllByIdIs(long Long);
}
