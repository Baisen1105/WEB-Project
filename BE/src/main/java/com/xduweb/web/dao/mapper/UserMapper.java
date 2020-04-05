package com.xduweb.web.dao.mapper;

import com.xduweb.web.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserList();

    User getUserByID(Long id);
}
