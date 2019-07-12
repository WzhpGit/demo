package com.cug.cn.demo.domain;

/**
 * User 实体.
 *
 * @author wzhp
 */
public class User {
    /**
     * 实体一个唯一标识
     */
    private Long id;
    private String name;
    private String email;

    /**
     * Instantiates a new User.
     * 无参构造函数
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id    the id
     * @param name  the name
     * @param email the email
     */
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
