package org.example.uniapp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.uniapp.common.MySessionContext;
import org.example.uniapp.entity.User;
import org.example.uniapp.service.UserService;
import org.example.uniapp.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

import static org.example.uniapp.util.Result.success;

/**
 * (User)表控制层
 *
 * @author 12444
 * @since 2024-03-21 10:56:42
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     */
    @GetMapping()
    public Result selectOne() {
        HttpSession session = MySessionContext.getSession();
        User user = (User)session.getAttribute("user");
        return success(this.userService.getById(user.getId()));
    }


    /**
     * 修改数据
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 修改密码
     */
    @GetMapping("updatePassword")
    public Result updatePassword(String password) {
        return success(this.userService.updatePassword(password));
    }

    /**
     * 设置饮食偏好
     */
    @GetMapping("setDiet")
    public Result setDiet(String diet) {
        return success(this.userService.setDiet(diet));
    }

    /**
     * 登录
     */
    @GetMapping("login")
    public Result login(String username, String password, String code) {
        return this.userService.login(username, password, code);
    }
}

