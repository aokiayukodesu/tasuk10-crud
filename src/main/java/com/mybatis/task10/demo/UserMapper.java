package com.mybatis.task10.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("insert into users (name,address) values (#{name}, #{address})")
    public void createDate(CreateForm form);

    @Update("update users set name = #{form.name}, address =#{form.address} where id =#{id}")
    void update(@Param("id") int id, @Param("form") UpdateForm form);

    @Delete("delete from users where id = #{user.id}")
    void delete(@Param("id") int id, @Param("user") User user);
}
