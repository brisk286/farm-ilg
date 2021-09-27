package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {

    void insertUserRole(@Param("userRole") UserRole userRole);

    List<String> getRoleNamesByUserId(@Param("userId") Long userId);

}
