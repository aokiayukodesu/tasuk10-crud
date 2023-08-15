package com.mybatis.task10.demo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findByAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) throws Exception {
        return null;
    }

    @Override
    public void create(CreateForm form) {
        userMapper.createDate(form);
    }

    @Override
    public User update(int id, String name, String address) {
        User user = new User(id, name, address);
        userMapper.update(id, user);
        return user;
    }

    public void delete(int id, User user) {
        userMapper.delete(id, user);
    }
}
