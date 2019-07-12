package com.cug.cn.demo.controller;

import com.cug.cn.demo.domain.User;
import com.cug.cn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * User 控制器.
 *
 * @author wzhp
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUser());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据 id 查询用户
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新增或修改用户
     *
     * @param user the user
     * @return the model and view
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users", "userModel", user);
    }

    /**
     * 获取删除用户
     *
     * @param id the id
     * @return the model and view
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
        // 重定向到 List 页面
        return new ModelAndView("redirect:/users");
    }

    /**
     * 获取修改用户的界面
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
