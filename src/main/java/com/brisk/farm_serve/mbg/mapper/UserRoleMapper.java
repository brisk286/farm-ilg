package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.User;
import com.brisk.farm_serve.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

public interface UserRoleMapper {

    void insertUserRole(@Param("userRole") UserRole userRole);

    List<String> getRoleNamesByUserId(@Param("userId") Long userId);

}
