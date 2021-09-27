package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    Long findIdByRoleName(@Param("role_name") String role_name);

    Role getRoleById(@Param("role_id") Long role_id);

}
