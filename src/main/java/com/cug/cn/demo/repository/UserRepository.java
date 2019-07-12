package com.cug.cn.demo.repository;


import com.cug.cn.demo.domain.User;

import java.util.List;

/**
 * User Repository 接口.
 *
 * @author wzhp
 */
public interface UserRepository {

    /**
     * 创建或者修改用户
     *
     * @param user the user
     * @return user user
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id the id
     */
    void deleteUser(Long id);

    /**
     * 根据 id 查询用户
     *
     * @param id the id
     * @return the user by id
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     *
     * @param
     * @return the list
     */
    List<User> listUser();
}
