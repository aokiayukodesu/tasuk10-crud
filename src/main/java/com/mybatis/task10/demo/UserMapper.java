package com.mybatis.task10.demo;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("insert into users (name,address) values (#{name}, #{address})")
    public void createDate(CreateForm form);

    @Update("update users set name = #{name}, address =#{address}  where id =#{id}")
    public void upDate(int id, User user);
}
