package com.eeit87t3.tickiteasy.post.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eeit87t3.tickiteasy.categoryandtag.entity.CategoryEntity;
import com.eeit87t3.tickiteasy.categoryandtag.entity.TagEntity;
import com.eeit87t3.tickiteasy.event.entity.EventsEntity;
import com.eeit87t3.tickiteasy.post.entity.PostEntity;


public interface PostRepo extends JpaRepository<PostEntity, Integer> {
	@Query("SELECT p FROM PostEntity p JOIN FETCH p.postCategory JOIN FETCH p.postTag JOIN FETCH p.member")
	List<PostEntity> findAllPostsWithDetails();

//    Page<PostEntity> findAll(Pageable pageable);
//    Page<PostEntity> findByCategory(Integer categoryID, Pageable pageable);
    Page<PostEntity> findByPostCategory_CategoryId(Integer categoryId, Pageable pageable);
    
	List<PostEntity> findByPostCategory(CategoryEntity postCategory);
//	List<PostEntity> findByTag(TagEntity tag);
//	List<PostEntity> findByEnter(String enter);
}
