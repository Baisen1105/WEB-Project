package com.vole.film.service.impl;

import com.vole.film.entity.Film;
import com.vole.film.repository.FilmRepository;
import com.vole.film.service.FilmService;
import com.vole.film.util.StringUtil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;

/**
 * 电影 Service 接口实现类
 */
@Service("filmService")
public class FilmServiceImpl implements FilmService {

    @Resource
    private FilmRepository filmRepository;

    @Override
    public void save(Film film) {
        filmRepository.save(film);
    }

    @Override
    public List<Film> list(Film film, Integer page, Integer pageSize) {
        Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "publishDate");
        Page<Film> filmPage = filmRepository.findAll((root, criteriaQuery, cb) -> {
            Predicate predicate = cb.conjunction();
            if (film != null) {
                if (StringUtil.isNotEmpty(film.getName()))
                    predicate.getExpressions().add(cb.like(root.get("name"), "%" + film.getName().trim() + "%"));
                if (film.getHot() != null && film.getHot() == 1)
                    predicate.getExpressions().add(cb.equal(root.get("hot"), 1));

            }
            return predicate;
        }, pageable);
        return filmPage.getContent();
    }

    @Override
    public Long getCount(Film film) {
        return filmRepository.count((root, criteriaQuery, cb) -> {
            Predicate predicate = cb.conjunction();
            if (film != null) {
                if (StringUtil.isNotEmpty(film.getName()))
                    predicate.getExpressions().add(cb.like(root.get("name"), "%" + film.getName().trim() + "%"));
                if (film.getHot() != null && film.getHot() == 1) {
                    predicate.getExpressions().add(cb.equal(root.get("hot"), 1));
                }
            }
            return predicate;
        });
    }

    @Override
    public void delete(Integer id) {
        filmRepository.delete(id);
    }

    @Override
    public Film findById(Integer id) {
        return filmRepository.findOne(id);
    }

    @Override
    public Film getLastFilm(Integer id) {
        return filmRepository.getLastFilm(id);
    }

    @Override
    public Film getNextFilm(Integer id) {
        return filmRepository.getNextFilm(id);
    }

    @Override
    public List<Film> randomList(Integer n) {
        return filmRepository.randomList(n);
    }
}
