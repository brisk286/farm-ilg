package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.bo.PageRequest;
import com.brisk.farm_serve.pojo.bo.PageResult;
import com.brisk.farm_serve.pojo.po.User;
import com.brisk.farm_serve.pojo.po.UserRole;
import com.brisk.farm_serve.enums.RoleType;
import com.brisk.farm_serve.exception.UserNameAlreadyExistException;
import com.brisk.farm_serve.mbg.mapper.RoleMapper;
import com.brisk.farm_serve.mbg.mapper.UserMapper;
import com.brisk.farm_serve.mbg.mapper.UserRoleMapper;
import com.brisk.farm_serve.pojo.bo.UserRegisterRequest;
import com.brisk.farm_serve.service.UserService;
import com.brisk.farm_serve.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.ImmutableMap;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERNAME = "username:";

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    UserRoleMapper userRoleMapper;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    // 导致事务回滚的异常类
    @Transactional
    @Override
    public void save(UserRegisterRequest userRegisterRequest) {
        // 确保User不存在
        ensureUserNameNotExist(userRegisterRequest.getUserName());
        // 从注册请求中创建User
        User user = userRegisterRequest.toUser();
        // user设置为加密密码
        user.setPassword(bCryptPasswordEncoder.encode(userRegisterRequest.getPassword()));
        // 将User保存到数据库
        userMapper.insertUser(user);
        // 给用户绑定两个角色：用户和管理者
        // 从Role数据库中获取User角色、Manager角色的role_id
        Long roleUserId = roleMapper.findIdByRoleName(RoleType.USER.getName());
        Long roleManageId = roleMapper.findIdByRoleName(RoleType.MANAGER.getName());
        // 存储UserRole表中
        // （对应user_id， role_id)
        userRoleMapper.insertUserRole(new UserRole(user.getUser_id(), roleUserId));
        userRoleMapper.insertUserRole(new UserRole(user.getUser_id(), roleManageId));
    }

    @Override
    public List<SimpleGrantedAuthority> getRoles(User user) {
        List<String> roleNames = userRoleMapper.getRoleNamesByUserId(user.getUser_id());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roleNames.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
        return authorities;
    }

    @Override
    public PageResult findUserWithPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<User> getPageInfo(PageRequest pageRequest) {
        // 当前页码
        int pageNum = pageRequest.getPageNum();
        // 每页数量
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userMapper.findUserWithPage();
        // 包装Page对象
        return new PageInfo<User>(sysMenus);
    }
    @Override
    public boolean check(String currentPassword, String password) {
        return this.bCryptPasswordEncoder.matches(currentPassword, password);
    }

    @Override
    public void ensureUserNameNotExist(String userName) {
        if (userMapper.getUserByUserName(userName) != null) {
            throw new UserNameAlreadyExistException(ImmutableMap.of(USERNAME, userName));
        }
    }

    @Override
    public User findUserByUserName(String username){
        return userMapper.getUserByUserName(username);
    }
}

