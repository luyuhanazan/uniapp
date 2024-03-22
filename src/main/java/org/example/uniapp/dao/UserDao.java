package org.example.uniapp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.uniapp.entity.User;

/**
 * (User)表数据库访问层
 *
 * @author 12444
 * @since 2024-03-21 10:56:42
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

