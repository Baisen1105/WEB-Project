package com.xduweb.web.service;

import com.xduweb.web.dao.entity.User;
import com.xduweb.web.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    public UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.queryUserList();
    }

    public boolean canLogin(Long user_id,String password){
        User user = userMapper.getUserByID(user_id);
        if(user == null){
            return false;
        }
        else {
            if(user.getPassword().equals(password)){
                return true;
            }
            else {
                return false;
            }
        }
    }
}
