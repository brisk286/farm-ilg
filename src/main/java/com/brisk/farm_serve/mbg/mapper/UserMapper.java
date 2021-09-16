package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserById(@Param("user_id") Long user_id);

//    void changeNameById(@Param("id") String id, @Param("employee") Employee employee);
//
//    void insertEmployee(@Param("employee") Employee employee);
//
//    void deleteEmployee(@Param("id") String id);
}
