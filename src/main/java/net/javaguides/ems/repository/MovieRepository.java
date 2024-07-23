package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByTitleLike(String title);

    List<Movie> findByDirectorLike(String director);

    List<Movie> findByRatingStartsWith(String rating);

    List<Movie> findByDirectorEndsWith(String director);

    List<Movie> findByDirectorNotLike(String director);
}
