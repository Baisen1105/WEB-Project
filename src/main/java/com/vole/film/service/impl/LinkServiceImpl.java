package com.vole.film.service.impl;

import com.vole.film.entity.Link;
import com.vole.film.repository.LinkRepository;
import com.vole.film.service.LinkService;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * 友情链接实现类
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkRepository linkRepository;

    @Override
    public List<Link> list(Integer page, Integer pageSize) {
        return linkRepository.findAll(new PageRequest(page, pageSize)).getContent();
    }

    @Override
    public List<Link> listAll() {
        return linkRepository.findAll();
    }

    @Override
    public Long getCount() {
        return linkRepository.count();
    }

    @Override
    public void save(Link link) {
        linkRepository.save(link);
    }

    @Override
    public void delete(Integer id) {
        linkRepository.delete(id);
    }
}
