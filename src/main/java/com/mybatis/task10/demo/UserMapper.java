package com.mybatis.task10.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("insert into users (name,address) values (#{name}, #{address})")
    public void createDate(CreateForm form);

    @Update("update users set name = #{user.name}, address =#{user.address} where id =#{id}")
    void update(@Param("id") int id, @Param("user") User user);

    @Delete("delete from users where id = #{id}")
    void delete(@Param("id") int id, @Param("name") String name, @Param("address") String address);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(@Param("id") int id);
}
