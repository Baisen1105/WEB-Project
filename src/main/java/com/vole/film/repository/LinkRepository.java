package com.vole.film.repository;

import com.vole.film.entity.Link;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 友情链接  Repository 接口
 */
public interface LinkRepository extends JpaRepository<Link,Integer> {

}
