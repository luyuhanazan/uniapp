package org.example.uniapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.uniapp.entity.User;
import org.example.uniapp.util.Result;

import javax.servlet.http.HttpSession;

/**
 * (User)表服务接口
 *
 * @author 12444
 * @since 2024-03-21 10:56:42
 */
public interface UserService extends IService<User> {

    Boolean updatePassword(String password);

    Boolean setDiet(String diet);

    Result login(String username, String password, String code);

    Result register(String username, String password, String code);


}

