package com.brisk.farm_serve.pojo.po;

import com.brisk.farm_serve.pojo.AbstractAuditBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Role extends AbstractAuditBase {

    private Long roleId;
    private String roleName;
    private String roleDescription;

    private List<UserRole> userRoles = new ArrayList<>();

    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }
}
