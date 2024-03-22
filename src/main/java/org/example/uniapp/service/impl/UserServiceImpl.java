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
}

