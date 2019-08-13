package com.aurelmarishta.restblog.user.article;

import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Api(tags = "Articles Entity")
@RepositoryRestResource(path = "api/articles")
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
