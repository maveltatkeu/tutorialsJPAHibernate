package com.pix.tutorial.sample.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pix.tutorial.sample.model.Tutorial;

/*
 * Now we can use JpaRepository’s methods: save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.
 * 
 *  We also define custom finder methods:
– findByPublished(): returns all Tutorials with published having value as input published.
– findByTitleContaining(): returns all Tutorials which title contains input title.
 * 
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {


    @Query("SELECT b FROM Tutorial b WHERE b.published = published ")
    List<Tutorial> findByPublished(@Param("boolean") boolean published); 

    @Query("SELECT b FROM Tutorial b WHERE b.title ILIKE %:title%")
    List<Tutorial> findByTitleContaining(@Param("title") String title);

}