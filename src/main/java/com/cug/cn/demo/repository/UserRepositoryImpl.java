package com.cug.cn.demo.repository;

import com.cug.cn.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User repository implementation.
 *
 * @author wzhp
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    /**
     * 存储用户信息的容器
     */
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    /**
     * 记录用户 id
     */
    private static AtomicLong counter = new AtomicLong();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        // 新建 id
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<User>(this.userMap.values());
    }
}
