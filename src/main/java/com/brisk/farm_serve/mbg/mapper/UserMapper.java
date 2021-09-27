package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface UserMapper {

    User getUserByUserId(@Param("user_id") Long user_id);

    User getUserByUserName(@Param("user_name") String user_name);

    void insertUser(@Param("user") User user);

    Long getIdByUserName(@Param("username") String username);

    List<User> findAllUser();

    // Sql实现分页查询ffffFFsa
    // 这是一个普通的查找全部记录的查询语句, 分页插件会拦截查询请求，并读取前台传来的分页查询参数重新生成分页查询语句。
    List<User> findUserWithPage();

}
