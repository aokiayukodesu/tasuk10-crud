package com.mybatis.task10.demo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findByAll();

    void create(CreateForm form);

    public User update(int id, String name, String address);

    Optional<User> findById(int id) throws Exception;

    void delete(int id, String name, String address);
}
