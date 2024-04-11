package org.example.uniapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.uniapp.common.MySessionContext;
import org.example.uniapp.dao.UserDao;
import org.example.uniapp.entity.User;
import org.example.uniapp.service.UserService;
import org.example.uniapp.util.Result;
import org.example.uniapp.util.ValidateCode;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import javax.servlet.http.HttpSession;

/**
 * (User)表服务实现类
 *
 * @author 12444
 * @since 2024-03-21 10:56:42
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public Boolean updatePassword(String password) {
        HttpSession session = MySessionContext.getSession();
        assert session != null;
        User user = (User) session.getAttribute("user");
        return this.lambdaUpdate()
                .set(User::getPassword, password).eq(User::getId, user.getId()).update();

    }

    @Override
    public Boolean setDiet(String diet) {
        HttpSession session = MySessionContext.getSession();
        assert session != null;
        User user = (User) session.getAttribute("user");
        return this.lambdaUpdate().set(User::getDietaryPreference, diet)
                .eq(User::getId, user.getId()).update();
    }

    @Override
    public Result login(String username, String password, String code) {
        HttpSession session = MySessionContext.getSession();
        assert session != null;
        String validate = session.getAttribute(ValidateCode.SESSION_KEY).toString();
        if (validate.equalsIgnoreCase(code)) {
            User user = this.getOne(new UpdateWrapper<User>()
                    .eq("nickname", username)
                    .eq("password", password));
            if (user != null) {
                session.setAttribute("user", user);
                return Result.success(200, validate,user);
            } else {
                return Result.fail("用户名或密码错误");
            }
        } else {
            return Result.fail("验证码错误");
        }
    }

    @Override
    public Result register(String username, String password, String code) {
        HttpSession session = MySessionContext.getSession();
        assert session != null;

        // 检查验证码是否存在
        String validate = session.getAttribute(ValidateCode.SESSION_KEY).toString();
        if (validate == null) {
            return Result.fail("验证码不存在");
        }

        // 检查验证码是否正确
        if (!validate.equalsIgnoreCase(code)) {
            return Result.fail("验证码错误");
        }

        // 检查用户名是否已存在
        User existingUser = this.getOne(new QueryWrapper<User>().eq("nickname", username));
        if (existingUser != null) {
            return Result.fail("用户名已存在");
        }

        // 创建新用户对象
        User newUser = new User();
        newUser.setNickname(username);
        newUser.setPassword(password);

        // 保存新用户到数据库
        boolean saved = this.save(newUser);
        if (saved) {
            return Result.success("注册成功");
        } else {
            return Result.fail("注册失败，请稍后重试");
        }
    }

}

