package com.vole.film.repository;

import com.vole.film.entity.WebSite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 收录电影网址 Repostory 接口
 */
public interface WebSiteRepository extends JpaRepository<WebSite, Integer>, JpaSpecificationExecutor<WebSite> {
}
