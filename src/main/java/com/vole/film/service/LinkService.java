package com.vole.film.service;

import com.vole.film.entity.Link;

import java.util.List;

/**
 * 友情链接 Service 接口
 */
public interface LinkService {

    /**
     * 分页查询友情链接
     * @param page
     * @param pageSize
     * @return
     */
    List<Link> list(Integer page, Integer pageSize);

    /**
     * 查询所有友情链接
     * @return
     */
    List<Link> listAll();

    /**
     * 获取总记录数
     * @return
     */
    Long getCount();

    /**
     * 添加或者修改友情链接
     * @param link
     */
    void save(Link link);

    /**
     * 根据 id 删除友情链接
     * @param id
     */
    void delete(Integer id);
}
