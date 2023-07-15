package com.mybatis.task10.demo;

import java.util.List;

public interface UserService {

    List<User> findByAll();

    User findById(int id) throws Exception;

    void create(CreateForm form);

    public void update(int id, User user);

}
