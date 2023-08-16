package com.mybatis.task10.demo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> findById(int id) throws Exception {
        return userMapper.findById(id);
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

    @Override
    public void delete(int id, String name, String address) {
        Optional<User> user = userMapper.findById(id);
        if (user.isPresent()) {
            userMapper.delete(id, name, address);
        } else {
            throw new ResourceNotFoundException("指定されたidは存在しません");
        }
    }
}
