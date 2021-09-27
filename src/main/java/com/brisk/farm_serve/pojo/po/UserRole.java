package com.brisk.farm_serve.pojo.po;

import com.brisk.farm_serve.pojo.AbstractAuditBase;
import com.brisk.farm_serve.pojo.po.Role;
import com.brisk.farm_serve.pojo.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRole extends AbstractAuditBase implements Serializable {

//    private Long id;

    private Long userId;

    private Long roleId;

    private User user;

    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}

