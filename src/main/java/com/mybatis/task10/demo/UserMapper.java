package com.mybatis.task10.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("insert into users (name,address) values (#{name}, #{address})")
    public void createDate(CreateForm form);

    @Update("update users set name = #{name}, address =#{address} where id =#{id}")
    void upDate(@Param("name") String name, @Param("address") String address, @Param("id") int id, @Param("user") User user);
}
