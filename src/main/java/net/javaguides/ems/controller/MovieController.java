package net.javaguides.ems.controller;

import net.javaguides.ems.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.ems.repository.MovieRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/test")
    public ResponseEntity<Map> testLikeMethods() {
       List<Movie> movies = movieRepository.findByTitleLike("%in%");
       movies.forEach(x-> System.out.println(x.getTitle()));
        Map<Long,String> map = movies.stream().collect(Collectors.toMap(Movie::getId,Movie::getTitle));
       List<Movie> movies2 = movieRepository.findByDirectorLike("%An%");
        movies2.forEach(x-> System.out.println(x.getDirector()));
       return ResponseEntity.ok(map);
    }


}
