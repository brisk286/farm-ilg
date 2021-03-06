package com.brisk.farm_serve.pojo.bo;

import com.brisk.farm_serve.pojo.po.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


/**
 * JWT用户对象 实现了UserDetails
 * @author shuang.kou
 * @description
 */
@Data
@NoArgsConstructor
public class JwtUser implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;


    /**
     * 通过 user 对象创建jwtUser
     */
    public JwtUser(User user) {
        id = user.getUser_id();
        username = user.getUser_name();
        password = user.getPassword();
        enabled = user.getEnable() == null ? true : user.getEnable();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

}
