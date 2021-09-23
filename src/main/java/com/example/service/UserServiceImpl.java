package com.example.service;

import com.example.entity.User;
import com.example.entity.UserExample;
import com.example.mapper.UserMapper;
import com.example.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunwu
 * @since 2021-09-23-18:42
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public User checkUser(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if (users.size()>0){
            User resultUser = users.get(0);
            System.out.println(resultUser.getPassword());
            System.out.println(MD5Util.md5(user.getPassword()));
            if (resultUser.getPassword().equals(MD5Util.md5(user.getPassword())))
                return resultUser;
        }else {
            return null;
        }
        return null;
    }
}
