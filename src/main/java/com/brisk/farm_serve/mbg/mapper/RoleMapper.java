package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.Role;
import com.brisk.farm_serve.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface RoleMapper {

    Long findIdByRoleName(@Param("role_name") String role_name);

    Role getRoleById(@Param("role_id") Long role_id);

}
