package org.example.uniapp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.uniapp.entity.Advice;

/**
 * (Advice)表数据库访问层
 *
 * @author 12444
 * @since 2024-03-21 10:56:40
 */
@Mapper
public interface AdviceDao extends BaseMapper<Advice> {

}

