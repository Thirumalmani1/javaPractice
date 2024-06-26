package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

       Post findByTitle(String title);
}
